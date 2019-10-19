package factory.item;

import model.items.attack.normal.Axe;

public class AxeFactory implements ItemFactory {

    public Axe create(int power, int minRange, int maxRange ){

        return new Axe("Axe", power, minRange, maxRange);
    }

    public Axe createDefault(){

        return new Axe("Axe", 40, 0, 1);
    }
}
