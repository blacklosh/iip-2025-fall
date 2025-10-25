package codewars.impl.models;

import java.awt.*;

public class TargetEntity extends GameEntity implements Targetable {

    public TargetEntity(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.GREEN;
        this.image = null;
    }

}
