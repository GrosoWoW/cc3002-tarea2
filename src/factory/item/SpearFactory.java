package factory.item;

import model.items.attack.normal.Spear;

public class SpearFactory implements ItemFactory {

    public Spear create(int power, int minRange, int maxRange){

        return new Spear("Spear", power, minRange, maxRange);
    }

    public Spear createDefault(){

        return new Spear("Spear", 30, 0, 1);
    }
}
