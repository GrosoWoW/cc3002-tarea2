package controller.changes;

import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UnitDie implements PropertyChangeListener {


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        IUnit unit = (IUnit) evt.getNewValue();
        unit.setLifeDead();
        Location location = unit.getLocation();
        location.removeUnit();
        if(unit.isHero() && unit.getOwner() != null){
            unit.getOwner().heroDie();
        }


    }
}
