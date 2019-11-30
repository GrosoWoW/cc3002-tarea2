package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.Sorcerer;

/**
 * Clase de fabrica que se encarga de crear Sorcerers
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */

public class SorcererFactory extends AbstractUnitFactory {

     private InvalidLocation invalidLocation;

    public SorcererFactory() {

        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea un sorcerer con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Sorcerer
     */

    @Override
    public Sorcerer create(int hitPoints, Tactician player, IEquipableItem... items){

        Sorcerer sorcerer = new Sorcerer(hitPoints, 1, invalidLocation, items);
        sorcerer.setOwner(player);
        return sorcerer;
    }

    /**
     * Crea un sorcerer con parametros por default
     * @param player jugador dueño de la unidad
     * @return a Sorcerer
     */

    @Override
    public Sorcerer createDefault(Tactician player){

        Sorcerer sorcerer = new Sorcerer(50, 1, invalidLocation);
        sorcerer.setOwner(player);
        player.addUnit(sorcerer);
        return sorcerer;
    }
}
