package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.Archer;

public class ArcherFactory extends AbstractUnitFactory {

    Field map;

    public ArcherFactory(Field map){

        super(map);
        this.map = map;
    }

    public Archer create(int hitPoints, int x, int y, IEquipableItem... items){

        return new Archer(hitPoints, 1, map.getCell(x,y), items);
    }

    public Archer createDefault(int x, int y){

        return new Archer(50, 1, map.getCell(x, y));
    }
}
