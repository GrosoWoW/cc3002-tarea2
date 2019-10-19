package factory.item;

import model.items.attack.magic.DarkBook;

public class DarkFactory implements ItemFactory{

    public DarkBook create(int power, int minRange, int maxRange){

        return new DarkBook("Dark", power, minRange, maxRange);
    }

    public DarkBook createDefault(){

        return new DarkBook("Dark", 50, 1, 3);
    }
}
