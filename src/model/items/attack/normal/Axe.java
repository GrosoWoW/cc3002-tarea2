package model.items.attack.normal;

import model.items.IEquipableItem;
import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractAttack {


  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, int power, int minRange, int maxRange) {
    super(name, power, minRange, maxRange); }

  @Override
  public double attack(IEquipableItem item){

    return item.counterAxe(this);

  }

  @Override
  public double counterSword(IEquipableItem item){

    return item.getPower()*1.5;
  }

  @Override
  public double counterSpear(IEquipableItem item){

    return Math.max(item.getPower() - 20, 0);
  }


  @Override
  public double counterLight(IEquipableItem item){

    return item.getPower()*1.5;
  }
  @Override
  public void equipItem(IUnit unit){

    unit.equipAxe(this);


  }


}
