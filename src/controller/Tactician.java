package controller;

import controller.changes.ActualUnitChange;
import controller.changes.HeroDie;
import controller.changes.SelectUnitChange;
import model.items.IEquipableItem;
import model.units.IUnit;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {

    private final String name;
    private List<IUnit> playerUnit;
    private IUnit actualUnit;
    private IUnit selectIUnit;
    private IEquipableItem actualItem;
    private GameController controller;
    private PropertyChangeSupport handler1;
    private PropertyChangeSupport handler2;
    private PropertyChangeSupport handler3;
    private ActualUnitChange actualUnitChange;
    private SelectUnitChange selectUnitChange;
    private HeroDie heroDie = new HeroDie();

    public Tactician(String name, GameController controller){

        this.name = name;
        this.playerUnit = new ArrayList<IUnit>();
        this.controller = controller;
        actualUnitChange =  new ActualUnitChange(this.controller);
        selectUnitChange = new SelectUnitChange(this.controller);
        handler1 = new PropertyChangeSupport(this);
        handler2 = new PropertyChangeSupport(this);
        handler3 = new PropertyChangeSupport(this);
        handler1.addPropertyChangeListener(actualUnitChange);
        handler2.addPropertyChangeListener(heroDie);
        handler3.addPropertyChangeListener(selectUnitChange);
    }


    public void setUnits(List<IUnit> newUnits){

        playerUnit = newUnits;
    }

    public void setActualUnit(IUnit newUnit){

        if(this.getPlayerUnits().contains(newUnit)) {

            IUnit oldUnit = actualUnit;
            actualUnit = newUnit;
            handler1.firePropertyChange("actualUnit", oldUnit, newUnit);
        }
    }

    public void heroDie(){}

    public void setSelectIUnit(IUnit newUnit){

        IUnit oldUnit = selectIUnit;
        selectIUnit = newUnit;
        handler3.firePropertyChange("selectUnit", oldUnit, newUnit);
    }

    public void setActualItem(IEquipableItem newItem){

        if(this.getActualUnit().getItems().contains(newItem)) {

            //IEquipableItem oldItem = actualItem;
            actualItem = newItem;
            //changes.firePropertyChange("actualItem", oldItem, newItem);
        }
    }

    public String getName(){
        return this.name;
    }

    public List<IUnit> getPlayerUnits(){
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
