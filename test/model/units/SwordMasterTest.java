package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  public void equipWeapon(IUnit unit){

    unit.addItem(getSword());
    getSword().equipItem(unit);
  }

  @Override
  public void equipSwordTest() {
    assertNull(getTestUnit().getEquippedItem());
    getSword().equipItem(getTestUnit());
    assertEquals(getSword(), getTestUnit().getEquippedItem());


    getBow().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getBow());
    getAxe().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
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
    assertEquals(getSword().getPower()*1.5, unidad.getEquippedItem().attack(getAxe()));
    assertEquals(Math.max(getSword().getPower() - 20, 0), unidad.getEquippedItem().attack(getSpear()));
    assertEquals(getSword().getPower(), unidad.getEquippedItem().attack(getStaff()));
  }

  @Test
  @Override
  public void testEquippedAndTrade(){

    IUnit unidad = getTestUnit();
    IUnit alpaca = getTargetAlpaca();
    equipWeapon(unidad);
    assertEquals(unidad.getEquippedItem(), getSword());
    unidad.giveAway(alpaca, getSword());
    assertNotEquals(unidad.getEquippedItem(), getSword());
  }

  @Test
  @Override
  public void testEquip(){

    IUnit unit = getTestUnit();
    getSword().equipItem(unit);
    assertFalse(unit.getItems().contains(getSword()));
    assertNotEquals(unit.getEquippedItem(), getSword());
    unit.addItem(getSword());
    getSword().equipItem(unit);
    assertTrue(unit.getItems().contains(getSword()));
    assertEquals(unit.getEquippedItem(), getSword());

  }
}