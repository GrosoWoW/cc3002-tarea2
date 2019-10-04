package factory;

import model.map.Field;
import java.util.Random;

public class MapFactory {

    private int size;
    private int sizeMap;

    MapFactory(int sizeMap){

        this.sizeMap = sizeMap;
    }

    public Field createMap(int size){

        Field map = new Field();
        
        return map;

    }
}
