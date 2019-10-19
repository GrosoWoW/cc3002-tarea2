package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.Fighter;

public class FighterFactory extends AbstractUnitFactory {

    private Field map;

    public FighterFactory(Field map) {
        super(map);
        this.map = map;
    }


    public Fighter create(int hitPoints, int x, int y, IEquipableItem... items){

        return new Fighter(hitPoints, 1, map.getCell(x,y), items);
    }

    public Fighter createDefault(int x, int y){

        return new Fighter(50, 1, map.getCell(x, y));
    }
}
