package ma.sqli.test.map.items.rock;

import ma.sqli.test.map.items.Item;

import static ma.sqli.test.configuration.Configuration.EXPLODED_STAR_ROCK;

public class StarRock extends Rock {
    private boolean exploded;

    public StarRock() {
        exploded = false;
    }

    @Override
    public Item explode() {
        exploded = true;
        return this;
    }

    @Override
    public String draw() {
        if (!exploded)
            return super.draw();
        return EXPLODED_STAR_ROCK;
    }
}
