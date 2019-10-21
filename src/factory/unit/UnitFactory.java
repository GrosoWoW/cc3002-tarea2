package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * Esta interfaz representa a las fabricas que generan IUnit
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 */

public interface UnitFactory {

    /**
     * Crea una unidad con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Unit
     */

    IUnit create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items);

    /**
     *
     * Crea una unidad con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return a Unit
     */

    IUnit createDefault(int x, int y, Tactician player);
}
