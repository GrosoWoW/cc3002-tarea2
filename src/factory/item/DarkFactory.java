package factory.item;

import model.items.attack.magic.DarkBook;

/**
 * Esta clase se encarga de fabricar DarkBooks
 * @author Cristóbal Jaramillo Andrade
 * @Since 2.0
 */


public class DarkFactory implements ItemFactory{

    /**
     * Crea una DarkBook con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return a DarkBook
     */

    @Override
    public DarkBook create(int power, int minRange, int maxRange){

        return new DarkBook("Dark", power, minRange, maxRange);
    }

    /**
     * Crea una DarkBook con parametros por defecto
     * @return a DarkBook
     */

    @Override
    public DarkBook createDefault(){

        return new DarkBook("Dark", 50, 1, 3);
    }
}
