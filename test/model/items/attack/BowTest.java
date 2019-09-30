package model.items.attack;

import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Archer;
import model.units.IUnit;
import org.junit.jupiter.api.Test;
import model.items.attack.normal.Bow;
import static org.junit.jupiter.api.Assertions.assertEquals;



/**
 * Test set for bows
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */

public class BowTest extends AbstractTestItem {

  private Bow bow;
  private Bow wrongBow;
  private Archer archer;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common bow";
    expectedPower = 8;
    expectedMinRange = 2;
    expectedMaxRange = 4;
    bow = new Bow(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongBow = new Bow("Wrong bow", 10, 1, 1);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(10, 5, new Location(0, 0));
  }

  /**
   * Checks that the minimum range for a bow is greater than 1
   */
  @Override
  @Test
  public void incorrectRangeTest() {
    assertTrue(getWrongTestItem().getMinRange() > 1);
    assertTrue(getWrongTestItem().getMaxRange() >= getWrongTestItem().getMinRange());
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongBow;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return bow;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  @Override
  @Test
  public void damageTest(){

    double AgainstSpear = getTestItem().attack(getSpear());
    double AgainstSword = getTestItem().attack(getSword());
    double AgainstLight = getTestItem().attack(getLight());
    double AgainstDark = getTestItem().attack(getDark());
    double AgainstAnima = getTestItem().attack(getAnima());
    double AgainstAxe = getTestItem().attack(getAxe());
    double AgainstBow = getTestItem().attack(getBow());
    double AgainstStaff = getTestItem().attack(getStaff());



    assertEquals(AgainstSword, getTestItem().getPower());
    assertEquals(AgainstSpear, getTestItem().getPower());
    assertEquals(AgainstLight, getTestItem().getPower()*1.5);
    assertEquals(AgainstAxe, getTestItem().getPower());
    assertEquals(AgainstAnima, getTestItem().getPower()*1.5);
    assertEquals(AgainstDark, getTestItem().getPower()*1.5);
    assertEquals(AgainstBow, getTestItem().getPower());
    assertEquals(AgainstStaff, getTestItem().getPower());


  }
}
