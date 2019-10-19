package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.SwordMaster;

public class SwordMasterFactory extends AbstractUnitFactory {

    Field map;

    public SwordMasterFactory(Field map) {
        super(map);
        this.map = map;
    }

    public SwordMaster createSwordMaster(int hitPoints, int x, int y, IEquipableItem... items){

        return new SwordMaster(hitPoints, 1, map.getCell(x,y), items);
    }

    public SwordMaster createDefault(int x, int y){

        return new SwordMaster(50, 1, map.getCell(x,y));
    }
}
