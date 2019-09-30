package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer archer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  @Override
  public void equipWeapon(IUnit unit){

    unit.addItem(getBow());
    getBow().equipItem(unit);
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().addItem(getBow());
    getBow().equipItem(getTestUnit());

    assertEquals(getBow(), getTestUnit().getEquippedItem());


    getAxe().equipItem(getTestUnit());
    assertNotEquals(getTestUnit().getEquippedItem(), getAxe());
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
    assertEquals(getAxe().getPower(), unidad.getEquippedItem().attack(getSpear()));
    assertEquals(getAxe().getPower(), unidad.getEquippedItem().attack(getSword()));
    assertEquals(getAxe().getPower(), unidad.getEquippedItem().attack(getStaff()));
  }

  @Test
  @Override
  public void testEquippedAndTrade(){

    IUnit unidad = getTestUnit();
    IUnit alpaca = getTargetAlpaca();
    equipWeapon(unidad);
    assertEquals(unidad.getEquippedItem(), getBow());
    unidad.giveAway(alpaca, getBow());
    assertNotEquals(unidad.getEquippedItem(), getBow());
  }

  @Test
  @Override
  public void testEquip(){

    IUnit unit = getTestUnit();
    getBow().equipItem(unit);
    assertFalse(unit.getItems().contains(getBow()));
    assertNotEquals(unit.getEquippedItem(), getBow());
    unit.addItem(getBow());
    getBow().equipItem(unit);
    assertTrue(unit.getItems().contains(getBow()));
    assertEquals(unit.getEquippedItem(), getBow());

  }
}