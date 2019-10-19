package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.Sorcerer;

public class SorcererFactory extends AbstractUnitFactory {

     private Field map;

    public SorcererFactory(Field map) {
        super(map);
        this.map = map;
    }

    public Sorcerer create(int hitPoints, int x, int y, IEquipableItem... items){

        return new Sorcerer(hitPoints, 1, map.getCell(x,y), items);
    }

    public Sorcerer createDefault(int x, int y){

        return new Sorcerer(50, 1, map.getCell(x, y));
    }
}
