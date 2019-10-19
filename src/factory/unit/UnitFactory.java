package factory.unit;

import model.units.IUnit;

public interface UnitFactory {

    IUnit create();

    IUnit createDefault();
}
