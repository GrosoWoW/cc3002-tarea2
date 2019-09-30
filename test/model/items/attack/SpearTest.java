package model.items.attack;

import model.items.IEquipableItem;
import model.items.attack.normal.Spear;
import model.map.Location;
import model.units.Hero;
import model.units.IUnit;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for spears
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SpearTest extends AbstractTestItem {

  private Spear javelin;
  private Spear wrongSpear;
  private Hero hero;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Javelin";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 30;
    javelin = new Spear(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSpear = new Spear("Wrong spear", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSpear;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return javelin;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }


  @Override
  @Test
  public void damageTest(){

    double StrongDamage = getTestItem().attack(getSword());
    double WeakDamage = getTestItem().attack(getAxe());
    double AgainstLight = getTestItem().attack(getLight());
    double AgainstDark = getTestItem().attack(getDark());
    double AgainstAnima = getTestItem().attack(getAnima());
    double AgainstSpear = getTestItem().attack(getSpear());
    double AgainstBow = getTestItem().attack(getBow());
    double AgainstStaff = getTestItem().attack(getStaff());



    assertEquals(StrongDamage, getTestItem().getPower()*1.5);
    assertEquals(WeakDamage, Math.max(getTestItem().getPower() - 20, 0));
    assertEquals(AgainstLight, getTestItem().getPower()*1.5);
    assertEquals(AgainstSpear, getTestItem().getPower());
    assertEquals(AgainstAnima, getTestItem().getPower()*1.5);
    assertEquals(AgainstDark, getTestItem().getPower()*1.5);
    assertEquals(AgainstBow, getTestItem().getPower());
    assertEquals(AgainstStaff, getTestItem().getPower());

  }
}
