package ma.sqli.test.map.items;

import ma.sqli.test.map.Map;
import ma.sqli.test.map.items.rock.EnhancerRock;
import ma.sqli.test.map.items.rock.StarRock;
import ma.sqli.test.map.position.moving.MovingVector;
import ma.sqli.test.map.position.Position;

import static ma.sqli.test.configuration.Configuration.DEAD_BOMBER_MAN;

public class Bomberman extends Item {
    private String name;
    private int bombPower;
    private int movingPower;
    private MovingVector movingVector;
    private Map map;
    private Position position;
    private boolean hasJustPutABomb;
    private boolean isAlive;

    public Bomberman(String name) {
        this.name = name;
        bombPower = 1;
        movingPower = 1;
        movingVector = new MovingVector(0,1);
        position = new Position(0,0);
        hasJustPutABomb = false;
        isAlive = true;
    }

    public void startIn(Map map) {
        map.addItemToPosition(this, position);
        this.map = map;
    }

    public Bomberman forward() {
        int movingPower = this.movingPower;
        for (int i = 0; i < movingPower; i++) {
            move();
        }
        return this;
    }

    private void move() {
        Position oldPosition = this.position;
        this.position = movingVector.movePosition(position);
        enhanceMoving();
        enhanceBombingPower();
        map.addItemToPosition(this, this.position);
        if (!hasJustPutABomb) {
            map.addItemToPosition(new EmptyItem(), oldPosition);
        } else
            hasJustPutABomb = false;
    }

    private void enhanceBombingPower() {
        if (map.getItemFromCoordinates(position) instanceof EnhancerRock) {
            EnhancerRock rock = (EnhancerRock) map.getItemFromCoordinates(position);
            bombPower = rock.getRangeEnhancer();
        }
    }

    private void enhanceMoving() {
        if (map.getItemFromCoordinates(position) instanceof StarRock)
            movingPower = 2;
    }

    public Bomberman right() {
        this.movingVector = movingVector.turnRight();
        return this;
    }

    public Bomberman left() {
        this.movingVector = movingVector.turnLeft();
        return this;
    }

    public Bomberman bomb() {
        Bomb bomb = new Bomb(bombPower, new Position(position));
        map.addBombToPosition(bomb, position);
        hasJustPutABomb = true;
        return this;
    }

    public void killBomberMan() {
        isAlive = false;
    }

    @Override
    public Item explode() {
        killBomberMan();
        return this;
    }

    @Override
    public String draw() {
        if (isAlive)
            return String.valueOf(name.toLowerCase().charAt(0));
        return DEAD_BOMBER_MAN;
    }
}
