package model.units;


import model.items.*;
import model.items.attack.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.Axe;
import model.items.attack.normal.Bow;
import model.items.attack.normal.Spear;
import model.items.attack.normal.Sword;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface ITestUnit {

  /**
   * Set up the game field
   */
  void setField();

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  void setTestUnit();

  void setTargetAlpaca();

  /**
   * Creates a set of testing weapons
   */
  void setWeapons();

  /**
   * Checks that the constructor works properly.
   */
  @Test
  void constructorTest();

  /**
   * @return the current unit being tested
   */
  IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  void equipAxeTest();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  void checkEquippedItem(IEquipableItem item);

  /**
   * @return the test axe
   */
  Axe getAxe();

  @Test
  void equipSwordTest();

  /**
   * @return the test sword
   */
  Sword getSword();

  @Test
  void equipSpearTest();

  /**
   * @return the test spear
   */
  Spear getSpear();

  @Test
  void equipStaffTest();

  /**
   * @return the test staff
   */
  Staff getStaff();

  @Test
  void equipBowTest();

  /**
   * @return the test bow
   */
  Bow getBow();

  AnimaBook getAnima();

  DarkBook getDark();

  LightBook getLight();

  /**
   * Checks if the unit moves correctly
   */
  @Test
  void testMovement();

  /**
   * @return the test field
   */
  Field getField();

  /**
   * @return the target Alpaca
   */
  Alpaca getTargetAlpaca();

  /**
   * Verify that the exchange is correct
   */

  @Test
  void testTrade();

  /**
   * verify that bugs are not produced
   */

  @Test
  void testFailTrade();

  /**
   * verify that the gift is well produced
   */

  @Test
  void testGift();

  /**
   * verify that the item is received correctly
   */

  @Test
  void testReceived();

  /**
   * verify that there are no errors in receiving an object
   */

  @Test
  void testFailReceived();

  /**
   * check that the combat occurs correctly
   */

  @Test
  void testCombat();

  /**
   * verify that the healing is correct
   */

  @Test
  void testHeal();

  /**
   *
   * @param unit
   *      to which the weapon is equated
   */

  void equipWeapon(IUnit unit);

  /**
   * verify that the inventory works correctly
   */

  @Test
  void testInventory();

  /**
   * verify that traded items are no longer equipped
   */

  @Test
  void testEquippedAndTrade();

  /**
   * verify that the equipped items are in the inventory and have no errors
   */

  @Test
  void testEquip();

}
