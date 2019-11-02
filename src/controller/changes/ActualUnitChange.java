package controller.changes;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ActualUnitChange implements PropertyChangeListener {

    private GameController controller;

    public ActualUnitChange(GameController controller){

        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {


        IUnit unit = (IUnit) evt.getNewValue();
        int x = unit.getLocation().getRow();
        int y = unit.getLocation().getColumn();
        if( x != -1 && y != -1) {
            controller.selectUnitIn(x, y);
        }
        else {
            controller.setActualUnit(unit);
        }

    }
}
