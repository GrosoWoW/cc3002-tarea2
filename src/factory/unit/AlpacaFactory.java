package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Alpaca;
import model.units.IUnit;

public class AlpacaFactory extends AbstractUnitFactory {

    private Field map;

    public AlpacaFactory(Field map) {

        super(map);
        this.map = map;
    }

    public Alpaca create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Alpaca alpaca = new Alpaca(hitPoints, 1, map.getCell(x,y), items);
        alpaca.setOwner(player);
        return alpaca;


    }

    public Alpaca createDefault(int x, int y, Tactician player){

        Alpaca alpaca =new Alpaca(50, 1, map.getCell(x, y));
        alpaca.setOwner(player);
        return alpaca;
    }
}
