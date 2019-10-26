package factory.unit;

import controller.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Archer;

/**
 * Clase de fabrica que se encarga de crear Archers
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 *
 */


public class ArcherFactory extends AbstractUnitFactory {

    Field map;

    /**
     * Constructor de la fabrica
     * @param map mapa donde se fabricaran las unidades
     */
    public ArcherFactory(Field map){

        super(map);
        this.map = map;
    }

    /**
     * Crea un Archer con parametros predefinidos
     * @param hitPoints cantidad de vida
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @param items objetos que tendra la unidad
     * @return a Archer
     */


    @Override
    public Archer create(int hitPoints, int x, int y, Tactician player, IEquipableItem... items){

        Archer archer = new Archer(hitPoints, 1, map.getCell(x,y), items);
        map.getCell(x, y).setUnit(archer);
        archer.setOwner(player);
        return archer;
    }

    /**
     * Crea un Archer con parametros por default
     * @param x posicion en x
     * @param y posicion en y
     * @param player jugador dueño de la unidad
     * @return
     */


    @Override
    public Archer createDefault(int x, int y, Tactician player){

        Archer archer = new Archer(50, 1, map.getCell(x, y));
        map.getCell(x, y).setUnit(archer);
        archer.setOwner(player);
        return archer;
    }
}
