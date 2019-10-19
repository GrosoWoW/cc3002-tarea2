package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Sorcerer;

public class SorcererFactory extends AbstractUnitFactory {

     private Field map;

    public SorcererFactory(Field map) {
        super(map);
        this.map = map;
    }

    public Sorcerer create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Sorcerer sorcerer = new Sorcerer(hitPoints, 1, map.getCell(x,y), items);
        sorcerer.setOwner(player);
        return sorcerer;
    }

    public Sorcerer createDefault(int x, int y, Tactician player){

        Sorcerer sorcerer = new Sorcerer(50, 1, map.getCell(x, y));
        sorcerer.setOwner(player);
        return sorcerer;
    }
}
