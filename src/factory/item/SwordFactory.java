package factory.item;

import model.items.attack.normal.Sword;

public class SwordFactory implements ItemFactory {

    public Sword create(int power, int minRange, int maxRange){

        return new Sword("Sword", power, minRange, maxRange);
    }

    public Sword createDefault(){

        return new Sword("Sword", 50, 0, 1);
    }
}
