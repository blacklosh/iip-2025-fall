package codewars.impl.models;

import codewars.impl.cmd.Constants;
import codewars.impl.cmd.Face;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WorldEntity {

    private final List<GameEntity> objects = new CopyOnWriteArrayList<>();

    private int worldWidth;
    private int worldHeight;
    private Dimension worldSize;

    private Image background;

    private int playerStartPosX;
    private int playerStartPosY;
    private Face playerStartFace;

    // Создание рандомного мира
    public WorldEntity(Dimension dm) {
        worldWidth = dm.width;
        worldHeight = dm.height;
        worldSize = new Dimension(worldWidth, worldHeight);

        // Сделаем какой-нибудь фон
        try {
            background = ImageIO.read(new File("c://fon.jpg"));
        } catch (IOException e) {
            background = null;
        }

        // Сделаем края слева по вертикали
        for (int i = Constants.BLOCK_SIZE; i < worldHeight - Constants.BLOCK_SIZE; i+= Constants.BLOCK_SIZE) {
            objects.add(new StoneEntity(0, i));
        }

        // Сделаем края справа по вертикали
        for (int i = Constants.BLOCK_SIZE; i < worldHeight - Constants.BLOCK_SIZE; i+= Constants.BLOCK_SIZE) {
            objects.add(new StoneEntity((worldWidth / Constants.BLOCK_SIZE - 1) * (Constants.BLOCK_SIZE), i));
        }

        // Сделаем края сверху по горизонтали
        for (int i = 0; i < worldWidth; i+= Constants.BLOCK_SIZE) {
            objects.add(new StoneEntity(i, 0));
        }

        // Сделаем края сверху по горизонтали
        for (int i = 0; i < worldWidth; i+= Constants.BLOCK_SIZE) {
            objects.add(new StoneEntity(i, (worldHeight / Constants.BLOCK_SIZE - 1) * (Constants.BLOCK_SIZE)));
        }

        objects.add(new StoneEntity(150, 200));

        // Добавим цели
        objects.add(new TargetEntity(100, 50));
        objects.add(new TargetEntity(50, 100));

        objects.add(new TargetEntity(500, 500));
    }

    // Создание мира из конфиг файла
    public WorldEntity(File config) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(config));
            br.readLine();
            String[] line = br.readLine().split(" ");
            int w = Integer.parseInt(line[0]);
            int h = Integer.parseInt(line[1]);
            String defaultFace = line[2];
            playerStartFace = Face.valueOf(defaultFace);
            worldWidth = w;
            worldHeight = h;
            worldSize = new Dimension(w, h);
            for (int i = 0; i < h; i++) {
                line = br.readLine().split(" ");
                int x = 0;
                for(String obj : line) {
                    int type = Integer.parseInt(obj);
                    if(type == 1) {
                        // Это стена
                        objects.add(new StoneEntity(x * Constants.BLOCK_SIZE, i * Constants.BLOCK_SIZE));
                    } else if(type == 2) {
                        // Это игрок
                        playerStartPosX = x * Constants.BLOCK_SIZE;
                        playerStartPosY = i * Constants.BLOCK_SIZE;
                    } else if(type == 3) {
                        // Это цель
                        objects.add(new TargetEntity(x * Constants.BLOCK_SIZE, i * Constants.BLOCK_SIZE));
                    }
                    x++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Ошибка",
                    "Невозможно считать файл. Правильно ли указан путь? e=" + e.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public List<GameEntity> getObjects() {
        return objects;
    }

    public Dimension getWorldSize() {
        return worldSize;
    }

    public boolean hasBackground() {
        return background != null;
    }

    public Image getBackground() {
        return background;
    }

    public int getPlayerStartPosX() {
        return playerStartPosX;
    }

    public int getPlayerStartPosY() {
        return playerStartPosY;
    }

    public Face getPlayerStartFace() {
        return playerStartFace;
    }
}
