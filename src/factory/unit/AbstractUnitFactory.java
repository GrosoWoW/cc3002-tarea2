package factory.unit;

import model.map.Field;
import model.map.InvalidLocation;

/**
 * Clase abstracta que representa a una fabrica de unidades
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 */

public abstract class AbstractUnitFactory implements UnitFactory {

    private Field map;

    /**
     * Crea una fabrica de unidades
     * @param map mapa donde se crearan las unidades
     */

    public AbstractUnitFactory(Field map){

        this.map = map;
    }


}
