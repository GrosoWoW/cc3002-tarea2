package factory;

import controller.Tactician;
import factory.unit.*;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class unitFactoryTest {

    private Field field;
    private ArrayList<IEquipableItem> items = new ArrayList<IEquipableItem>();
    private Archer archer;
    private Alpaca alpaca;
    private Cleric cleric;
    private Fighter fighter;
    private Hero hero;
    private Sorcerer sorcerer;
    private SwordMaster swordMaster;
    private ArcherFactory archerFactory;
    private AlpacaFactory alpacaFactory;
    private ClericFactory clericFactory;
    private FighterFactory fighterFactory;
    private HeroFactory heroFactory;
    private SorcererFactory sorcererFactory;
    private SwordMasterFactory swordMasterFactory;
    private Tactician tactician;


    @BeforeEach
    public void setUp(){

        this.field = new Field();
        this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
                new Location(2, 1), new Location(2, 2));
        this.alpaca = new Alpaca(50,1, field.getCell(2,0));
        this.archer = new Archer(20, 1, field.getCell(0,0));
        this.fighter = new Fighter(30, 1, field.getCell(0,1));
        this.hero = new Hero(40, 1, field.getCell(0,2));
        this.sorcerer = new Sorcerer(30, 1, field.getCell(1,0));
        this.swordMaster = new SwordMaster(30, 1 , field.getCell(1,1));
        this.cleric = new Cleric(70, 1, field.getCell(2,2));
        this.alpacaFactory = new AlpacaFactory(field);
        this.archerFactory = new ArcherFactory(field);
        this.fighterFactory = new FighterFactory(field);
        this.heroFactory = new HeroFactory(field);
        this.sorcererFactory = new SorcererFactory(field);
        this.swordMasterFactory = new SwordMasterFactory(field);
        this.clericFactory = new ClericFactory(field);
        this.tactician = new Tactician("Player 0");

    }

    @Test
    public void testCreateUnit() {

        IUnit unidad = archerFactory.create(20, 0,0, tactician);
        assertTrue(unidad.equalsTo(archer));
        assertEquals(unidad.getMaxHitPoints(), 20);
        assertEquals(unidad.getLocation().getRow(), 0);
        assertEquals(unidad.getLocation().getColumn(), 0);

        IUnit unidad2 = fighterFactory.create(30,0,1, tactician);
        assertTrue(unidad2.equalsTo(fighter));
        assertEquals(unidad2.getMaxHitPoints(), 30);
        assertEquals(unidad2.getLocation().getRow(), 0);
        assertEquals(unidad2.getLocation().getColumn(), 1);

        IUnit unidad3 = heroFactory.create(40,0,2, tactician);
        assertTrue(unidad3.equalsTo(hero));
        assertEquals(unidad3.getMaxHitPoints(), 40);
        assertEquals(unidad3.getLocation().getRow(), 0);
        assertEquals(unidad3.getLocation().getColumn(), 2);

        IUnit unidad4 = sorcererFactory.create(30,1,0, tactician);
        assertTrue(unidad4.equalsTo(sorcerer));
        assertEquals(unidad4.getMaxHitPoints(), 30);
        assertEquals(unidad4.getLocation().getRow(), 1);
        assertEquals(unidad4.getLocation().getColumn(), 0);

        IUnit unidad5 = alpacaFactory.create(50,2,0, tactician);
        assertTrue(unidad5.equalsTo(alpaca));
        assertEquals(unidad5.getMaxHitPoints(), 50);
        assertEquals(unidad5.getLocation().getRow(), 2);
        assertEquals(unidad5.getLocation().getColumn(), 0);

        IUnit unidad6 = swordMasterFactory.createSwordMaster(30,1,1, tactician);
        assertTrue(unidad6.equalsTo(swordMaster));
        assertEquals(unidad6.getMaxHitPoints(), 30);
        assertEquals(unidad6.getLocation().getRow(), 1);
        assertEquals(unidad6.getLocation().getColumn(), 1);

        IUnit unidad7 = clericFactory.create(70,2,2, tactician);
        assertTrue(unidad7.equalsTo(cleric));
        assertEquals(unidad7.getMaxHitPoints(), 70);
        assertEquals(unidad7.getLocation().getRow(), 2);
        assertEquals(unidad7.getLocation().getColumn(), 2);

    }




}
