package ma.sqli.test.entities.items.rock;

import ma.sqli.test.entities.items.Item;

import static ma.sqli.test.configuration.Configuration.EMPTY;

public abstract class Rock extends Item {


    public Rock() {
        content = "X";
    }

    public  void exploid(){
        content = EMPTY;
    }

}
