package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Alpaca;
import model.units.IUnit;

/**
 * Clase de fabrica que se encarga de crear Alpacas
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */
public class AlpacaFactory extends AbstractUnitFactory {

    private Field map;

    public AlpacaFactory(Field map) {

        super(map);
        this.map = map;
    }

    /**
     * Crea una alpaca con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Alpaca
     */

    @Override
    public Alpaca create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Alpaca alpaca = new Alpaca(hitPoints, 1, map.getCell(x,y), items);
        alpaca.setOwner(player);
        return alpaca;
    }

    /**
     * Crea una alpaca con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return a Alpaca
     */

    @Override
    public Alpaca createDefault(int x, int y, Tactician player){

        Alpaca alpaca =new Alpaca(50, 1, map.getCell(x, y));
        alpaca.setOwner(player);
        return alpaca;
    }
}
