package ma.sqli.test.map.items.rock;

import ma.sqli.test.map.items.Item;

public class EnhancerRock extends Rock {
    private final int rangeEnhancer;
    private boolean exploded;
    public EnhancerRock(int rangeEnhancer) {
        this.rangeEnhancer = rangeEnhancer;
        exploded = false;
    }

    public int getRangeEnhancer() {
        return rangeEnhancer;
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
        return String.valueOf(rangeEnhancer);
    }
}
