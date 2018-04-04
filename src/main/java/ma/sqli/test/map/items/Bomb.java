package ma.sqli.test.map.items;

import ma.sqli.test.map.Map;
import ma.sqli.test.map.position.Position;

import static ma.sqli.test.configuration.Configuration.BOMB;

public class Bomb extends Item {
    private final int power;
    private Position position;

    public Bomb(int power, Position position) {
        this.power = power;
        this.position = position;
    }

    public void explodeMap(Map map) {
        for (int i = position.x - power; i <= position.x + power; i++) {
            if (map.containsPosition(new Position(i,position.y)))
                map.explodePosition(new Position(i,position.y));
        }
        for (int j = position.y - power; j <= position.y + power; j++) {
            if (map.containsPosition(new Position(position.x,j)))
                map.explodePosition(new Position(position.x,j));
        }
    }

    @Override
    public Item explode() {
        return new EmptyItem();
    }

    @Override
    public String draw() {
        return BOMB;
    }
}
