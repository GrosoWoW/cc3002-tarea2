package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  public void equipWeapon(IUnit unit){

    unit.addItem(getAxe());
    getAxe().equipItem(unit);
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().addItem(getAxe());
    getAxe().equipItem(getTestUnit());
    assertEquals(getAxe(), getTestUnit().getEquippedItem());


    getBow().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getBow());
    getSword().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getSword());
    getStaff().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getStaff());
    getAnima().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAnima());
    getDark().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getDark());
    getLight().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getLight());
  }

  @Test
  @Override
  public void testCombat(){

    IUnit unidad = getTestUnit();
    equipWeapon(unidad);
    assertEquals(getAxe().getPower()*1.5, unidad.getEquippedItem().attack(getSpear()));
    assertEquals(Math.max(getAxe().getPower() - 20, 0), unidad.getEquippedItem().attack(getSword()));
    assertEquals(getAxe().getPower(), unidad.getEquippedItem().attack(getStaff()));

  }

  @Test
  @Override
  public void testEquippedAndTrade(){

    IUnit unidad = getTestUnit();
    IUnit alpaca = getTargetAlpaca();
    equipWeapon(unidad);
    assertEquals(unidad.getEquippedItem(), getAxe());
    unidad.giveAway(alpaca, getAxe());
    assertNotEquals(unidad.getEquippedItem(), getAxe());
  }

  @Test
  @Override
  public void testEquip(){

    IUnit unit = getTestUnit();
    getAxe().equipItem(unit);
    assertFalse(unit.getItems().contains(getAxe()));
    assertNotEquals(unit.getEquippedItem(), getAxe());
    unit.addItem(getAxe());
    getAxe().equipItem(unit);
    assertTrue(unit.getItems().contains(getAxe()));
    assertEquals(unit.getEquippedItem(), getAxe());

  }
}