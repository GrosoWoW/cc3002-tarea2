package factory.item;

import model.items.IEquipableItem;

public interface ItemFactory {

    IEquipableItem create(int power, int min, int max);

    IEquipableItem createDefault();
}
