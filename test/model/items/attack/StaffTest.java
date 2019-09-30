package model.items.attack;

import model.items.IEquipableItem;
import model.items.attack.heal.Staff;
import model.map.Location;
import model.units.Cleric;
import model.units.IUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test set for staffs
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class StaffTest extends AbstractTestItem {

  private Staff staff;
  private Staff wrongStaff;
  private Cleric cleric;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common staff";
    expectedPower = 5;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    staff = new Staff(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongStaff = new Staff("Wrong staff", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongStaff;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return staff;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  @Test
  @Override
  public void constructorTest() {
    assertEquals(getExpectedName(), getTestItem().getName());
    assertEquals(getExpectedBasePower(), -getTestItem().getPower());
    assertEquals(getExpectedMinRange(), getTestItem().getMinRange());
    assertEquals(getExpectedMaxRange(), getTestItem().getMaxRange());
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



    assertEquals(AgainstSword,getTestItem().getPower());
    assertEquals(AgainstSpear, getTestItem().getPower());
    assertEquals(AgainstLight, getTestItem().getPower());
    assertEquals(AgainstAxe, getTestItem().getPower());
    assertEquals(AgainstAnima, getTestItem().getPower());
    assertEquals(AgainstDark, getTestItem().getPower());
    assertEquals(AgainstBow, getTestItem().getPower());
    assertEquals(AgainstStaff, getTestItem().getPower());


  }

}
