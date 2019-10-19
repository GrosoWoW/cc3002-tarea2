package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Cleric;

public class ClericFactory extends AbstractUnitFactory {

    private Field map;

    public ClericFactory(Field map) {
        super(map);
        this.map = map;
    }


    public Cleric create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Cleric cleric = new Cleric(hitPoints, 1, map.getCell(x,y));
        cleric.setOwner(player);
        return cleric;
    }

    public Cleric createDefault(int x, int y, Tactician player){

        Cleric cleric = new Cleric(50, 1, map.getCell(x, y));
        cleric.setOwner(player);
        return cleric;
    }
}
