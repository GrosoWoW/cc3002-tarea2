package factory;

import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class unitFactoryTest {

    private UnitFactory factory;
    private Field field;
    private Archer archer;
    private ArrayList<IEquipableItem> items = new ArrayList<IEquipableItem>();


    @BeforeEach
    public void setUp(){

        this.field = new Field();
        this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
                new Location(2, 1), new Location(2, 2));
        this.factory = new UnitFactory(field);

    }

    @Test
    public void testCreateUnit() {

        IUnit unidad = factory.createArcher(20, 0,0);
        assertTrue(unidad.getClass().getName().contains("Archer"));
        assertEquals(unidad.getMaxHitPoints(), 20);
        assertEquals(unidad.getLocation().getRow(), 0);
        assertEquals(unidad.getLocation().getColumn(), 0);

        IUnit unidad2 = factory.createFighter(30,0,1);
        assertTrue(unidad2.getClass().getName().contains("Fighter"));
        assertEquals(unidad2.getMaxHitPoints(), 30);
        assertEquals(unidad2.getLocation().getRow(), 0);
        assertEquals(unidad2.getLocation().getColumn(), 1);

        IUnit unidad3 = factory.createHero(40,0,2);
        assertTrue(unidad3.getClass().getName().contains("Hero"));
        assertEquals(unidad3.getMaxHitPoints(), 40);
        assertEquals(unidad3.getLocation().getRow(), 0);
        assertEquals(unidad3.getLocation().getColumn(), 2);

        IUnit unidad4 = factory.createSorcerer(30,1,0);
        assertTrue(unidad4.getClass().getName().contains("Sorcerer"));
        assertEquals(unidad4.getMaxHitPoints(), 30);
        assertEquals(unidad4.getLocation().getRow(), 1);
        assertEquals(unidad4.getLocation().getColumn(), 0);

        IUnit unidad5 = factory.createAlpaca(50,2,0);
        assertTrue(unidad5.getClass().getName().contains("Alpaca"));
        assertEquals(unidad5.getMaxHitPoints(), 50);
        assertEquals(unidad5.getLocation().getRow(), 2);
        assertEquals(unidad5.getLocation().getColumn(), 0);

        IUnit unidad6 = factory.createSwordMaster(30,1,1);
        assertTrue(unidad6.getClass().getName().contains("SwordMaster"));
        assertEquals(unidad6.getMaxHitPoints(), 30);
        assertEquals(unidad6.getLocation().getRow(), 1);
        assertEquals(unidad6.getLocation().getColumn(), 1);

        IUnit unidad7 = factory.createCleric(70,2,2);
        assertTrue(unidad7.getClass().getName().contains("Cleric"));
        assertEquals(unidad7.getMaxHitPoints(), 70);
        assertEquals(unidad7.getLocation().getRow(), 2);
        assertEquals(unidad7.getLocation().getColumn(), 2);

    }




}
