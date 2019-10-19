package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.items.attack.normal.Sword;
import model.map.Field;
import model.units.SwordMaster;

public class SwordMasterFactory extends AbstractUnitFactory {

    Field map;

    public SwordMasterFactory(Field map) {
        super(map);
        this.map = map;
    }

    public SwordMaster createSwordMaster(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        SwordMaster swordMaster = new SwordMaster(hitPoints, 1, map.getCell(x,y), items);
        swordMaster.setOwner(player);
        return swordMaster;
    }

    public SwordMaster createDefault(int x, int y, Tactician player){

        SwordMaster swordMaster = new SwordMaster(50, 1, map.getCell(x,y));
        swordMaster.setOwner(player);
        return swordMaster;
    }
}
