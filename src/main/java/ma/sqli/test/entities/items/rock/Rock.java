package ma.sqli.test.entities.items.rock;

import ma.sqli.test.entities.items.Item;

import static ma.sqli.test.configuration.Configuration.EMPTY;
import static ma.sqli.test.configuration.Configuration.ROCK;

public abstract class Rock extends Item {


    public Rock() {
        content = ROCK;
    }

    public  void exploid(){
        content = EMPTY;
    }

}
