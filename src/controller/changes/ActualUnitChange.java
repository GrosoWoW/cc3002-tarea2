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

        this.controller.setActualUnit((IUnit) evt.getNewValue());

    }
}
