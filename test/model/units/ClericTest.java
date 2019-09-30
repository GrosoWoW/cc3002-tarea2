package model.units;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  public void equipWeapon(IUnit unit) {

    unit.addItem(getStaff());
    getStaff().equipItem(unit);
  }

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().addItem(getStaff());
    getStaff().equipItem(getTestUnit());
    assertEquals(getStaff(), getTestUnit().getEquippedItem());

    getBow().equipItem(getTestUnit());
    assertNotEquals(getBow(), getTestUnit().getEquippedItem());
    getAxe().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
    getSword().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getSword());
    getSpear().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getSpear());
    getAnima().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAnima());
    getDark().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getDark());
    getLight().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getLight());
  }

  @Test
  @Override
  public void testCombat() {

    IUnit primero = getTestUnit();
    IUnit segundo = new Cleric(1, 2, field.getCell(0, 0));
    primero.attackEnemy(segundo);
    assertTrue(segundo.getLive());
  }

  @Test
  @Override
  public void testEquippedAndTrade(){

    IUnit unidad = getTestUnit();
    IUnit alpaca = getTargetAlpaca();
    equipWeapon(unidad);
    assertEquals(unidad.getEquippedItem(), getStaff());
    unidad.giveAway(alpaca, getStaff());
    assertNotEquals(unidad.getEquippedItem(), getStaff());
  }

  @Test
  @Override
  public void testEquip(){

    IUnit unit = getTestUnit();
    getStaff().equipItem(unit);
    assertFalse(unit.getItems().contains(getStaff()));
    assertNotEquals(unit.getEquippedItem(), getStaff());
    unit.addItem(getStaff());
    getStaff().equipItem(unit);
    assertTrue(unit.getItems().contains(getStaff()));
    assertEquals(unit.getEquippedItem(), getStaff());

  }
}
