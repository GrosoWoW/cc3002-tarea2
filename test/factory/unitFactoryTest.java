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

        IUnit unidad = factory.createArcher(20);
        assertEquals(unidad.getClass().getName(), "model.units.Archer");
        assertEquals(unidad.getMaxHitPoints(), 20);

        IUnit unidad2 = factory.createFighter(30);
        assertEquals(unidad2.getClass().getName(), "model.units.Fighter");
        assertEquals(unidad2.getMaxHitPoints(), 30);

    }




}
