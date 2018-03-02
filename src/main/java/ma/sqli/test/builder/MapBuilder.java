package ma.sqli.test.builder;

import ma.sqli.test.entities.Map.Map;
import ma.sqli.test.entities.Map.Position;
import ma.sqli.test.entities.items.rock.EnhancerRock;
import ma.sqli.test.entities.items.rock.Rock;
import ma.sqli.test.entities.items.rock.SimpleRock;
import ma.sqli.test.entities.items.rock.StarRock;


public class MapBuilder {
    Map map;
    public MapBuilder(int lenght) {
        Position[][] positions=new Position[lenght][lenght];
        for (int i =0; i<lenght; i++){
            for (int j = 0; j<lenght;j++)
                positions[i][j]= new Position();
        }
        map = new Map(positions);
    }

    public MapBuilder addRock(int x, int y) {
        Rock rock = new SimpleRock();
        map.addItemToPosition(rock,x,y);
        return this;
    }

    public Map build() {
        return map;
    }

    public MapBuilder addStarRock(int x, int y) {
        Rock rock = new StarRock();
        map.addItemToPosition(rock,x,y);
        return this;
    }

    public MapBuilder addEnhancerRock(int x, int y, int rangeEnhancer) {
        Rock rock = new EnhancerRock(rangeEnhancer);
        map.addItemToPosition(rock,x,y);
        return this;
    }
}
