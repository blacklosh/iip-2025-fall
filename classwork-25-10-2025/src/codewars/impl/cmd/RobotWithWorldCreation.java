package codewars.impl.cmd;

import codewars.api.Robot;
import codewars.api.Rotation;
import codewars.impl.exceptions.GameException;
import codewars.impl.exceptions.NotEnoughTargetsException;
import codewars.impl.exceptions.StoneInterruptedException;
import codewars.impl.frame.GameFrame;
import codewars.impl.frame.GamePanel;
import codewars.impl.models.*;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RobotWithWorldCreation extends GameEntity implements Robot {

    private int speed = 10;

    private final WorldEntity world;

    private int collectedItemsCount = 0;

    private int totalItemsCount;

    public RobotWithWorldCreation(String filename) {
        int windowWidth = 800;
        int windowHeight = 600;
        int defaultBlockSize = 50;
        File config = new File(filename);
        try {
            BufferedReader br = new BufferedReader(new FileReader(config));
            String[] line = br.readLine().split(" ");
            windowWidth = Integer.parseInt(line[0]);
            windowHeight = Integer.parseInt(line[1]);
            defaultBlockSize = Integer.parseInt(line[2]);
            totalItemsCount = Integer.parseInt(line[3]);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Ошибка",
                    "Неправильный формат файла карты",
                    JOptionPane.ERROR_MESSAGE);
        }
        Constants.BLOCK_SIZE = defaultBlockSize;
        Dimension dm = new Dimension(windowWidth, windowHeight);
        world = new WorldEntity(config);
        x = world.getPlayerStartPosX();
        y = world.getPlayerStartPosY();
        width = Constants.BLOCK_SIZE - 1;
        height = Constants.BLOCK_SIZE - 1;

        face = world.getPlayerStartFace();
        color = Color.ORANGE;

        world.getObjects().add(this);

        new Thread(() -> {
            GamePanel gamePanel = new GamePanel(world);
            GameFrame gameFrame = new GameFrame(gamePanel, dm);
            gameFrame.setVisible(true);
        }).start();

        sleep(100);

        System.out.println("-=========== COMMANDS LOG ===========-");
    }

    @Override
    public void move(int steps) {
        try {
            System.out.println("robot.move("+steps+")");
            for (int i = 0; i < steps * Constants.BLOCK_SIZE; i++) {
                sleep(1);
                for (GameEntity e : world.getObjects()) {
                    if (!Impassable.class.isAssignableFrom(e.getClass())) continue;
                    Rectangle other = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());
                    Rectangle player = new Rectangle(this.x, this.y, this.width, this.height);
                    if (player.intersects(other)) {
                        throw new StoneInterruptedException();
                    }
                }
                if (Face.UP.equals(face)) {
                    y--;
                } else if (Face.RIGHT.equals(face)) {
                    x++;
                } else if (Face.DOWN.equals(face)) {
                    y++;
                } else {
                    x--;
                }
            }
        } catch (GameException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        List<GameEntity> toRemove = new ArrayList<>();
        for (GameEntity e : world.getObjects()) {
            if (!Targetable.class.isAssignableFrom(e.getClass())) continue;
            Rectangle other = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());
            Rectangle player = new Rectangle(this.x, this.y, this.width, this.height);
            if (player.intersects(other)) {
                toRemove.add(e);
            }
        }
        collectedItemsCount += toRemove.size();
        world.getObjects().removeAll(toRemove);
    }

    @Override
    public void rotate(Rotation rotation) {
        System.out.println("robot.rotate("+rotation+")");
        sleep(25);
        if(Rotation.LEFT.equals(rotation)) {
            if(Face.UP.equals(face)) {
                face = Face.LEFT;
            } else if(Face.LEFT.equals(face)) {
                face = Face.DOWN;
            } else if(Face.DOWN.equals(face)) {
                face = Face.RIGHT;
            } else {
                face = Face.UP;
            }
        } else {
            if(Face.UP.equals(face)) {
                face = Face.RIGHT;
            } else if(Face.RIGHT.equals(face)) {
                face = Face.DOWN;
            } else if(Face.DOWN.equals(face)) {
                face = Face.LEFT;
            } else {
                face = Face.UP;
            }
        }
        sleep(25);
    }

    @Override
    public boolean hasObstacle() {
        boolean result = false;
        int tmpX = x;
        int tmpY = y;
        if(Face.UP.equals(face)) {
            tmpY-=2;
        } else if(Face.RIGHT.equals(face)) {
            tmpX+=2;
        } else if(Face.DOWN.equals(face)) {
            tmpY+=2;
        } else {
            tmpX-=2;
        }
        for (GameEntity e : world.getObjects()) {
            if (!Impassable.class.isAssignableFrom(e.getClass())) continue;
            Rectangle other = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());
            Rectangle player = new Rectangle(tmpX, tmpY, this.width, this.height);
            if (player.intersects(other)) {
                result = true;
                break;
            }
        }
        System.out.println("robot.hasObstacle() == " + result);
        return result;
    }

    @Override
    public int collectedItemsCount() {
        System.out.println("robot.collectedItemsCount() == " + collectedItemsCount);
        return collectedItemsCount;
    }

    @Override
    public int totalItemsCount() {
        System.out.println("robot.totalItemsCount() == " + totalItemsCount);
        return totalItemsCount;
    }

    @Override
    public void finish() {
        System.out.println("robot.finish()");
        try {
            sleep(100);
            for (GameEntity e : world.getObjects()) {
                if (Targetable.class.isAssignableFrom(e.getClass())) {
                    throw new NotEnoughTargetsException();
                }
            }
            JOptionPane.showMessageDialog(null, "Победа", "Все цели достигнуты!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } catch (GameException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void sleep(int m) {
        try {
            Thread.sleep((long) m * (10 - speed));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void setSpeed(int speed) {
        if(speed <= 0) {
            this.speed = 1;
        } else this.speed = Math.min(speed, 10);
    }
}
