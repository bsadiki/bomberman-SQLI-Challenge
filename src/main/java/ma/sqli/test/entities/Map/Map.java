package ma.sqli.test.entities.Map;

import ma.sqli.test.entities.items.Bomb;
import ma.sqli.test.entities.items.Item;

public class Map {
    private Position[][] positions;

    public Map(Position[][] positions) {
        this.positions = positions;
    }

    public String draw() {
        StringBuilder drawBuilder = new StringBuilder();
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                drawBuilder.append(positions[i][j].getcontent());
            }
            if (i != positions.length - 1)
                drawBuilder.append("\n");
        }

        return drawBuilder.toString();
    }

    public void trigger() {
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                if (positions[i][j].getItem() instanceof Bomb){
                    Bomb bomb = (Bomb) positions[i][j].getItem();
                    bomb.exploidMap(this,i,j);
                }
            }
        }
    }

    public void addItemToPosition(Item item, int x, int y) {
        positions[x][y].setItem(item);
    }

    public Position[][] getPositions() {
        return positions;
    }
}
