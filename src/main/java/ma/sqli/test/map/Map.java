package ma.sqli.test.map;

import ma.sqli.test.Drawable;
import ma.sqli.test.map.position.Position;
import ma.sqli.test.map.items.Bomb;
import ma.sqli.test.map.items.Item;

import java.util.List;

public class Map implements Drawable {
    private final Item[][] itemsMatrix;
    private final List<Bomb> bombs;

    public Map(Item[][] itemsMatrix, List<Bomb> bombs) {
        this.itemsMatrix = itemsMatrix;
        this.bombs = bombs;
    }

    public void trigger() {
        bombs.forEach(bomb -> bomb.explodeMap(this));
    }

    public void addBombToPosition(Bomb bomb, Position position) {
        addItemToPosition(bomb, position);
        bombs.add(bomb);
    }

    public void addItemToPosition(Item item, Position position) {
        itemsMatrix[position.x][position.y] = item;
    }

    public void explodePosition(Position position) {
        itemsMatrix[position.x][position.y] = itemsMatrix[position.x][position.y].explode();
    }

    public Item getItemFromCoordinates(Position position) {
        return itemsMatrix[position.x][position.y];
    }

    public boolean containsPosition(Position position) {
        return (itemsMatrix != null) && ((position.x >= 0 && position.x < itemsMatrix.length) && (position.y >= 0 && position.y < itemsMatrix[0].length));
    }

    @Override
    public String draw() {
        StringBuilder drawBuilder = new StringBuilder();
        for (int i = 0; i < itemsMatrix.length; i++) {
            drawBuilder.append(drawLine(itemsMatrix[i]));
            if (i != itemsMatrix.length - 1)
                drawBuilder.append("\n");
        }

        return drawBuilder.toString();
    }

    private String drawLine(Item[] items) {
        StringBuilder lineDrawer = new StringBuilder();
        for (int j = 0; j < this.itemsMatrix.length; j++) {
            lineDrawer.append(items[j].draw());
        }
        return lineDrawer.toString();
    }
}
