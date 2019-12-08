package controller;

import controller.changes.ActualUnitChange;
import controller.changes.HeroDie;
import model.items.IEquipableItem;
import model.units.IUnit;
import model.map.*;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Tactician, encargada de manejar todo lo relacionado con el jugador
 * @author  Cristóbal Jaramillo Andrade
 * @since  2.0
 */

public class Tactician {

    private final String name;
    private List<IUnit> playerUnit;
    private IUnit actualUnit;
    private IEquipableItem actualItem;
    private GameController controller;
    private PropertyChangeSupport handler1;
    private PropertyChangeSupport handler2;
    private ActualUnitChange actualUnitChange;
    private HeroDie heroDie;
    private Field map;

    /**
     * Constructor de la clase Tactician
     * @param name nombre del jugador
     * @param controller controlador donde se jugara la partida
     */

    public Tactician(String name, GameController controller){

        this.name = name;
        this.playerUnit = new ArrayList<IUnit>();
        this.controller = controller;
        this.map = controller.getGameMap();
        actualUnitChange =  new ActualUnitChange(this.controller);
        heroDie = new HeroDie(this.controller);
        handler1 = new PropertyChangeSupport(this);
        handler2 = new PropertyChangeSupport(this);
        handler1.addPropertyChangeListener(actualUnitChange);
        handler2.addPropertyChangeListener(heroDie);
    }

    /**
     * Coloca las unidades del jugador
     * @param newUnits nuevas unidades del jugador
     */

    public void setUnits(List<IUnit> newUnits){

        playerUnit = newUnits;
    }

    /**
     * Modifica la unidad seleccionada
     * @param newUnit nueva unidad seleccionada
     */

    public void setActualUnit(IUnit newUnit){

        if(this.getPlayerUnits().contains(newUnit)) {

            IUnit oldUnit = actualUnit;
            actualUnit = newUnit;
            handler1.firePropertyChange("actualUnit", oldUnit, newUnit);
        }
    }

    /**
     * Verifica que tu unidad hero este viva
     */

    public void heroDie(){

        Tactician newTactician = this;
        handler2.firePropertyChange("heroDie", null, newTactician);
    }

    /**
     * Modifica el item seleccionado actualmente por el jugador
     * @param newItem nuevo item a seleccionar
     */


    public void setActualItem(IEquipableItem newItem){

        if(this.getActualUnit().getItems().contains(newItem)) {

            actualItem = newItem;
        }
    }

    /**
     * @return el nombre del jugador
     */

    public String getName(){
        return this.name;
    }

    /**
     * @return la lista de unidades del jugador
     */

    public List<IUnit> getPlayerUnits(){
        return this.playerUnit;

    }

    /**
     * @return los puntos de vida actuales de la unidad actual
     */

    public double getActualHitPointsUnit(){

        return this.actualUnit.getCurrentHitPoints();
    }

    /**
     * @return la maxima vida de la unidad actual
     */

    public double getMaxHitPointsUnit(){

        return this.actualUnit.getMaxHitPoints();
    }

    /**
     * @return la lista de items de la unidad actual
     */

    public List<IEquipableItem> getInventoryUnit(){

        return this.actualUnit.getItems();
    }

    /**
     * @return la unidad actual
     */

    public IUnit getActualUnit(){

        return this.actualUnit;
    }

    /**
     * @return el poder del item seleccionado actual
     */

    public double getItemPowerUnit(){

        return this.actualUnit.getEquippedItem().getPower();
    }

    /**
     * @return el nombre del item actual
     */

    public String getItemNameUnit(){

        return this.actualUnit.getEquippedItem().getName();
    }

    /**
     * @return el item actual
     */


    public IEquipableItem getActualItem(){

        return this.actualItem;
    }

    /**
     * Metodo para que una unidad actual ataque a unit
     * @param unit unidad a atacar
     */

    public void attackUnit(IUnit unit){

        this.actualUnit.attackEnemy(unit);
    }

    /**
     * Equipa un item a la unidad actual
     * @param item a equipar
     */

    public void equipItem(IEquipableItem item){

        this.actualUnit.setEquippedItem(item);
    }

    /**
     * Metodo para tradear un item con una unidad
     * @param unit unidad con quien se tradeara
     * @param received item recibido
     * @param delivered item entregado
     */

    public void tradeItem(IUnit unit, IEquipableItem received, IEquipableItem delivered){

        this.actualUnit.trade(unit, received, delivered);
    }

    /**
     * Metodo para regalar un item
     * @param unit unidad a quien se le regalara
     * @param gift item que se regalara
     */

    public void giftItem(IUnit unit, IEquipableItem gift){

        this.actualUnit.giveAway(unit, gift);
    }

    /**
     * Metodo para recibir un item
     * @param unit unidad con quien se tradeara
     * @param received item recibido
     */

    public void receiveItem(IUnit unit, IEquipableItem received){

        this.actualUnit.receive(unit, received);
    }

    /**
     * Añade una unidad a la lista de unidades
     * @param unit unidad que se agregara
     */


    public void addUnit(IUnit unit){

        this.playerUnit.add(unit);
    }

    /**
     * Cambia el item actual
     * @param item que se cambiara
     */

    public void setItem(IEquipableItem item){

        if(this.actualUnit.getItems().contains(item)){

            this.actualUnit.setEquippedItem(item);
        }
    }

    /**
     * Entrega el mapa donde se encuentra jugando el tactician
     * @return el mapa del tactician
     */

    public Field getMap(){
        return this.map;
    }

    /**
     * Mueve a una unidad
     * @param x posicion x donde se desea mover
     * @param y posicion y donde se desea mover
     */

    public void moveUnit(int x, int y) {

        if (this.getActualUnit() != null) {
            Location actualPosicion = this.getActualUnit().getLocation();
            Location posicionFutura = this.getMap().getCell(x, y);
            if (actualPosicion.distanceTo(posicionFutura) <= this.getActualUnit().getMovement() &&
                    actualPosicion.getNeighbours().contains(posicionFutura) && posicionFutura.getUnit() == null && !this.getActualUnit().getMove()) {
                actualPosicion.removeUnit();
                posicionFutura.setUnit(this.getActualUnit());
                this.getActualUnit().setLocation(posicionFutura);
                this.getActualUnit().setMove(true);
            }
        }
    }

    /**
     * Setea la location de una unidad
     * @param x posicion en x
     * @param y posicion en y
     */

    public void setLocationUnit(int x, int y){

        this.actualUnit.setLocation(this.getMap().getCell(x, y));
        this.getMap().getCell(x, y).setUnit(this.actualUnit);
    }
}
