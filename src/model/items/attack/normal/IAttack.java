package model.items.attack.normal;

import model.items.IEquipableItem;

/**
 * This interface represents the <i>AttackWeapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Cristobal Jaramillo Andrade
 */

interface IAttack extends IEquipableItem {


    /**
     *
     * @param item
     *        to attack
     * @return the damage that the unit will receive
     */
    double attack(IEquipableItem item);

}
