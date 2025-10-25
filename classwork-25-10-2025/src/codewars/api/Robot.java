package codewars.api;

public interface Robot {

    void move(int steps);

    void rotate(Rotation rotation);

    boolean hasObstacle();

    int collectedItemsCount();

    int totalItemsCount();

    void finish();

    void setSpeed(int n);

}
