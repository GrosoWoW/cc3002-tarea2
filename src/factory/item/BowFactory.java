package factory.item;

import model.items.attack.normal.Bow;

/**
 * Esta clase se encarga de fabricar Bow
 * @author Cristóbal Jaramillo Andrade
 * @since  2.0
 */


public class BowFactory implements ItemFactory {

    /**
     * Crea una Bow con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return a bow
     */

    @Override
    public Bow create(int power, int minRange, int maxRange){

        return new Bow("Bow", power, minRange, maxRange);
    }

    /**
     * Crea una Bow con parametros por defecto
     * @return a Bow
     */

    @Override
    public Bow createDefault(){

        return new Bow("Bow",25, 2,3);
    }
}
