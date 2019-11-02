package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.Fighter;

/**
 * Clase de fabrica que se encarga de crear Fighters
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */

public class FighterFactory extends AbstractUnitFactory {

    private InvalidLocation invalidLocation;

    public FighterFactory(Field map) {

        super(map);
        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea un fighter con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Fighter
     */

    @Override
    public Fighter create(int hitPoints, Tactician player, IEquipableItem... items){

        Fighter fighter = new Fighter(hitPoints, 1, invalidLocation, items);
        fighter.setOwner(player);
        player.addUnit(fighter);
        return fighter;
    }

    /**
     * Crea un fighter con parametros por default
     * @param player jugador dueño de la unidad
     * @return a Fighter
     */

    @Override
    public Fighter createDefault(Tactician player){

        Fighter fighter = new Fighter(50, 1, invalidLocation);
        fighter.setOwner(player);
        player.addUnit(fighter);
        return fighter;
    }
}
