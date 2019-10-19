package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.Cleric;

public class ClericFactory extends AbstractUnitFactory {

    private Field map;

    public ClericFactory(Field map) {
        super(map);
        this.map = map;
    }


    public Cleric create(int hitPoints, int x, int y, IEquipableItem... items){

        return new Cleric(hitPoints, 1, map.getCell(x,y));
    }

    public Cleric createDefault(int x, int y){

        return new Cleric(50, 1, map.getCell(x, y));
    }
}
