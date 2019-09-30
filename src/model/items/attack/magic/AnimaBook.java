package model.items.attack.magic;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 *
 * This class represents a AnimaBook of the magic type
 *
 *
 *
 */

public class AnimaBook extends AbstractBook {

    /**
     * Creates a new AnimaBook
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

    public AnimaBook(final String name, int power, int minRange, int maxRange){

        super(name, power, minRange, maxRange);
    }

    @Override
    public double attack(IEquipableItem item){

        return item.counterAnima(this);

    }

    @Override
    public double counterLight(IEquipableItem item){

        return Math.max(item.getPower() - 20, 0);
    }

    @Override
    public double counterDark(IEquipableItem item){

        return item.getPower()*1.5;
    }


    @Override
    public void equipItem(IUnit unit){

        unit.equipAnima(this);


    }





}