package ma.sqli.test.entities.Map;

import ma.sqli.test.entities.items.Item;

public  class Position {
    private Item item;

    public Position() {
        item = new Item();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    public String getcontent(){
        return item.getContent();
    }
}
