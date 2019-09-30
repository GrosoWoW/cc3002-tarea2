package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  private List<IEquipableItem> items = new ArrayList<>();
  private double currentHitPoints;
  private final int maxHitPoints;
  private final int movement;
  private IEquipableItem equippedItem;
  private Location location;
  int maxItems;
  boolean life;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = hitPoints;
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.maxItems = maxItems;
    this.life = true;
  }


  public double getCurrentHitPoints() {

    return currentHitPoints;
  }

  public int getMaxHitPoints(){

    return maxHitPoints;
  }

  public List<IEquipableItem> getItems() {

    return List.copyOf(items);
  }

  public IEquipableItem getEquippedItem() {

    return equippedItem;
  }

  public void setEquippedItem(final IEquipableItem item) {

    this.equippedItem = item;
  }

  public Location getLocation() {

    return location;
  }

  public void setLocation(final Location location) {

    this.location = location;
  }

  public int getMovement() {

    return movement;
  }

  public int getMaxItems(){

    return maxItems;
  }

  public void addItem(IEquipableItem item){

    if(this.getItems().size() < this.getMaxItems()) {

      items.add(item);
    }
  }

  public void removeItem(IEquipableItem item){


    this.items.remove(item);
  }

  public boolean getLive(){

    return life;
  }

  public void takeDamage(double damage){

    this.currentHitPoints -= damage;

  }
  
  public void equipAxe(IEquipableItem item){ }

  public void equipSpear(IEquipableItem item){}

  public void equipBow(IEquipableItem item){}

  public void equipSword(IEquipableItem item){}

  public void equipLight(IEquipableItem item){}

  public void equipDark(IEquipableItem item){}

  public void equipAnima(IEquipableItem item){}

  public void equipStaff(IEquipableItem item){}

  public void die(){

    this.life = false;
  }

  public void unEquipAItem(IEquipableItem item){

    if(this.getEquippedItem() == item) {

      this.equippedItem = null;
    }
  }

  public void unEquipItem(){

    this.equippedItem = null;
  }

  public double check(double num, double vidaMaxima, double vidaActual) {

    if (num <= 0) {
      if (vidaActual - num >= vidaMaxima) {
        return -(vidaMaxima - vidaActual);
      } else {
        return num;
      }
    }
    else{ return  num;}
  }

  public boolean canAttack(IUnit unit){

    return (this.getEquippedItem() != null) &&
            (this.getLocation().distanceTo(unit.getLocation()) <=this.getEquippedItem().getMaxRange()) &&
            (this.getLocation().distanceTo(unit.getLocation()) >= this.getEquippedItem().getMinRange());
  }


  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  public void trade(IUnit unit, IEquipableItem received, IEquipableItem delivered){


    if(this.getLocation().distanceTo(unit.getLocation()) <= 1){

      if(this.getItems().contains(delivered) && unit.getItems().contains(received)){

        this.unEquipAItem(delivered);
        unit.unEquipAItem(received);
        this.removeItem(delivered);
        unit.removeItem(received);
        this.addItem(received);
        unit.addItem(delivered);
        delivered.setOwner(unit);
        received.setOwner(this);
      }
    }
  }

  public void giveAway(IUnit unit, IEquipableItem gift) {

    if(this.getLocation().distanceTo(unit.getLocation()) <= 1){

      if(unit.getItems().size() < unit.getMaxItems()){

        this.unEquipAItem(gift);
        this.removeItem(gift);
        unit.addItem(gift);
        gift.setOwner(unit);
      }
    }
  }

  public void receive(IUnit unit, IEquipableItem received) {

    if(this.getLocation().distanceTo(unit.getLocation()) <= 1){

        if(this.getItems().size() < this.getMaxItems()){

          unit.unEquipAItem(received);
          this.addItem(received);
          unit.removeItem(received);
          received.setOwner(this);
        }
    }
  }

  public void attackEnemy(IUnit unit) {

    if (this.canAttack(unit)) {

      double damage = 0;
      if (unit.getEquippedItem() == null) {
        damage = this.getEquippedItem().getPower();

      }
      else {
        damage = this.getEquippedItem().attack(unit.getEquippedItem());

      }
      damage = check(damage, unit.getMaxHitPoints(), unit.getCurrentHitPoints());
      this.Damage(unit, damage);
    }
  }

  public void Damage(IUnit attacker, double damage){

    attacker.takeDamage(damage);
    if(attacker.getEquippedItem() == null) {}
    else{
      if (attacker.getCurrentHitPoints() <= 0) {
        attacker.die();
      } else if (attacker.canAttack(this) && damage > 0) {

        double dano = attacker.getEquippedItem().attack(this.getEquippedItem());
        dano = check(dano, this.getMaxHitPoints(), this.getCurrentHitPoints());
        this.takeDamage(dano);
        }
    }
  }

}
