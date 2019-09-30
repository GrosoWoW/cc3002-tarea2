package model.items.attack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.IEquipableItem;
import model.items.ITestEquipableItem;
import model.items.attack.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.Axe;
import model.items.attack.normal.Bow;
import model.items.attack.normal.Spear;
import model.items.attack.normal.Sword;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Defines some common methods for all the items tests
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestItem implements ITestEquipableItem {

  protected String expectedName;
  protected int expectedPower;
  protected short expectedMinRange;
  protected short expectedMaxRange;

  /**
   * Sets up the items to be tested
   */
  @BeforeEach
  public void setUp() {
    setTestItem();
    setWrongRangeItem();
    setTestUnit();
  }

  /**
   * Sets up a correctly implemented item that's going to be tested
   */
  public abstract void setTestItem();

  /**
   * Sets up an item with wrong ranges setted.
   */
  public abstract void setWrongRangeItem();

  /**
   * Sets the unit that will be equipped with the test item
   */
  public abstract void setTestUnit();

  /**
   * Checks that the tested item cannot have ranges outside of certain bounds.
   */
  @Test
  public void incorrectRangeTest() {
    assertTrue(getWrongTestItem().getMinRange() >= 0);
    assertTrue(getWrongTestItem().getMaxRange() >= getWrongTestItem().getMinRange());
  }

  public abstract IEquipableItem getWrongTestItem();

  /**
   * Tests that the constructor for the tested item works properly
   */
  @Test
  public void constructorTest() {
    assertEquals(getExpectedName(), getTestItem().getName());
    assertEquals(getExpectedBasePower(), getTestItem().getPower());
    assertEquals(getExpectedMinRange(), getTestItem().getMinRange());
    assertEquals(getExpectedMaxRange(), getTestItem().getMaxRange());
  }

  /**
   * @return the expected name of the item
   */
  public String getExpectedName() {
    return expectedName;
  }

  /**
   * @return the item being tested
   */
  public abstract IEquipableItem getTestItem();

  /**
   * @return the expected power of the Item
   */
  public int getExpectedBasePower() {
    return expectedPower;
  }

  /**
   * @return the expected minimum range of the item
   */
  public int getExpectedMinRange() {
    return expectedMinRange;
  }

  /**
   * @return the expected maximum range of the item
   */
  public int getExpectedMaxRange() {
    return expectedMaxRange;
  }

  public Axe getAxe(){

    return new Axe("axe", 10,0,10);
  }
  public Bow getBow(){

    return new Bow("bow", 10,0,10);
  }
  public Spear getSpear(){

    return new Spear("spear", 10,0,10);

  }
  public Staff getStaff(){

    return new Staff("staff", 10,0,10);
  }
  public Sword getSword(){

    return new Sword("sword", 10,0,10);

  }
  public AnimaBook getAnima(){

    return new AnimaBook("Anima", 10, 0, 10);

  }
  public LightBook getLight(){

    return new LightBook("light", 10, 0, 10);

  }
  public DarkBook getDark(){
    return new DarkBook("Dark", 10, 0, 10);

  }

  /**
   * Checks that the Item can be correctly equipped to a unit
   */
  @Test
  public void equippedToTest() {
    assertNull(getTestItem().getOwner());
    IUnit unit = getTestUnit();
    unit.addItem(getTestItem());
    getTestItem().equipItem(unit);
    assertEquals(unit, getTestItem().getOwner());
  }

  /**
   * @return a unit that can equip the item being tested
   */
  public abstract IUnit getTestUnit();

  public void damageTest(){


  }
}
