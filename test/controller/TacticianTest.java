package controller;

import factory.item.BowFactory;
import factory.item.DarkFactory;
import factory.unit.*;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.Archer;
import model.units.IUnit;
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
    private SwordMasterFactory swordMasterFactory;


    @BeforeEach
    void setUp(){
        this.controller = new GameController(4, 4);
        this.map = new Field();
        this.map.addCells(true, new Location(0,0));
        this.map.addCells(true, new Location(0,1));
        this.map.addCells(true, new Location(0,2));
        this.map.addCells(true, new Location(4,0));
        this.map.addCells(true, new Location(0,6));
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
        this.swordMasterFactory = new SwordMasterFactory(tactician.getMap());

        this.unidades = controller.getActualPlayer().getPlayerUnits();
        this.jugador = new Tactician("player", controller);
        this.unit = archerFactory.createDefault(jugador);
        jugador.setActualUnit(unit);
        jugador.setLocationUnit(0, 0);
        this.item1 = bowFactory.create(20, 1,5);
        unit.addItem(item1);
        unit.setEquippedItem(item1);
        jugador.addUnit(unit);
        jugador.setActualUnit(unit);
        jugador.setLocationUnit(0,0);
    }


    @Test
    void getName(){

        assertEquals(this.tactician.getName(), controller.getActualPlayer().getName());
    }
    @Test
    void getPlayerUnit(){
        assertEquals(this.tactician.getActualUnit(), unidades.get(0));
        assertNotEquals(this.tactician.getActualUnit(), unidades.get(1));

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
    void getInventoryUnit(){

        controller.initGame(4);
        IEquipableItem bow = bowFactory.createDefault();
        List<IEquipableItem> inventory = tactician.getActualUnit().getItems();
        assertEquals(inventory, tactician.getInventoryUnit());
        tactician.getPlayerUnits().get(0).addItem(bow);
        tactician.getActualUnit().addItem(bow);
        assertTrue(tactician.getInventoryUnit().contains(bow));
    }

    @Test
    void getActualUnit(){

        IUnit unidad = controller.getActualPlayer().getPlayerUnits().get(0);
        assertEquals(unidad, tactician.getActualUnit());
        this.tactician.setActualUnit(controller.getActualPlayer().getPlayerUnits().get(1));
        assertEquals(controller.getActualPlayer().getPlayerUnits().get(1), this.tactician.getActualUnit());
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
    void getActualItem(){

        controller.initGame(4);
        IEquipableItem bow = bowFactory.createDefault();
        tactician.getActualUnit().addItem(bow);
        assertNotEquals(tactician.getActualItem(), bow);
        tactician.setActualItem(bow);
        assertEquals(tactician.getActualItem(), bow);
    }


    @Test
    void attackUnitTest(){

        IUnit unidad = alpacaFactory.create(50, tactician);
        tactician.setActualUnit(unidad);
        tactician.setLocationUnit(0, 2);
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

        IUnit unidad = clericFactory.create(10, tactician);
        tactician.setActualUnit(unidad);
        tactician.setLocationUnit(0, 1);
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

        IUnit unidad = clericFactory.create(10, tactician);
        IEquipableItem item = bowFactory.create(10, 0, 0);
        unidad.addItem(item);
        tactician.setActualUnit(unidad);
        tactician.setLocationUnit(0, 1);
        assertTrue(jugador.getActualUnit().getItems().contains(this.item1));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        tactician.giftItem(jugador.getActualUnit(), item);
        assertTrue(jugador.getActualUnit().getItems().contains(item));
        assertFalse(tactician.getActualUnit().getItems().contains(item));


    }

    @Test
    void receiveItem(){

        IUnit unidad = clericFactory.create(10, tactician);
        IEquipableItem item = bowFactory.create(10, 0, 0);
        unidad.addItem(item);
        tactician.setActualUnit(unidad);
        tactician.setLocationUnit(0, 1);
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        assertFalse(jugador.getActualUnit().getItems().contains(item));
        tactician.receiveItem(jugador.getActualUnit(), this.item1);
        assertFalse(jugador.getActualUnit().getItems().contains(this.item1));
        assertTrue(tactician.getActualUnit().getItems().contains(item));
        assertTrue(tactician.getActualUnit().getItems().contains(this.item1));

    }

    /**
     * Test para el metodo addUnit, verifica que la unidad sea añadida a la lista de unidades del jugador
     */
    @Test
    void addUnit(){

        controller.initGame(4);
        IUnit newUnit = new Archer(10, 1, new Location(0, 0));
        assertFalse(tactician.getPlayerUnits().contains(newUnit));
        tactician.addUnit(newUnit);
        assertTrue(tactician.getPlayerUnits().contains(newUnit));
    }

    @Test
    void setUnits() {

        List<IUnit> list = new ArrayList<>();
        IUnit unit = archerFactory.create(10, tactician);
        tactician.setActualUnit(unit);
        tactician.setLocationUnit(0, 0);
        IUnit unit1 = fighterFactory.create(20, tactician);
        tactician.setActualUnit(unit1);
        tactician.setLocationUnit(0, 1);
        list.add(unit);
        list.add(unit1);
        assertNotNull(this.tactician.getPlayerUnits());
        this.tactician.setUnits(list);
        assertEquals(list, this.tactician.getPlayerUnits());
        this.tactician.setUnits(null);
        assertNull(this.tactician.getPlayerUnits());

    }

    @Test
    void setActualUnit(){

        controller.initGame(4);
        Tactician jugador = controller.getActualPlayer();
        IUnit unidad = archerFactory.createDefault(jugador);
        IUnit unidad1 = archerFactory.createDefault(jugador);
        jugador.setActualUnit(unidad);
        jugador.setLocationUnit(0, 6);
        assertEquals(unidad, jugador.getActualUnit());
        jugador.setActualUnit(unidad1);
        jugador.setLocationUnit(4, 0);
        assertEquals(unidad1,  jugador.getActualUnit());

    }

    /**
     * Verifica el movimiento de una unidad
     */

    @Test
    void movementUnit(){

        tactician.getMap().addCells(true, new Location(0,0));
        tactician.getMap().addCells(true, new Location(0,2));
        tactician.getMap().addCells(true, new Location(0,3));
        tactician.getMap().getCell(0, 0).removeUnit();
        IUnit unit = swordMasterFactory.createDefault(tactician);
        tactician.getMap().getCell(0, 0).setUnit(unit);
        tactician.getMap().getCell(0, 1).removeUnit();
        tactician.getMap().getCell(0, 2).removeUnit();
        tactician.getMap().getCell(0, 3).removeUnit();
        tactician.setActualUnit(unit);
        tactician.setLocationUnit(0, 0);
        assertEquals(tactician.getMap().getCell(0, 0).getUnit(), unit);
        assertNotEquals(tactician.getMap().getCell(0, 1).getUnit(), unit);
        tactician.moveUnit(0, 1);
        assertEquals(tactician.getMap().getCell(0, 1).getUnit(), unit);
        assertNotEquals(tactician.getMap().getCell(0, 0).getUnit(), unit);
        tactician.moveUnit(0, 3);
        assertNotEquals(tactician.getMap().getCell(0, 3).getUnit(), unit);

    }

}
