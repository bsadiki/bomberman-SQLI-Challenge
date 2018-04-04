package ma.sqli.test.map;

import ma.sqli.test.map.position.Position;
import ma.sqli.test.map.items.Bomb;
import ma.sqli.test.map.items.EmptyItem;
import ma.sqli.test.map.items.Item;
import ma.sqli.test.map.items.rock.EnhancerRock;
import ma.sqli.test.map.items.rock.Rock;
import ma.sqli.test.map.items.rock.SimpleRock;
import ma.sqli.test.map.items.rock.StarRock;

import java.util.ArrayList;
import java.util.List;


public class MapBuilder {
    private final Map map;
    public MapBuilder(int length) {
        Item[][] itemsMatrix = createItemsMatrix(length);
        List<Bomb> bombs = new ArrayList<>();
        map = new Map(itemsMatrix, bombs);
    }

    private Item[][] createItemsMatrix(int length) {
        Item[][] itemsMatrix=new Item[length][length];
        for (int i =0; i<length; i++){
            for (int j = 0; j<length;j++)
                itemsMatrix[i][j]= new EmptyItem();
        }
        return itemsMatrix;
    }

    public MapBuilder addRock(int x, int y) {
        SimpleRock simpleRock = new SimpleRock();
        map.addItemToPosition(simpleRock,new Position(x,y));
        return this;
    }

    public Map build() {
        return map;
    }

    public MapBuilder addStarRock(int x, int y) {
        StarRock starRock = new StarRock();
        map.addItemToPosition(starRock,new Position(x,y));
        return this;
    }

    public MapBuilder addEnhancerRock(int x, int y, int rangeEnhancer) {
        EnhancerRock enhancerRock = new EnhancerRock(rangeEnhancer);
        map.addItemToPosition(enhancerRock,new Position(x,y));
        return this;
    }
}
