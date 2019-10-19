package factory.unit;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.Alpaca;

public class AlpacaFactory extends AbstractUnitFactory {

    private Field map;

    public AlpacaFactory(Field map) {

        super(map);
        this.map = map;
    }

    public Alpaca create(int hitPoints, int x, int y, IEquipableItem... items){

        return new Alpaca(hitPoints, 1, map.getCell(x,y), items);


    }

    public Alpaca createDefault(int x, int y){

        return new Alpaca(50, 1, map.getCell(x, y));
    }
}
