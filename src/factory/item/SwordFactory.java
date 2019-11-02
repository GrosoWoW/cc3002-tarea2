package factory.item;

import model.items.attack.normal.Sword;

/**
 * Esta clase se encarga de fabricar Swords
 * @author Cristóbal Jaramillo Andrade
 * @since  2.0
 */


public class SwordFactory implements ItemFactory {

    /**
     * Crea una Sword con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return Sword
     */

    @Override
    public Sword create(int power, int minRange, int maxRange){

        return new Sword("Sword", power, minRange, maxRange);
    }

    /**
     * Crea una Sword con parametros por defecto
     * @return a Sword
     */

    @Override
    public Sword createDefault(){

        return new Sword("Sword", 50, 1, 2);
    }
}
