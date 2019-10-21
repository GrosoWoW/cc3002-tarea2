package controller;

import model.items.IEquipableItem;
import model.units.IUnit;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

    private final String name;
    private List playerUnit;
    private IUnit actualUnit;
    private IUnit selectIUnit;
    private IEquipableItem actualItem;
    private GameController controller;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public Tactician(String name, GameController controller){

        this.name = name;
        this.playerUnit = new ArrayList();
        this.controller = controller;
        this.addObserver(controller);
    }

    public void addObserver(GameController resp){

        changes.addPropertyChangeListener(resp);
    }

    public void setUnits(List<IUnit> newUnits){

        List<IUnit> oldUnits = playerUnit;
        playerUnit = newUnits;
        changes.firePropertyChange("playerUnit", oldUnits, newUnits);
    }

    public void setActualUnit(IUnit newUnit){

        if(this.getPlayerUnits().contains(newUnit)) {

            IUnit oldUnit = actualUnit;
            actualUnit = newUnit;
            changes.firePropertyChange("actualUnit", oldUnit, newUnit);
        }
    }

    public void setSelectIUnit(IUnit newUnit){

        IUnit oldUnit = selectIUnit;
        selectIUnit = newUnit;
        changes.firePropertyChange("selectUnit", oldUnit, newUnit);
    }

    public void setActualItem(IEquipableItem newItem){

        if(this.getActualUnit().getItems().contains(newItem)) {

            IEquipableItem oldItem = actualItem;
            actualItem = newItem;
            changes.firePropertyChange("actualItem", oldItem, newItem);
        }
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

    public IUnit getSelectIUnit(){

        return this.selectIUnit;
    }

    public IEquipableItem getActualItem(){

        return this.actualItem;
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


    public void addUnit(IUnit unit){

        this.playerUnit.add(unit);
    }

    public void setItem(IEquipableItem item){

        if(this.actualUnit.getItems().contains(item)){

            this.actualUnit.setEquippedItem(item);
        }
    }









}
