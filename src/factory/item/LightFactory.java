package factory.item;

import model.items.attack.magic.LightBook;

/**
 * Esta clase se encarga de fabricar LightBooks
 * @author Cristóbal Jaramillo Andrade
 * @Since 2.0
 */


public class LightFactory implements ItemFactory {

    /**
     * Crea una LightBook con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return LightBook
     */

    @Override
    public LightBook create(int power, int minRange, int maxRange){

        return new LightBook("Light", power, minRange, maxRange);
    }

    /**
     * Crea una LightBook con parametros por defecto
     * @return a LightBook
     */

    @Override
    public LightBook createDefault(){

        return new LightBook("Light", 50, 1, 3);
    }
}
