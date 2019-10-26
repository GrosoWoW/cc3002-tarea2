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
    private  Tactician jugador;
    private GameController controller;
    private List unidades;
    private Field map;
    private IEquipableItem item1;
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
        this.controller = new GameController(4, 7);
        this.map = new Field();
        this.map.addCells(true, new Location(0,0));
        this.map.addCells(true, new Location(0,1));
        this.map.addCells(true, new Location(0,2));
        controller.initGame(4);
        this.heroFactory = new HeroFactory(this.map);
        this.alpacaFactory = new AlpacaFactory(this.map);
        this.darkFactory = new DarkFactory();
        this.bowFactory = new BowFactory();
        this.archerFactory = new ArcherFactory(this.map);
        this.fighterFactory = new FighterFactory(this.map);
        this.clericFactory = new ClericFactory(this.map);
        this.controller.setActualPlayer(controller.getTacticians().get(0));
        this.controller.getActualPlayer().setActualUnit(controller.getActualPlayer().getPlayerUnits().get(0));
        this.tactician = controller.getActualPlayer();
        this.unidades = controller.getActualPlayer().getPlayerUnits();
        this.jugador = new Tactician("player", controller);
        this.unit = archerFactory.createDefault(0,0, jugador);
        this.item1 = bowFactory.create(20, 1,5);
        unit.addItem(item1);
        unit.setEquippedItem(item1);
        jugador.addUnit(unit);
        jugador.setActualUnit(unit);
    }


    @Test
    void getName(){
        assertEquals(this.tactician.getName(), controller.getActualPlayer().getName());
    }
    @Test
    void getPlayerUnit(){
        assertEquals(this.tactician.getActualUnit(), unidades.get(0));

    }

    @Test
    void getPlayerUnits(){
        assertEquals(this.tactician.getPlayerUnits(), this.unidades);
    }

    @Test
    void getActualhitPointsUnit(){
        assertEquals(this.tactician.getActualHitPointsUnit(), controller.getActualPlayer().getActualUnit().getCurrentHitPoints());
        this.tactician.getActualUnit().takeDamage(5);
        assertEquals(this.tactician.getActualHitPointsUnit(), controller.getActualPlayer().getActualUnit().getCurrentHitPoints());

    }
    @Test
    void getMaxHitPOintsUnit(){

        assertEquals(this.tactician.getMaxHitPointsUnit(), controller.getActualPlayer().getActualUnit().getMaxHitPoints());
        this.tactician.getActualUnit().takeDamage(5);
        assertEquals(this.tactician.getMaxHitPointsUnit(), controller.getActualPlayer().getActualUnit().getMaxHitPoints());
    }

    @Test
    void getItemPowerUnit(){

        IEquipableItem item = bowFactory.create(10 ,2 ,2);
        this.tactician.getActualUnit().addItem(item);
        this.tactician.getActualUnit().setEquippedItem(item);
        if(this.tactician.getActualUnit().getEquippedItem() != null){
            assertEquals(this.tactician.getItemPowerUnit(), 10 );
        }
        else{

            assertEquals(jugador.getItemPowerUnit(), 20);
        }
    }

    @Test
    void getItemNameUnit(){

        assertEquals(this.jugador.getItemNameUnit(), "Bow");
    }

    @Test
     void getSelectUnit(){

        assertNull(this.tactician.getSelectIUnit());
        IUnit unidad = heroFactory.create(10, 0, 0, tactician);
        this.tactician.setSelectIUnit(unidad);
        assertEquals(unidad, this.tactician.getSelectIUnit());
    }

    @Test
    void attackUnitTest(){

        IUnit unidad = alpacaFactory.create(50,0,2, tactician);
        assertTrue(jugador.getActualUnit().canAttack(unidad));
        jugador.attackUnit(unidad);
        assertEquals(30, unidad.getCurrentHitPoints());
    }

    @Test
    void equipItem(){

        IEquipableItem item = darkFactory.create(20, 0, 1);
        tactician.getActualUnit().setEquippedItem(item);
        assertEquals(tactician.getActualUnit().getEquippedItem(), item );

    }

    @Test
    void tradeItem(){

        IUnit unidad = clericFactory.create(10,0 ,1, tactician);
        IEquipableItem item = bowFactory.create(10, 0, 0);
        unidad.addItem(item);
        tactician.addUnit(unidad);
        tactician.setActualUnit(unidad);
        assertTrue(jugador.getActualUnit().getItems().contains(this.item1));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        tactician.tradeItem(jugador.getActualUnit(), this.item1, item);
        assertTrue(jugador.getActualUnit().getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item1));
        assertFalse(tactician.getActualUnit().getItems().contains(item));
        assertFalse(jugador.getActualUnit().getItems().contains(this.item1));

    }

    @Test
    void giftItem(){

        IUnit unidad = clericFactory.create(10,0 ,1, tactician);
        IEquipableItem item = bowFactory.create(10, 0, 0);
        unidad.addItem(item);
        tactician.addUnit(unidad);
        tactician.setActualUnit(unidad);
        assertTrue(jugador.getActualUnit().getItems().contains(this.item1));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        tactician.giftItem(jugador.getActualUnit(), item);
        assertTrue(jugador.getActualUnit().getItems().contains(item));
        assertFalse(tactician.getActualUnit().getItems().contains(item));


    }

    @Test
    void receiveItem(){

        IUnit unidad = clericFactory.create(10,0 ,1, tactician);
        IEquipableItem item = bowFactory.create(10, 0, 0);
        unidad.addItem(item);
        tactician.addUnit(unidad);
        tactician.setActualUnit(unidad);
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        assertFalse(jugador.getActualUnit().getItems().contains(item));
        tactician.receiveItem(jugador.getActualUnit(), this.item1);
        assertFalse(jugador.getActualUnit().getItems().contains(this.item1));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item1));



    }

    @Test
    void setUnits() {

        List<IUnit> list = new ArrayList();
        IUnit unit = archerFactory.create(10, 0,0, tactician);
        IUnit unit1 = fighterFactory.create(20,0,1, tactician);
        list.add(unit);
        list.add(unit1);
        assertNotNull(this.tactician.getPlayerUnits());
        this.tactician.setUnits(list);
        assertEquals(list, this.tactician.getPlayerUnits());
        this.tactician.setUnits(null);
        assertNull(this.tactician.getPlayerUnits());

    }

    @Test
    void setActualItem(){



    }

    @Test
    void setActualUnit(){

        controller.initGame(4);
        Tactician jugador = controller.getActualPlayer();
        IUnit unidad = jugador.getPlayerUnits().get(0);
        IUnit unidad1 = jugador.getPlayerUnits().get(1);
        jugador.setActualUnit(unidad);
        assertEquals(unidad, jugador.getActualUnit());
        assertEquals(unidad, controller.getActualUnit());
        jugador.setActualUnit(jugador.getPlayerUnits().get(1));
        assertEquals(unidad1,  jugador.getActualUnit());
        assertEquals(unidad1, controller.getActualUnit());

    }

    @Test
    void setSelectUnit(){

        controller.initGame(4);
        Tactician jugador = controller.getActualPlayer();
        IUnit unidad = jugador.getPlayerUnits().get(0);
        IUnit unidad1 = jugador.getPlayerUnits().get(1);
        jugador.setSelectIUnit(unidad);
        assertEquals(unidad, jugador.getSelectIUnit());
        assertEquals(unidad, controller.getSelectUnit());
    }







}
