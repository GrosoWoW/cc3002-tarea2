package factory.item;

import model.items.IEquipableItem;
import model.items.heal.Staff;
import model.units.IUnit;

/**
 * Esta clase se encarga de fabricar Staffs
 * @author Cristóbal Jaramillo Andrade
 * @since  2.0
 */


public class StaffFactory implements ItemFactory{

    /**
     * Crea una Staff con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return a Staff
     */

    @Override
    public Staff create(int power, int minRange, int maxRange){

        return new Staff("Staff", power, minRange, maxRange);
    }

    /**
     * Crea una Staff con parametros por defecto
     * @return a Staff
     */

    @Override
    public Staff createDefault(){

        return new Staff("Staff", 40, 1, 3);
    }
}
