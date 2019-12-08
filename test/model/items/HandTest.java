package model.items;

import model.items.attack.AbstractTestItem;
import model.map.Location;
import model.units.Hero;
import model.units.IUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test para verificar el funcionamiento de la clase Hand
 */

public class HandTest extends AbstractTestItem {

    private Hand hand;
    private Hero hero;

    @BeforeEach
    @Override
    public void setUp(){

        this.setTestUnit();
        this.setTestItem();

    }

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {

        expectedName = "Hand";
        expectedPower = 0;
        expectedMinRange = 1;
        expectedMaxRange = 1;
        hand = new Hand(hero);

    }

    /**
     * Sets up an item with wrong ranges setted.
     */


    @Override
    public void setWrongRangeItem() {
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

        return null;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return hand;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return hero;
    }

    @Test
    public void incorrectRangeTest() {
        assertTrue(this.hand.getMinRange() == 1);
        assertTrue(this.hand.getMaxRange() == 1);
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



        assertEquals(StrongDamage, 0);
        assertEquals(WeakDamage, 0);
        assertEquals(AgainstLight, 0);
        assertEquals(AgainstSpear, 0);
        assertEquals(AgainstAnima, 0);
        assertEquals(AgainstDark, 0);
        assertEquals(AgainstBow, 0);
        assertEquals(AgainstStaff, 0);

    }

    @Override
    @Test
    public void equippedToTest() {
        assertEquals(this.hand.getOwner(), this.hero);
    }
}





