package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.Archer;

/**
 * Clase de fabrica que se encarga de crear Archers
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */


public class ArcherFactory extends AbstractUnitFactory {

    private InvalidLocation invalidLocation;


    /**
     * Constructor de la fabrica
     */
    public ArcherFactory(){

        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea un Archer con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Archer
     */


    @Override
    public Archer create(int hitPoints, Tactician player, IEquipableItem... items){

        Archer archer = new Archer(hitPoints, 1, invalidLocation, items);
        archer.setOwner(player);
        player.addUnit(archer);
        return archer;
    }

    /**
     * Crea un Archer con parametros por default
     * @param player jugador dueño de la unidad
     * @return
     */


    @Override
    public Archer createDefault(Tactician player){

        Archer archer = new Archer(50, 1, invalidLocation);
        archer.setOwner(player);
        player.addUnit(archer);
        return archer;
    }
}
