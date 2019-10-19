package factory.unit;

import model.map.Field;

public abstract class AbstractUnitFactory {

    private Field map;

    public AbstractUnitFactory(Field map){

        this.map = map;
    }


}
