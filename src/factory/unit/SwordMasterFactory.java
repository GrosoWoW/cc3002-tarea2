package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.items.attack.normal.Sword;
import model.map.Field;
import model.units.SwordMaster;

/**
 * Clase de fabrica que se encarga de crear SwordMasters
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */

public class SwordMasterFactory extends AbstractUnitFactory {

    Field map;

    public SwordMasterFactory(Field map) {
        super(map);
        this.map = map;
    }

    /**
     * Crea un SwordMaster con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a SwordMaster
     */

    @Override
    public SwordMaster create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        SwordMaster swordMaster = new SwordMaster(hitPoints, 1, map.getCell(x,y), items);
        map.getCell(x, y).setUnit(swordMaster);
        swordMaster.setOwner(player);
        return swordMaster;
    }

    /**
     * Crea un SwordMaster con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return a SwordMaster
     */

    @Override
    public SwordMaster createDefault(int x, int y, Tactician player){

        SwordMaster swordMaster = new SwordMaster(50, 1, map.getCell(x,y));
        map.getCell(x, y).setUnit(swordMaster);
        swordMaster.setOwner(player);
        return swordMaster;
    }
}
