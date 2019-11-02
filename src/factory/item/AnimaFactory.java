package factory.item;

import model.items.attack.magic.AnimaBook;

/**
 * Esta clase se encarga de fabricar AnimaBooks
 * @author Cristóbal Jaramillo Andrade
 * @since  2.0
 */

public class AnimaFactory implements ItemFactory {

    /**
     * Crea una AnimaBook con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return a AnimaBook
     */

    @Override
    public AnimaBook create(int power, int minRange, int maxRange){

        return new AnimaBook("Anima", power, minRange, maxRange);
    }

    /**
     * Crea una AnimaBook con parametros por defecto
     * @return a AnimaBook
     */
    @Override
    public AnimaBook createDefault(){

        return new AnimaBook("Anima", 40, 1, 3);
    }
}
