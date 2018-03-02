package ma.sqli.test.entities.items.rock;

public class EnhancerRock extends Rock {
    private int rangeEnhancer;

    public EnhancerRock(int rangeEnhancer) {
        this.rangeEnhancer = rangeEnhancer;
    }

    @Override
    public void exploid() {
        content = String.valueOf(rangeEnhancer);
    }

    public int getRangeEnhancer() {
        return rangeEnhancer;
    }
}
