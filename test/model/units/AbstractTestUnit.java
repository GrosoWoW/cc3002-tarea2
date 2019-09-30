package model.units;

import model.items.*;
import model.items.attack.heal.IHeal;
import model.items.attack.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.Axe;
import model.items.attack.normal.Bow;
import model.items.attack.normal.Spear;
import model.items.attack.normal.Sword;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected AnimaBook anima;
  protected DarkBook dark;
  protected LightBook light;
  protected IEquipableItem equippedItem;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }


  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }


  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 0, 3);
    this.sword = new Sword("Sword", 10, 0, 3);
    this.spear = new Spear("Spear", 10, 0, 3);
    this.staff = new Staff("Staff", 10, 0, 3);
    this.bow = new Bow("Bow", 10, 2, 4);
    this.anima = new AnimaBook("Anima", 10,0,3);
    this.dark = new DarkBook("Dark", 10, 0, 3);
    this.light = new LightBook("Light", 10, 0 ,3);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    item.equipItem(getTestUnit());
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  @Override
  public AnimaBook getAnima() {
    return anima;
  }

  @Override
  public DarkBook getDark() {return dark;}

  @Override
  public LightBook getLight(){ return light;}

  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Override
  public void equipWeapon(IUnit unit){

  }

  @Override
  @Test
  public void testTrade(){

    IUnit unit1 = getTestUnit();
    IUnit unit2 = getTargetAlpaca();
    unit1.addItem(getAxe());
    unit2.addItem(getSpear());
    unit1.trade(unit2,getSpear(),getAxe());
    assertTrue(unit1.getItems().contains(getSpear()));
    assertTrue(unit2.getItems().contains(getAxe()));
    assertFalse(unit1.getItems().contains(getAxe()));
    assertEquals(getSpear().getOwner(), unit1);
    assertEquals(getAxe().getOwner(), unit2);



  }

  @Override
  @Test
  public void testFailTrade(){

    IUnit unit1 = getTestUnit();
    IUnit unit2 = getTargetAlpaca();
    unit1.addItem(getAxe());
    unit2.addItem(getSword());
    unit1.trade(unit2, getAxe(), getSword());
    assertFalse(unit1.getItems().contains(getSword()));

  }

  @Override
  @Test
  public void testGift(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    IEquipableItem item = getAxe();
    assertFalse(segundo.getItems().contains(item));
    primero.addItem(item);
    assertTrue(primero.getItems().contains(item));
    primero.giveAway(segundo, item);
    assertNotEquals(primero.getItems(), segundo.getItems());
    assertTrue(segundo.getItems().contains(item));
    assertFalse(primero.getItems().contains(item));
    assertEquals(item.getOwner(), segundo);


    }


  @Override
  @Test
  public void testReceived(){

    IUnit primero= getTestUnit();
    IUnit segundo = getTargetAlpaca();
    IEquipableItem item = getAxe();
    primero.addItem(item);
    segundo.receive(primero, item);
    assertTrue(segundo.getItems().contains(item));
    assertFalse(primero.getItems().contains(item));
    assertEquals(item.getOwner(), segundo);
    assertNotEquals(item.getPower(), primero);
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
    assertTrue(segundo.getItems().contains(getStaff()));
    assertFalse(primero.getItems().contains(getStaff()));

  }

  @Override
  @Test
  public void testCombat(){

    IUnit primero = getTestUnit();
    IUnit segundo = new Fighter(1, 2, field.getCell(1, 1));
    equipWeapon(primero);
    segundo.addItem(getAxe());
    getAxe().equipItem(segundo);
    primero.attackEnemy(segundo);
    assertNotEquals(segundo.getLive(), primero.getLive());
    assertTrue(primero.getLive());
    assertTrue(primero.canAttack(segundo));


    IUnit tercero = new SwordMaster(50, 2, field.getCell(0, 0));
    IUnit cuarto = new Hero(50, 2, field.getCell(1, 0));
    tercero.addItem(getSword());
    getSword().equipItem(tercero);
    assertEquals(tercero.getEquippedItem(), getSword());
    cuarto.addItem(getSpear());
    getSpear().equipItem(cuarto);
    assertEquals(cuarto.getEquippedItem(), getSpear());
    cuarto.attackEnemy(tercero);
    assertTrue(cuarto.getLive());
    assertTrue(tercero.getLive());

  }

  @Override
  @Test
  public void testHeal() {

    IUnit primero = getTestUnit();
    IUnit curita = new Cleric(50, 2, field.getCell(1, 1));
    equipWeapon(primero);
    IHeal item = new Staff("staff", 20, 0, 10);
    curita.addItem(item);
    item.equipItem(curita);
    assertEquals(item.getHeal(), 20);
    assertEquals(curita.getCurrentHitPoints(), curita.getMaxHitPoints());
    primero.takeDamage(30);
    curita.attackEnemy(primero);
    assertEquals(curita.getCurrentHitPoints(), curita.getMaxHitPoints());
    assertEquals(primero.getMaxHitPoints()-10, primero.getCurrentHitPoints());
    IEquipableItem item1 = new Staff("staff", 200000,0,10);
    curita.addItem(item1);
    item1.equipItem(curita);
    curita.attackEnemy(primero);
    assertEquals(primero.getMaxHitPoints(), primero.getCurrentHitPoints());
    curita.unEquipItem();
    IEquipableItem item2 = new Sword("staff", 10,0,10);
    curita.addItem(item2);
    item2.equipItem(curita);
    primero.takeDamage(60);
    curita.attackEnemy(primero);
    assertEquals(primero.getMaxHitPoints()-60, primero.getCurrentHitPoints());

  }

  @Test
  @Override
  public void testInventory(){


    IUnit unidad = getTestUnit();
    unidad.addItem(getSword());
    unidad.addItem(getAxe());
    unidad.addItem(getSpear());
    unidad.addItem(getAnima());
    assertTrue(unidad.getItems().contains(getSword()));
    assertTrue(unidad.getItems().contains(getAxe()));
    assertTrue(unidad.getItems().contains(getSpear()));
    assertFalse(unidad.getItems().contains(getAnima()));

  }

  @Test
  @Override
  public void testEquippedAndTrade(){


  }

  }



