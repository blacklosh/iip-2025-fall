package codewars.impl.frame;

import codewars.impl.cmd.Constants;
import codewars.impl.cmd.Face;
import codewars.impl.models.GameEntity;
import codewars.impl.models.WorldEntity;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final WorldEntity world;

    public GamePanel(WorldEntity w) {
        world = w;
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        gr.setColor(Color.WHITE);
        Dimension dm = world.getWorldSize();
        gr.fillRect(0, 0, dm.width, dm.height);

        if(world.hasBackground()) {
            gr.drawImage(world.getBackground(), 0, 0, dm.width, dm.height, null);
        }

        gr.setColor(Color.LIGHT_GRAY);
        for (int i = Constants.BLOCK_SIZE - 1; i < dm.width * Constants.BLOCK_SIZE; i+=Constants.BLOCK_SIZE) {
            gr.fillRect(i, 0, 1, dm.height * Constants.BLOCK_SIZE);
        }
        for (int i = Constants.BLOCK_SIZE - 1; i < dm.height * Constants.BLOCK_SIZE; i+=Constants.BLOCK_SIZE) {
            gr.fillRect(0, i, dm.width * Constants.BLOCK_SIZE, 1);
        }

        for(GameEntity e : world.getObjects()) {
            if (e.hasImage()) {
                gr.drawImage(e.getImage(), e.getX(), e.getY(), e.getWidth(), e.getHeight(), null);
            } else {
                gr.setColor(e.getColor());
                gr.fillRect(e.getX(), e.getY(), e.getWidth(), e.getHeight());
            }
            if (e.hasFacing()) {
                gr.setColor(Color.MAGENTA);
                if (Face.UP.equals(e.getFace())) {
                    gr.fillRect(e.getX(), e.getY(), e.getWidth(), Constants.BLOCK_SIZE / 5);
                } else if (Face.DOWN.equals(e.getFace())) {
                    gr.fillRect(e.getX(), e.getY() + Constants.BLOCK_SIZE * 4 / 5, e.getWidth(), Constants.BLOCK_SIZE / 5 - 1);
                } else if (Face.LEFT.equals(e.getFace())) {
                    gr.fillRect(e.getX(), e.getY(), Constants.BLOCK_SIZE / 5, e.getHeight());
                } else {
                    gr.fillRect(e.getX() + Constants.BLOCK_SIZE * 4 / 5, e.getY(), Constants.BLOCK_SIZE / 5 - 1, e.getHeight());
                }
            }
        }

        repaint();
    }

}
