package ma.sqli.test.entities.items;

import ma.sqli.test.configuration.Configuration;
import ma.sqli.test.entities.Map.Map;
import ma.sqli.test.entities.items.rock.EnhancerRock;
import ma.sqli.test.entities.items.rock.StarRock;
import ma.sqli.test.moving.Direction;
import ma.sqli.test.moving.MovingHandler;

public class Bomberman extends Item {
    String name;
    int bombPower;
    int movingPower;
    Direction direction;
    Map map;
    int[] position;
    boolean hasJustPutABomb;

    public Bomberman(String name) {
        this.name = name;
        content = String.valueOf(name.toLowerCase().charAt(0));
        bombPower = 1;
        movingPower = 1;
        direction = Direction.RIGHT;
        position = new int[2];
        hasJustPutABomb = false;
    }

    public void startIn(Map map) {

        map.addItemToPosition(this, position[0], position[1]);
        this.map = map;
    }

    public Bomberman forward() {
        int movingPower = this.movingPower;
        for (int i = 0; i < movingPower; i++){
            int x = position[0];
            int y = position[1];
            move(x, y);
        }
        return this;
    }

    private void move(int x, int y) {
        switch (direction) {
            case RIGHT: {
                position[0] = x;
                position[1] = y + 1;
                break;
            }
            case DOWN: {
                position[0] = x + 1;
                position[1] = y;
                break;
            }
            case LEFT: {
                position[0] = x;
                position[1] = y - 1;
                break;
            }
            case UP: {
                position[0] = x - 1;
                position[1] = y;
                break;
            }
        }
        enhanceMoving();
        enhanceBombingPower();
        map.addItemToPosition(this, position[0], position[1]);
        if (!hasJustPutABomb) {
            map.addItemToPosition(new Item(), x, y);
        } else
            hasJustPutABomb = false;
    }

    private void enhanceBombingPower() {
        if(map.getPositions()[position[0]][position[1]].getItem() instanceof EnhancerRock){
            EnhancerRock rock = (EnhancerRock) map.getPositions()[position[0]][position[1]].getItem();
            bombPower = rock.getRangeEnhancer();
        }
    }

    private void enhanceMoving() {
        if(map.getPositions()[position[0]][position[1]].getItem() instanceof StarRock)
            movingPower = 2;
    }

    public Bomberman right() {
        direction = MovingHandler.moveRight(direction);
        return this;
    }

    public Bomberman bomb() {
        Bomb bomb = new Bomb(bombPower);
        int x = position[0];
        int y = position[1];
        map.addItemToPosition(bomb, x, y);
        hasJustPutABomb = true;
        return this;
    }

    public Bomberman left() {
        direction = MovingHandler.moveLeft(direction);
        return this;
    }

    public void killBomberMan() {
        content = Configuration.DEAD_BOMBER_MAN;
    }

}
