package factory.item;

import javafx.scene.effect.Light;
import model.items.attack.magic.LightBook;

public class LightFactory implements ItemFactory {

    public LightBook create(int power, int minRange, int maxRange){

        return new LightBook("Light", power, minRange, maxRange);
    }

    public LightBook createDefault(){

        return new LightBook("Light", 50, 1, 3);
    }
}
