package factory.item;

import model.items.attack.magic.AnimaBook;

public class AnimaFactory implements ItemFactory {

    public AnimaBook create(int power, int minRange, int maxRange){

        return new AnimaBook("Anima", power, minRange, maxRange);
    }

    public AnimaBook createDefault(){

        return new AnimaBook("Anima", 40, 1, 3);
    }
}
