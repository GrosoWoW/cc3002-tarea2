package factory.item;

import model.items.attack.normal.Spear;

/**
 * Esta clase se encarga de fabricar Spears
 * @author Cristóbal Jaramillo Andrade
 * @since  2.0
 */


public class SpearFactory implements ItemFactory {

    /**
     * Crea una Spear con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return Spear
     */

    @Override
    public Spear create(int power, int minRange, int maxRange){

        return new Spear("Spear", power, minRange, maxRange);
    }

    /**
     * Crea una Spear con parametros por defecto
     * @return a Spear
     */

    @Override
    public Spear createDefault(){

        return new Spear("Spear", 30, 1, 2);
    }
}
