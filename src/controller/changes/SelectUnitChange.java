package controller.changes;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectUnitChange implements PropertyChangeListener {

    private GameController controller;

    public SelectUnitChange(GameController controller){

        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        this.controller.setSelectUnit((IUnit) evt.getNewValue());

    }
}
