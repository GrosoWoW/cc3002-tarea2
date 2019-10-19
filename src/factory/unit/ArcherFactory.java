package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Archer;

public class ArcherFactory extends AbstractUnitFactory {

    Field map;

    public ArcherFactory(Field map){

        super(map);
        this.map = map;
    }

    public Archer create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Archer archer = new Archer(hitPoints, 1, map.getCell(x,y), items);
        archer.setOwner(player);
        return archer;
    }

    public Archer createDefault(int x, int y, Tactician player){

        Archer archer = new Archer(50, 1, map.getCell(x, y));
        archer.setOwner(player);
        return archer;
    }
}
