package model.items.attack.heal;

import model.items.IEquipableItem;

/**
 * This interface represents the <i>healWeapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the healWeapons are defined here. Every healWeapon have a
 * base damage (heal) and is strong or weak against other type of weapons.
 *
 * @author Cristobal Jaramillo Andrade
 */

public interface IHeal extends IEquipableItem {

    /**
     *
     * @param item
     *        to attack
     * @return the damage that the unit will receive
     */

    double attack(IEquipableItem item);


    /**
     *
     * @return the amount of healing the unit will receive
     */
    double getHeal();


}
