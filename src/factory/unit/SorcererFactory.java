package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Sorcerer;

/**
 * Clase de fabrica que se encarga de crear Sorcerers
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */

public class SorcererFactory extends AbstractUnitFactory {

     private Field map;

    public SorcererFactory(Field map) {
        super(map);
        this.map = map;
    }

    /**
     * Crea un sorcerer con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Sorcerer
     */

    @Override
    public Sorcerer create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Sorcerer sorcerer = new Sorcerer(hitPoints, 1, map.getCell(x,y), items);
        map.getCell(x, y).setUnit(sorcerer);
        sorcerer.setOwner(player);
        return sorcerer;
    }

    /**
     * Crea un sorcerer con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return a Sorcerer
     */

    @Override
    public Sorcerer createDefault(int x, int y, Tactician player){

        Sorcerer sorcerer = new Sorcerer(50, 1, map.getCell(x, y));
        map.getCell(x, y).setUnit(sorcerer);
        sorcerer.setOwner(player);
        return sorcerer;
    }
}
