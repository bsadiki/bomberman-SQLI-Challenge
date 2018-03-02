package ma.sqli.test.entities.items.rock;

import static ma.sqli.test.configuration.Configuration.EXPLOSED_STAR_ROCK;

public class StarRock extends Rock {
    @Override
    public void exploid() {
        content = EXPLOSED_STAR_ROCK;
    }
}
