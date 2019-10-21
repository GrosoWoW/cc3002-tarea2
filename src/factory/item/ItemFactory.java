package factory.item;

import model.items.IEquipableItem;

/**
 * Esta interfaz representa a las fabricas que generan <IEquipableItem>
 * @Author Cristóbal Jaramillo Andrade
 * @Since 2.0
 */

public interface ItemFactory {

    /**
     * Crea un item con parametro predefinidos
     * @param power poder que tendra el arma
     * @param min alcance minimo del arma
     * @param max alcance maximo del arma
     * @return IEquipableItem
     */

    IEquipableItem create(int power, int min, int max);

    /**
     * Crea un item con parametros por defecto
     * @return IEquipableItem
     */

    IEquipableItem createDefault();
}
