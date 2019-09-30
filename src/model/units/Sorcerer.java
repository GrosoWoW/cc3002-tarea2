package model.units;

import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a sorcerer type unit.
 * A sorcerer is a unit that can only use books type weapons.
 *
 * @author Cristobal Jaramillo
 * @since 1.0
 */

public class Sorcerer extends AbstractUnit {

    /**
     * Creates a new Unit.
     *
     * @param hitPoints
     *     the maximum amount of damage a unit can sustain
     * @param movement
     *     the number of panels a unit can move
     */

    public Sorcerer(final int hitPoints, final int movement, final Location location,
                    IEquipableItem... items){
        super(hitPoints, movement, location,3, items);
    }


    @Override
    public void equipAnima(IEquipableItem item) {

        if (this.getItems().contains(item)) {

            this.setEquippedItem(item);
            item.setOwner(this);

        }
    }

    @Override
    public void equipDark(IEquipableItem item) {

        if (this.getItems().contains(item)) {

            this.setEquippedItem(item);
            item.setOwner(this);

        }
    }

    @Override
    public void equipLight(IEquipableItem item) {

        if (this.getItems().contains(item)) {

            this.setEquippedItem(item);
            item.setOwner(this);

        }
    }


}
