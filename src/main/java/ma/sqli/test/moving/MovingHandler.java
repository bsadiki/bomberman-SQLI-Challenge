package ma.sqli.test.moving;

public class MovingHandler {
    public static Direction moveRight(Direction initialDirection){
        switch (initialDirection){
            case UP: return Direction.RIGHT;
            case RIGHT: return Direction.DOWN;
            case DOWN: return Direction.LEFT;
            case LEFT: return Direction.UP;
        }
        return null;
    }
    public static Direction moveLeft(Direction initialDirection){
        switch (initialDirection){
            case UP: return Direction.LEFT;
            case RIGHT: return Direction.UP;
            case DOWN: return Direction.RIGHT;
            case LEFT: return Direction.DOWN;
        }
        return null;
    }
}
