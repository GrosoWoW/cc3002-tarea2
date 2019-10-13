package controller;

import model.items.IEquipableItem;
import model.items.attack.normal.Bow;
import model.map.InvalidLocation;
import model.units.Archer;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TacticianTest {

    private Tactician tactician;
    private List unidades;


    @BeforeEach
    void setUp(){
        Tactician tactician = new Tactician("Player");
        this.tactician = tactician;
        List<IUnit> unidades = new ArrayList<>();
        this.unidades = unidades;
        IEquipableItem item = new Bow("Arco", 10,1,3);
        IUnit unit = new Archer(10, 1, new InvalidLocation(), item );
        unidades.add(unit);
        this.tactician.setUnits(unidades);
        this.tactician.setActualUnit(unit);
        this.tactician.getActualUnit().setEquippedItem(item);
    }

    @Test
    public void getNameTest(){
        assertEquals(this.tactician.getName(), "Player");
    }
    @Test
    public void getPlayerUnitTest(){
        assertEquals(this.tactician.getActualUnit(), unidades.get(0));

    }

    @Test
    public void getPlayerUnitsTest(){
        assertEquals(this.tactician.getPlayerUnits(), this.unidades);
    }

    @Test
    public void getActualhitPointsUnitTest(){
        assertEquals(this.tactician.getActualHitPointsUnit(), 10);
        this.tactician.getActualUnit().takeDamage(5);
        assertEquals(this.tactician.getActualHitPointsUnit(), 5);

    }
    @Test
    public void getMaxHitPOintsUnitTest(){

        assertEquals(this.tactician.getMaxHitPointsUnit(), 10);
        this.tactician.getActualUnit().takeDamage(5);
        assertEquals(this.tactician.getMaxHitPointsUnit(), 10);
    }

    @Test
    public void getItemPowerUnitTest(){

        assertEquals(this.tactician.getItemPowerUnit(), 10);
    }

    @Test
    public void getItemNameUnitTest(){

        assertEquals(this.tactician.getItemNameUnit(), "Arco");
    }







}
