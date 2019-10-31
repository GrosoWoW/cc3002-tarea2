package controller.changes;

import controller.GameController;
import controller.Tactician;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeroDie implements PropertyChangeListener {

    private GameController controller;

    public HeroDie(GameController controller){

        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Tactician tactician = (Tactician) evt.getNewValue();
        this.controller.getTacticians().remove(tactician);

    }
}
