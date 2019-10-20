package model.items.attack;

import model.items.IEquipableItem;

public interface IAttack {


    /**
     *
     * @param item
     *        to attack
     * @return the damage that the unit will receive
     */
    double attack(IEquipableItem item);
}
