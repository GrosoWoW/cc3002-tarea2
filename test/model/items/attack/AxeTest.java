package model.items.attack;

import model.items.IEquipableItem;

import model.map.Location;
import model.units.Fighter;
import model.units.IUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.items.attack.normal.*;


/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class AxeTest extends AbstractTestItem {

  private Axe axe;
  private Axe wrongAxe;
  private Fighter fighter;

  @Override
  public void setTestItem() {
    expectedName = "Common axe";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    axe = new Axe(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongAxe = new Axe("Wrong axe", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongAxe;
  }

  @Override
  public IEquipableItem getTestItem() {
    return axe;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  @Override
  @Test
  public void damageTest(){

    double StrongDamage = getTestItem().attack(getSpear());
    double WeakDamage = getTestItem().attack(getSword());
    double AgainstLight = getTestItem().attack(getLight());
    double AgainstDark = getTestItem().attack(getDark());
    double AgainstAnima = getTestItem().attack(getAnima());
    double AgainstAxe = getTestItem().attack(getAxe());
    double AgainstBow = getTestItem().attack(getBow());
    double AgainstStaff = getTestItem().attack(getStaff());



    assertEquals(StrongDamage, getTestItem().getPower()*1.5);
    assertEquals(WeakDamage, Math.max(getTestItem().getPower() - 20, 0));
    assertEquals(AgainstLight, getTestItem().getPower()*1.5);
    assertEquals(AgainstAxe, getTestItem().getPower());
    assertEquals(AgainstAnima, getTestItem().getPower()*1.5);
    assertEquals(AgainstDark, getTestItem().getPower()*1.5);
    assertEquals(AgainstBow, getTestItem().getPower());
    assertEquals(AgainstStaff, getTestItem().getPower());


  }
}