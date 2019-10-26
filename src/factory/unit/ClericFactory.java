package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Cleric;

/**
 * Clase de fabrica que se encarga de crear Clerics
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */

public class ClericFactory extends AbstractUnitFactory {

    private Field map;

    public ClericFactory(Field map) {
        super(map);
        this.map = map;
    }

    /**
     * Crea un cleric con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return
     */

    @Override
    public Cleric create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Cleric cleric = new Cleric(hitPoints, 1, map.getCell(x,y));
        map.getCell(x, y).setUnit(cleric);

        cleric.setOwner(player);
        return cleric;
    }

    /**
     * Crea un cleric con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return
     */

    @Override
    public Cleric createDefault(int x, int y, Tactician player){

        Cleric cleric = new Cleric(50, 1, map.getCell(x, y));
        map.getCell(x, y).setUnit(cleric);

        cleric.setOwner(player);
        return cleric;
    }
}
