package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.Alpaca;
import model.units.IUnit;

/**
 * Clase de fabrica que se encarga de crear Alpacas
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */
public class AlpacaFactory extends AbstractUnitFactory {

    private InvalidLocation invalidLocation;

    public AlpacaFactory(Field map) {

        super(map);
        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea una alpaca con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Alpaca
     */

    @Override
    public Alpaca create(int hitPoints, Tactician player, IEquipableItem... items){

        Alpaca alpaca = new Alpaca(hitPoints, 1, invalidLocation, items);
        alpaca.setOwner(player);
        player.addUnit(alpaca);
        return alpaca;
    }

    /**
     * Crea una alpaca con parametros por default
     * @param player jugador dueño de la unidad
     * @return a Alpaca
     */

    @Override
    public Alpaca createDefault(Tactician player){

        Alpaca alpaca =new Alpaca(50, 1, invalidLocation);
        alpaca.setOwner(player);
        player.addUnit(alpaca);
        return alpaca;
    }
}
