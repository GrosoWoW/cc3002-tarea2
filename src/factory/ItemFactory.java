package factory;

import model.items.heal.*;
import model.items.attack.magic.*;
import model.items.attack.normal.*;


public class ItemFactory {



    public Axe createAxe(int power, int minRange, int maxRange ){

        return new Axe("Axe", power, minRange, maxRange);
    }

    public Bow createBow(int power, int minRange, int maxRange){

        return new Bow("Bow", power, minRange, maxRange);
    }

    public Spear createSpear(int power, int minRange, int maxRange){

        return new Spear("Spear", power, minRange, maxRange);
    }

    public Sword createSword(int power, int minRange, int maxRange){

        return new Sword("Sword", power, minRange, maxRange);
    }

    public AnimaBook createAnima(int power, int minRange, int maxRange){

        return new AnimaBook("Anima", power, minRange, maxRange);
    }

    public DarkBook createDark(int power, int minRange, int maxRange){

        return new DarkBook("Dark", power, minRange, maxRange);
    }

    public LightBook createLight(int power, int minRange, int maxRange){

        return new LightBook("Light", power, minRange, maxRange);
    }

    public Staff createStaff(int power, int minRange, int maxRange){

        return new Staff("Staff", power, minRange, maxRange);
    }
}
