package codewars.impl.models;

import java.awt.*;

public class StoneEntity extends GameEntity implements Impassable {

    public StoneEntity(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.BLACK;
        this.image = null;
    }

}
