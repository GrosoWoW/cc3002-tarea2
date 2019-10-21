package factory;

import model.map.Field;
import model.map.InvalidLocation;
import model.map.Location;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MapFactory {

    private int size;
    private int sizeMap;

    public MapFactory(){

        this.sizeMap = sizeMap;
    }

    public Field checkMap(Field map) {

        if (map.isConnected()) {
            return map;
        } else {

            for (int i = 0; i <map.getSize(); i++) {
                for (int j = 0; j < map.getSize(); j++) {

                    Location location = map.getCell(i, j);
                    if(location.getNeighbours().size() == 0){
                        if(location.getRow() < map.getSize()-1 && location.getRow() > 0){
                            location.addNeighbour(map.getCell(i+1, j));
                            location.addNeighbour(map.getCell(i-1, j));
                        }
                        if(location.getColumn() < map.getSize()-1 && location.getColumn() > 0){
                            location.addNeighbour(map.getCell(i, j+1));
                            location.addNeighbour(map.getCell(i,j-1));
                        }
                        if(map.isConnected()){
                            return map;
                        }
                    }
                }
            }
            return map;
        }
    }


    public Field createMapSeed(int size, Random seed){

        Field map = new Field();
        map.setRandom(seed);
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                map.addCells(false, new Location(i, j));
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){


                int numeroRandom = seed.nextInt(4);
                if(numeroRandom == 0){

                    Location location = map.getCell(i ,j);
                    Set<Location> vecinos = location.getNeighbours();
                    Iterator<Location> itr = vecinos.iterator();
                    while(itr.hasNext()){
                        Location o = itr.next();
                        location.removeNeighbour(o);
                    }
                }
            }
        }
        return checkMap(map);
    }


    public Field createMap(int size){

        Field map = new Field();
        Random seed = map.getSeed();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                map.addCells(false, new Location(i, j));
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){


                int numeroRandom = seed.nextInt(4);
                if(numeroRandom == 0){

                    Location location = map.getCell(i ,j);
                    Set<Location> vecinos = location.getNeighbours();
                    Iterator<Location> itr = vecinos.iterator();
                    while(itr.hasNext()){
                        Location o = itr.next();
                        location.removeNeighbour(o);
                    }
                }
            }
        }
        return checkMap(map);
    }
}
