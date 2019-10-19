package controller;

import factory.ItemFactory;
import factory.UnitFactory;
import model.items.IEquipableItem;
import model.items.attack.magic.AnimaBook;
import model.items.attack.normal.Bow;
import model.items.attack.normal.Sword;
import model.map.Field;
import model.map.InvalidLocation;
import model.map.Location;
import model.units.Archer;
import model.units.IUnit;
import model.units.Sorcerer;
import model.units.SwordMaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TacticianTest {

    private Tactician tactician;
    private List unidades;
    private Field map;
    private UnitFactory unitFactory;
    private ItemFactory itemFactory;


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
        IEquipableItem item = new AnimaBook("Anima", 10,0,3);
        IUnit unit = new Sorcerer(10, 1, map.getCell(0,2), item );
        unidades.add(unit);
        this.tactician.setUnits(unidades);
        this.tactician.setActualUnit(unit);
        this.tactician.getActualUnit().addItem(item);
        this.tactician.getActualUnit().setEquippedItem(item);
        this.unitFactory = new UnitFactory(this.map);
        this.itemFactory = new ItemFactory();
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
        IUnit unidad = unitFactory.createHero(10, 0, 0);
        this.tactician.setSelectIUnit(unidad);
        assertEquals(unidad, this.tactician.getSelectIUnit());
    }

    @Test
    void attackUnitTest(){

        IUnit unidad = unitFactory.createAlpaca(50,0,0);
        assertTrue(tactician.getActualUnit().canAttack(unidad));
        tactician.attackUnit(unidad);
        assertEquals(40, unidad.getCurrentHitPoints());
    }

    @Test
    void equipItemTest(){

        IEquipableItem item = itemFactory.createDark(20, 0, 1);
        tactician.getActualUnit().setEquippedItem(item);
        assertEquals(tactician.getActualUnit().getEquippedItem(), item );

    }

    @Test
    void tradeItemTest(){




    }

    @Test
    void giftItemTest(){


    }

    @Test
    void receiveItemTest(){



    }

    @Test
    void setUnitsTest() {

        List<IUnit> list = new ArrayList();
        IUnit unit = unitFactory.createArcher(10, 0,0);
        IUnit unit1 = unitFactory.createFighter(20,0,1);
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
