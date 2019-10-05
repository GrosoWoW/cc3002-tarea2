package factory;

import model.map.Field;
import model.map.InvalidLocation;
import model.map.Location;

import java.util.Random;

public class MapFactory {

    private int size;
    private int sizeMap;

    public MapFactory(){

        this.sizeMap = sizeMap;
    }

    public Field createMap(int size){

        Field map = new Field();
        Random r = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++ ){

                int numeroRandom = r.nextInt(1);
                if(numeroRandom == 0){
                    map.addCells(true, new Location(i, j));
                }
                else{
                    map.addCells(true, new InvalidLocation());
                }
            }
        }
        
        return map;

    }
}
