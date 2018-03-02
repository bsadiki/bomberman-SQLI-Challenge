package ma.sqli.test.entities.items;

import static ma.sqli.test.configuration.Configuration.EMPTY;

public class Item {
    protected String content;

    public Item() {
        content = EMPTY;
    }
    public String getContent() {
        return content;
    }
}
