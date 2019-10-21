package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Fighter;

/**
 * Clase de fabrica que se encarga de crear Fighters
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */

public class FighterFactory extends AbstractUnitFactory {

    private Field map;

    public FighterFactory(Field map) {
        super(map);
        this.map = map;
    }

    /**
     * Crea un fighter con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Fighter
     */

    @Override
    public Fighter create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Fighter fighter = new Fighter(hitPoints, 1, map.getCell(x,y), items);
        fighter.setOwner(player);
        return fighter;
    }

    /**
     * Crea un fighter con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return a Fighter
     */

    @Override
    public Fighter createDefault(int x, int y, Tactician player){

        Fighter fighter = new Fighter(50, 1, map.getCell(x, y));
        fighter.setOwner(player);
        return fighter;
    }
}
