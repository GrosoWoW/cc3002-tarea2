package controller;

import model.items.IEquipableItem;
import model.units.IUnit;

import java.util.ArrayList;
import java.util.List;

public class Tactician {

    private final String name;
    private List playerUnit;
    private IUnit actualUnit;

    public Tactician(String name){

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List getPlayerUnits(){
        return this.playerUnit;

    }

    public double getActualHitPointsUnit(){

        return this.actualUnit.getCurrentHitPoints();
    }

    public double getMaxHitPointsUnit(){

        return this.actualUnit.getMaxHitPoints();
    }

    public List<IEquipableItem> getInventoryUnit(){

        return this.actualUnit.getItems();
    }

    public IUnit getActualUnit(){

        return this.actualUnit;
    }

    public double getItemPowerUnit(){

        return this.actualUnit.getEquippedItem().getPower();
    }

    public String getItemNameUnit(){

        return this.actualUnit.getEquippedItem().getName();
    }

    public void attackUnit(IUnit unit){

        this.actualUnit.attackEnemy(unit);
    }

    public void equipItem(IEquipableItem item){

        this.actualUnit.setEquippedItem(item);
    }

    public void tradeItem(IUnit unit, IEquipableItem received, IEquipableItem delivered){

        this.actualUnit.trade(unit, received, delivered);
    }

    public void giftItem(IUnit unit, IEquipableItem gift){

        this.actualUnit.giveAway(unit, gift);
    }

    public void receiveItem(IUnit unit, IEquipableItem received){

        this.actualUnit.receive(unit, received);
    }

    public void setUnits(List<IUnit> unidades){

        this.playerUnit = unidades;
    }

    public void setActualUnit(IUnit unit){

        this.actualUnit = unit;
    }





}
