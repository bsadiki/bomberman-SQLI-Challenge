package ma.sqli.test.map.items.rock;

import ma.sqli.test.map.items.EmptyItem;
import ma.sqli.test.map.items.Item;

public class SimpleRock extends Rock {
    @Override
    public Item explode() {
        return new EmptyItem();
    }

}
