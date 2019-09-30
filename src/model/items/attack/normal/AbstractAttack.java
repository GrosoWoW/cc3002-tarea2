package model.items.attack.normal;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractAttack implements IAttack {

    private String name;
    private double power;
    protected int maxRange;
    protected int minRange;
    private IUnit owner;
    private boolean magic;
    private boolean attack;


    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name
     *     the name of the item
     * @param power
     *     the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange
     *     the minimum range of the item
     * @param maxRange
     *     the maximum range of the item
     */
    public AbstractAttack(final String name, int power, int minRange, int maxRange) {
        this.name = name;
        this.power = power;
        this.minRange = Math.max(minRange, 1);
        this.maxRange = Math.max(maxRange, this.minRange);
    }


    public IUnit getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public double counterSword(IEquipableItem item){

        return item.getPower();
    }

    public double counterAxe(IEquipableItem item){

        return item.getPower();
    }

    public double counterSpear(IEquipableItem item){

        return item.getPower();
    }

    public double counterBow(IEquipableItem item){

        return item.getPower();
    }

    public double counterAnima(IEquipableItem item){

        return item.getPower()*1.5;
    }

    public double counterDark(IEquipableItem item){

        return item.getPower()*1.5;
    }

    public double counterLight(IEquipableItem item){

        return item.getPower()*1.5;
    }

    public double counterStaff(IEquipableItem item){

        return item.getPower();
    }


    public void setOwner(IUnit unit){

        this.owner = unit;
    }





}
