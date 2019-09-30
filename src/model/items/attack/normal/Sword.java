package model.items.attack.normal;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractAttack {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public Sword(final String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange);
  }


  @Override
  public double attack(IEquipableItem item){

    return item.counterSword(this);
  }

  @Override
  public double counterSpear(IEquipableItem item){

    return item.getPower()*1.5;
  }

  @Override
  public double counterAxe(IEquipableItem item){

    return Math.max(item.getPower() - 20, 0);
  }

  @Override
  public void equipItem(IUnit unit){

    unit.equipSword(this);
  }


}
