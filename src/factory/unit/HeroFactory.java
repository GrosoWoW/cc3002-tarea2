package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Hero;

/**
 * Clase de fabrica que se encarga de crear Heros
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */

public class HeroFactory extends AbstractUnitFactory {

    private Field map;

    public HeroFactory(Field map) {
        super(map);
        this.map = map;
    }

    /**
     * Crea un hero con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return
     */

    @Override
    public Hero create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Hero hero = new Hero(hitPoints, 1, map.getCell(x,y), items);
        hero.setOwner(player);
        return hero;
    }

    /**
     * Crea un hero con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return a Hero
     */

    @Override
    public Hero createDefault(int x, int y, Tactician player){

        Hero hero = new Hero(50, 1, map.getCell(x, y));
        hero.setOwner(player);
        return hero;

    }
}
