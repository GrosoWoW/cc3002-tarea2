package factory.item;

import model.items.attack.normal.Axe;

/**
 * Esta clase se encarga de fabricar Axe
 * @author Cristóbal Jaramillo Andrade
 * @Since 2.0
 */


public class AxeFactory implements ItemFactory {

    /**
     * Crea una Axe con parametros dados por el usuario
     * @param power daño del arma
     * @param minRange minimo rango del arma
     * @param maxRange maximo rango del arma
     * @return a Axe
     */

    @Override
    public Axe create(int power, int minRange, int maxRange ){

        return new Axe("Axe", power, minRange, maxRange);
    }

    /**
     * Crea una Axe con parametros por defecto
     * @return a Axe
     */

    @Override
    public Axe createDefault(){

        return new Axe("Axe", 40, 1, 2);
    }
}
