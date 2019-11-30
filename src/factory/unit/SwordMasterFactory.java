package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.SwordMaster;

/**
 * Clase de fabrica que se encarga de crear SwordMasters
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */

public class SwordMasterFactory extends AbstractUnitFactory {

    private InvalidLocation invalidLocation;

    public SwordMasterFactory() {

        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea un SwordMaster con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a SwordMaster
     */

    @Override
    public SwordMaster create(int hitPoints, Tactician player, IEquipableItem... items){

        SwordMaster swordMaster = new SwordMaster(hitPoints, 1, invalidLocation, items);
        swordMaster.setOwner(player);
        player.addUnit(swordMaster);
        return swordMaster;
    }

    /**
     * Crea un SwordMaster con parametros por default
     * @param player jugador dueño de la unidad
     * @return a SwordMaster
     */

    @Override
    public SwordMaster createDefault(Tactician player){

        SwordMaster swordMaster = new SwordMaster(50, 1, invalidLocation);
        swordMaster.setOwner(player);
        player.addUnit(swordMaster);
        return swordMaster;
    }
}
