package codewars.impl.models;

import codewars.impl.cmd.Constants;
import codewars.impl.cmd.Face;

import java.awt.*;

public abstract class GameEntity {

    private final long id = Constants.getNextId();

    protected Face face = Face.NO;

    protected int x;

    protected int y;

    protected int width = Constants.BLOCK_SIZE - 1;

    protected int height = Constants.BLOCK_SIZE - 1;

    protected Image image;

    protected Color color;

    public Face getFace() {
        return face;
    }

    public Image getImage() {
        return image;
    }

    public Color getColor() {
        return color;
    }

    public GameEntity() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean hasImage() {
        return image != null;
    }

    public boolean hasFacing() {
        return !Face.NO.equals(face);
    }

}
