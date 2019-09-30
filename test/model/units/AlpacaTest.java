package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;

  @Override
  public void setTestUnit() {
    alpaca = new Alpaca(50, 2, field.getCell(0, 0));
  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }

  public void equipWeapon(IUnit unit){


  }

  @Override
  @Test
  public void testFailReceived(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    primero.addItem(getSword());
    primero.addItem(getSpear());
    primero.addItem(getAxe());
    segundo.addItem(getStaff());
    primero.receive(segundo, getStaff());
    assertFalse(segundo.getItems().contains(getStaff()));
    assertTrue(primero.getItems().contains(getStaff()));


  }

  @Override
  @Test
  public void testCombat(){

    IUnit primero = getTargetAlpaca();
    primero.addItem(getAxe());
    getAxe().equipItem(primero);
    IUnit segundo = new Alpaca(1, 2, field.getCell(0, 0));
    primero.attackEnemy(segundo);
    assertTrue(segundo.getLive());

  }
  @Override
  @Test
  public void testInventory() {

    IUnit alpaca1 = getTargetAlpaca();
    alpaca1.addItem(getAxe());
    alpaca1.addItem(getSpear());
    alpaca1.addItem(getSword());
    alpaca1.addItem(getAnima());
    alpaca1.addItem(getStaff());
    assertTrue(alpaca1.getItems().contains(getAxe()));
    assertTrue(alpaca1.getItems().contains(getSpear()));
    assertTrue(alpaca1.getItems().contains(getSword()));
    assertTrue(alpaca1.getItems().contains(getAnima()));
    assertTrue(alpaca1.getItems().contains(getStaff()));
  }

  @Test
  @Override
  public void testEquip(){

    IUnit unit = getTestUnit();
    unit.addItem(getAxe());
    unit.addItem(getStaff());
    unit.addItem(getAnima());
    unit.addItem(getSword());
    unit.addItem(getBow());
    unit.addItem(getDark());
    unit.addItem(getLight());
    unit.addItem(getSpear());
    getAxe().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getAxe());
    getStaff().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getStaff());
    getAnima().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getAnima());
    getSword().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getSword());
    getBow().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getBow());
    getLight().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getLight());
    getDark().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getDark());
    getSpear().equipItem(unit);
    assertNotEquals(unit.getEquippedItem(), getSpear());






  }

}