package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * Esta interfaz representa a las fabricas que generan IUnit
 * @author Cristóbal Jaramillo Andrade
 * @since 2.0
 */

public interface UnitFactory {

    /**
     * Crea una unidad con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Unit
     */

    IUnit create(int hitPoints, Tactician player, IEquipableItem... items);

    /**
     *
     * Crea una unidad con parametros por default
     * @param player jugador dueño de la unidad
     * @return a Unit
     */

    IUnit createDefault(Tactician player);
}
