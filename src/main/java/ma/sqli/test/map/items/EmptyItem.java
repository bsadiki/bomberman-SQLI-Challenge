package ma.sqli.test.map.items;

import static ma.sqli.test.configuration.Configuration.EMPTY;

public class EmptyItem extends Item {
    @Override
    public Item explode() {
        return this;
    }

    @Override
    public String draw() {
        return EMPTY;
    }
}
