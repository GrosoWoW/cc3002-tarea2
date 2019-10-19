package factory.item;

import model.items.attack.normal.Bow;

public class BowFactory implements ItemFactory {


    public Bow create(int power, int minRange, int maxRange){

        return new Bow("Bow", power, minRange, maxRange);
    }

    public Bow createDefault(){

        return new Bow("Bow",25, 1,3);
    }
}
