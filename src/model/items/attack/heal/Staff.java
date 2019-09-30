package model.items.attack.heal;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractHeal {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(final String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange);

  }

  public double attack(IEquipableItem item){

    return item.counterStaff(this);

  }


  @Override
  public void equipItem(IUnit unit){

    unit.equipStaff(this);

  }

}
