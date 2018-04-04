package ma.sqli.test.map.position.moving;

import ma.sqli.test.map.position.Position;

public class MovingVector {
    private final int x;
    private final int y;

    public MovingVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MovingVector turnRight() {
        return new MovingVector(y, -x);
    }

    public MovingVector turnLeft() {
        return new MovingVector(-y, x);

    }

    public Position movePosition(Position position) {
        return new Position(position.x + this.x, position.y + this.y);
    }
}
