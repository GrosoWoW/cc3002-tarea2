package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Hero;

public class HeroFactory extends AbstractUnitFactory {

    private Field map;

    public HeroFactory(Field map) {
        super(map);
        this.map = map;
    }

    public Hero create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Hero hero = new Hero(hitPoints, 1, map.getCell(x,y), items);
        hero.setOwner(player);
        return hero;
    }

    public Hero createDefault(int x, int y, Tactician player){

        Hero hero = new Hero(50, 1, map.getCell(x, y));
        hero.setOwner(player);
        return hero;

    }
}
