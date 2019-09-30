package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {


  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  double getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  /**
   * @param item
   *       equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterAnima(IEquipableItem item);

  /**
   * @param item
   *       equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterDark(IEquipableItem item);

  /**
   * @param item
   *       equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterLight(IEquipableItem item);

  /**
   * @param item
   *      equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterAxe(IEquipableItem item);

  /**
   * @param item
   *      equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterSpear(IEquipableItem item);

  /**
   * @param item
   *      equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterSword(IEquipableItem item);

  /**
   * @param item
   *      equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterBow(IEquipableItem item);

  /**
   * @param item
   *      equipped by the attacker
   * @return how much damage it should generate depending on its strengths and weaknesses of the item
   */
  double counterStaff(IEquipableItem item);

  /**
   * @param equippedItem
   *      equipped by the enemy
   * @return damage depending on the weapon equipped by the enemy
   */
  double attack(IEquipableItem equippedItem);

  /**
   * @param unit
   *      to which the item is equated
   */
  void equipItem(IUnit unit);

  /**
   * @param unit
   *      to be assigned as the owner of the weapon
   */
  void setOwner(IUnit unit);

}
