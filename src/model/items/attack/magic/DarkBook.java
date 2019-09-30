package model.items.attack.magic;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 *  * This class represents a DarkBook of the magic type
 *
 *
 *
 */

public class DarkBook extends AbstractBook {

    /**
     * Creates a new DarkBook
     *
     * @param name
     *      the name that identifies the weapon
     * @param power
     *      the base damage pf the weapon
     * @param minRange
     *      the minimum range of the weapon
     * @param maxRange
     *       the maximum range of the weapon
     */

    public DarkBook(final String name, int power, int minRange, int maxRange){

        super(name, power, minRange, maxRange);
    }

    @Override
    public double attack(IEquipableItem item){

        return item.counterDark(this);
    }

    @Override
    public double counterAnima(IEquipableItem item){

        return Math.max(item.getPower() - 20, 0);
    }

    @Override
    public double counterLight(IEquipableItem item){

        return item.getPower()*1.5;
    }


    @Override
    public void equipItem(IUnit unit){

        unit.equipDark(this);

    }






}
