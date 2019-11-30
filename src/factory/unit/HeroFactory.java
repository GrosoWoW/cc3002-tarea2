package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.units.Hero;

/**
 * Clase de fabrica que se encarga de crear Heros
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 *
 */

public class HeroFactory extends AbstractUnitFactory {

    private InvalidLocation invalidLocation;

    public HeroFactory() {

        this.invalidLocation = new InvalidLocation();
    }

    /**
     * Crea un hero con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Hero
     */

    @Override
    public Hero create(int hitPoints, Tactician player, IEquipableItem... items){

        Hero hero = new Hero(hitPoints, 1, invalidLocation, items);
        hero.setOwner(player);
        return hero;
    }

    /**
     * Crea un hero con parametros por default
     * @param player jugador dueño de la unidad
     * @return a Hero
     */

    @Override
    public Hero createDefault(Tactician player){

        Hero hero = new Hero(50, 1, invalidLocation);
        hero.setOwner(player);
        player.addUnit(hero);
        return hero;

    }
}
