package model.items;

import model.units.IUnit;

/**
 * Clase hand, representa un item que viene por defecto para las IUnit
 * @author Cristobal Jaramillo
 * @since 2.0
 */

public class Hand implements IEquipableItem {

    private String name;
    private double power;
    private int minRange;
    private int maxRange;
    private IUnit owner;


    public Hand(IUnit unit) {

        this.name = "Hand";
        this.power = 0;
        this.minRange = 1;
        this.maxRange = 1;
        this.owner = unit;
        unit.setEquippedItem(this);
    }


    @Override
    public double attack(IEquipableItem item){

        return item.counterBow(this);

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

    @Override
    public double counterAnima(IEquipableItem item){

        return item.getPower();
    }

    @Override
    public double counterDark(IEquipableItem item){

        return item.getPower();
    }

    @Override
    public double counterLight(IEquipableItem item){

        return item.getPower();
    }

    public double counterStaff(IEquipableItem item){

        return item.getPower();
    }


    public void setOwner(IUnit unit){

        this.owner = unit;
    }

    @Override
    public void equipItem(IUnit unit){

    }

    @Override
    public boolean equalsTo(IEquipableItem item){

        if(item instanceof Hand){

            return (this.getName()==item.getName()) &&
                    (this.getPower()==item.getPower()) &&
                    (this.getMinRange()==item.getMinRange()) &&
                    (this.getMaxRange()==item.getMaxRange());
        }
        return false;
    }
}
