package ma.sqli.test.map.items.rock;

import ma.sqli.test.map.items.Item;

import static ma.sqli.test.configuration.Configuration.ROCK;

public abstract class Rock extends Item {
    @Override
    public String draw() {
        return ROCK;
    }
}
