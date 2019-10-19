package controller;

import factory.item.BowFactory;
import factory.item.DarkFactory;
import factory.unit.*;
import model.items.IEquipableItem;
import model.items.attack.magic.AnimaBook;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TacticianTest {

    private Tactician tactician;
    private List unidades;
    private Field map;
    private IEquipableItem item;
    private IUnit unit;
    private HeroFactory heroFactory;
    private AlpacaFactory alpacaFactory;
    private DarkFactory darkFactory;
    private ClericFactory clericFactory;
    private BowFactory bowFactory;
    private ArcherFactory archerFactory;
    private FighterFactory fighterFactory;


    @BeforeEach
    void setUp(){
        Tactician tactician = new Tactician("Player");
        this.tactician = tactician;
        List<IUnit> unidades = new ArrayList<>();
        this.unidades = unidades;
        this.map = new Field();
        this.map.addCells(true, new Location(0,0));
        this.map.addCells(true, new Location(0,1));
        this.map.addCells(true, new Location(0,2));
        item = new AnimaBook("Anima", 10,0,3);
        unit = new Sorcerer(10, 1, map.getCell(0,2) );
        unidades.add(unit);
        this.tactician.setUnits(unidades);
        this.tactician.setActualUnit(unit);
        this.tactician.getActualUnit().addItem(item);
        this.tactician.getActualUnit().setEquippedItem(item);
        this.heroFactory = new HeroFactory(this.map);
        this.alpacaFactory = new AlpacaFactory(this.map);
        this.darkFactory = new DarkFactory();
        this.bowFactory = new BowFactory();
        this.archerFactory = new ArcherFactory(this.map);
        this.fighterFactory = new FighterFactory(this.map);
        this.clericFactory = new ClericFactory(this.map);
    }


    @Test
    void getNameTest(){
        assertEquals(this.tactician.getName(), "Player");
    }
    @Test
    void getPlayerUnitTest(){
        assertEquals(this.tactician.getActualUnit(), unidades.get(0));

    }

    @Test
    void getPlayerUnitsTest(){
        assertEquals(this.tactician.getPlayerUnits(), this.unidades);
    }

    @Test
    void getActualhitPointsUnitTest(){
        assertEquals(this.tactician.getActualHitPointsUnit(), 10);
        this.tactician.getActualUnit().takeDamage(5);
        assertEquals(this.tactician.getActualHitPointsUnit(), 5);

    }
    @Test
    void getMaxHitPOintsUnitTest(){

        assertEquals(this.tactician.getMaxHitPointsUnit(), 10);
        this.tactician.getActualUnit().takeDamage(5);
        assertEquals(this.tactician.getMaxHitPointsUnit(), 10);
    }

    @Test
    void getItemPowerUnitTest(){

        assertEquals(this.tactician.getItemPowerUnit(), 10);
    }

    @Test
    void getItemNameUnitTest(){

        assertEquals(this.tactician.getItemNameUnit(), "Anima");
    }

    @Test
     void getSelectUnitTest(){

        assertNull(this.tactician.getSelectIUnit());
        IUnit unidad = heroFactory.create(10, 0, 0);
        this.tactician.setSelectIUnit(unidad);
        assertEquals(unidad, this.tactician.getSelectIUnit());
    }

    @Test
    void attackUnitTest(){

        IUnit unidad = alpacaFactory.create(50,0,0);
        assertTrue(tactician.getActualUnit().canAttack(unidad));
        tactician.attackUnit(unidad);
        assertEquals(40, unidad.getCurrentHitPoints());
    }

    @Test
    void equipItemTest(){

        IEquipableItem item = darkFactory.create(20, 0, 1);
        tactician.getActualUnit().setEquippedItem(item);
        assertEquals(tactician.getActualUnit().getEquippedItem(), item );

    }

    @Test
    void tradeItemTest(){

        IUnit unidad = clericFactory.create(10,0 ,1);
        IEquipableItem item = bowFactory.create(10, 0, 1);
        unidad.addItem(item);
        assertTrue(unidad.getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item));
        tactician.tradeItem(unidad, item, this.item);
        assertTrue(unidad.getItems().contains(this.item));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        assertFalse(unidad.getItems().contains(item));
        assertFalse(tactician.getActualUnit().getItems().contains(this.item));

    }

    @Test
    void giftItemTest(){

        IUnit unidad = clericFactory.create(10,0 ,1);
        IEquipableItem item = bowFactory.create(10, 0, 1);
        unidad.addItem(item);
        assertTrue(unidad.getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item));
        tactician.giftItem(unidad, this.item);
        assertTrue(unidad.getItems().contains(this.item));
        assertTrue(unidad.getItems().contains(item));
        assertFalse(tactician.getActualUnit().getItems().contains(item));
        assertFalse(tactician.getActualUnit().getItems().contains(this.item));


    }

    @Test
    void receiveItemTest(){

        IUnit unidad = clericFactory.create(10,0 ,1);
        IEquipableItem item = bowFactory.create(10, 0, 1);
        unidad.addItem(item);
        assertTrue(unidad.getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item));
        tactician.receiveItem(unidad, item);
        assertFalse(unidad.getItems().contains(this.item));
        assertFalse(unidad.getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item));



    }

    @Test
    void setUnitsTest() {

        List<IUnit> list = new ArrayList();
        IUnit unit = archerFactory.create(10, 0,0);
        IUnit unit1 = fighterFactory.create(20,0,1);
        list.add(unit);
        list.add(unit1);
        assertNotNull(this.tactician.getPlayerUnits());
        this.tactician.setUnits(list);
        assertEquals(list, this.tactician.getPlayerUnits());
        this.tactician.setUnits(null);
        assertNull(this.tactician.getPlayerUnits());

    }

    @Test
    void setActualItemTest(){












    }







}
