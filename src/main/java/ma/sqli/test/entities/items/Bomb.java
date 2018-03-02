package ma.sqli.test.entities.items;

import ma.sqli.test.entities.Map.Map;
import ma.sqli.test.entities.items.rock.EnhancerRock;
import ma.sqli.test.entities.items.rock.SimpleRock;
import ma.sqli.test.entities.items.rock.StarRock;

import static ma.sqli.test.configuration.Configuration.BOMB;

public class Bomb extends Item {
    int power;

    public Bomb(int power) {
        content = BOMB;
        this.power = power;
    }

    public void exploidMap(Map map, int x, int y) {
        for (int i = x - power; i <= x + power; i++) {
            exploidPosition(map, i, y);
        }
        for (int i = y - power; i <= y + power; i++) {
            exploidPosition(map, x, i);
        }
    }

    private void exploidPosition(Map map, int x, int y) {
        try {
            if(map.getPositions()[x][y].getItem() instanceof Bomb)
                map.addItemToPosition(new Item(),x,y);
            if(map.getPositions()[x][y].getItem() instanceof Bomberman){
                Bomberman bomberman = (Bomberman)map.getPositions()[x][y].getItem();
                bomberman.killBomberMan();
            }
            if(map.getPositions()[x][y].getItem() instanceof SimpleRock)
                map.addItemToPosition(new Item(),x,y);
            if(map.getPositions()[x][y].getItem() instanceof EnhancerRock){
                EnhancerRock enhancerRock = (EnhancerRock)map.getPositions()[x][y].getItem();
                enhancerRock.exploid();
            }
            if(map.getPositions()[x][y].getItem() instanceof StarRock){
                StarRock starRock = (StarRock)map.getPositions()[x][y].getItem();
                starRock.exploid();
            }

        }catch (ArrayIndexOutOfBoundsException e){

        }

    }
}
