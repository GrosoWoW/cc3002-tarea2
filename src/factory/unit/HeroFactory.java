package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.Hero;

public class HeroFactory extends AbstractUnitFactory {

    private Field map;

    public HeroFactory(Field map) {
        super(map);
        this.map = map;
    }

    public Hero create(int hitPoints, int x, int y, IEquipableItem... items){

        return new Hero(hitPoints, 1, map.getCell(x,y), items);
    }

    public Hero createDefault(int x, int y){

        return new Hero(50, 1, map.getCell(x, y));
    }
}
