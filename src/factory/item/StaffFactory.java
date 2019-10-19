package factory.item;

import model.items.IEquipableItem;
import model.items.heal.Staff;
import model.units.IUnit;

public class StaffFactory implements ItemFactory{

    public Staff create(int power, int minRange, int maxRange){

        return new Staff("Staff", power, minRange, maxRange);
    }

    public Staff createDefault(){

        return new Staff("Staff", 40, 0, 2);
    }
}
