package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.Cleric;

/**
 * Clase de fabrica que se encarga de crear Clerics
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */

public class ClericFactory extends AbstractUnitFactory {

    private InvalidLocation invalidLocation;

    public ClericFactory(Field map) {

        super(map);
        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea un cleric con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a cleric
     */

    @Override
    public Cleric create(int hitPoints,  Tactician player, IEquipableItem... items){

        Cleric cleric = new Cleric(hitPoints, 1, invalidLocation, items);
        cleric.setOwner(player);
        player.addUnit(cleric);
        return cleric;
    }

    /**
     * Crea un cleric con parametros por default
     * @param player jugador dueño de la unidad
     * @return a cleric
     */

    @Override
    public Cleric createDefault(Tactician player){

        Cleric cleric = new Cleric(50, 1, invalidLocation);
        cleric.setOwner(player);
        player.addUnit(cleric);
        return cleric;
    }
}
