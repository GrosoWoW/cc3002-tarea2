package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Fighter;

public class FighterFactory extends AbstractUnitFactory {

    private Field map;

    public FighterFactory(Field map) {
        super(map);
        this.map = map;
    }


    public Fighter create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Fighter fighter = new Fighter(hitPoints, 1, map.getCell(x,y), items);
        fighter.setOwner(player);
        return fighter;
    }

    public Fighter createDefault(int x, int y, Tactician player){

        Fighter fighter = new Fighter(50, 1, map.getCell(x, y));
        fighter.setOwner(player);
        return fighter;
    }
}
