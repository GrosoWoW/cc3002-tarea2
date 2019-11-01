package factory;

import model.map.Field;
import model.map.Location;


import java.util.Iterator;
import java.util.Random;
import java.util.Set;


/**
 * Clase encargada de la fabricacion del mapa de juego
 * @Author Cristóbal Jaramillo Andrede
 * @Since 2.0
 */
public class MapFactory {

    /**
     * Se encarga de chequear el mapa, verificando que el mapa sea conexo
     * En caso contrario agrega vecinos a los nodos que no poseen
     * hasta que logre que sea conexo
     * @param map Mapa a verificar
     * @return Mapa modificado y conexo
     */
    public Field checkMap(Field map) {

        if (map.isConnected()) {
            return map;
        } else {

            for (int i = 0; i <map.getSize(); i++) {
                for (int j = 0; j < map.getSize(); j++) {

                    Location location = map.getCell(i, j);
                    if(location.getNeighbours().size() < 2){
                        if(location.getRow() <= map.getSize()-1 && location.getRow() >= 0){
                            if(location.getRow() == 0) {
                                location.addNeighbour(map.getCell(i + 1, j));
                                map.getCell(i + 1, j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i - 1, j));
                                map.getCell(i - 1, j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j + 1));
                                map.getCell(i , j + 1).addNeighbour(location);

                            }
                            else if(location.getRow() == map.getSize()-1){
                                location.addNeighbour(map.getCell(i + 1, j));
                                map.getCell(i + 1, j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i - 1, j));
                                map.getCell(i - 1 , j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j - 1));
                                map.getCell(i, j - 1).addNeighbour(location);

                            }
                            else{

                                location.addNeighbour(map.getCell(i - 1, j));
                                map.getCell(i - 1, j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j - 1));
                                map.getCell(i, j - 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j + 1));
                                map.getCell(i, j + 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i + 1, j));
                                map.getCell(i + 1, j).addNeighbour(location);

                            }
                        }
                        if(map.isConnected()){
                            return map;
                        }
                        else if(location.getColumn() <= map.getSize()-1 && location.getColumn() >= 0){
                            if(location.getColumn() == 0) {
                                location.addNeighbour(map.getCell(i, j + 1));
                                map.getCell(i, j + 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j - 1));
                                map.getCell(i, j - 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i + 1, j));
                                map.getCell(i + 1, j).addNeighbour(location);

                            }
                            else if(location.getColumn() == map.getSize()-1){
                                location.addNeighbour(map.getCell(i, j + 1));
                                map.getCell(i, j + 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j - 1));
                                map.getCell(i, j - 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i - 1, j));
                                map.getCell(i - 1, j).addNeighbour(location);

                            }
                            else{


                                location.addNeighbour(map.getCell(i, j + 1));
                                map.getCell(i, j + 1).addNeighbour(location);
                                location.addNeighbour(map.getCell(i + 1, j));
                                map.getCell(i + 1, j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i - 1, j));
                                map.getCell(i - 1, j).addNeighbour(location);
                                location.addNeighbour(map.getCell(i, j - 1));
                                map.getCell(i, j - 1).addNeighbour(location);

                            }
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

    /**
     * Crea una mapa con una semilla (para testeo)
     * @param size Tamaño del mapa
     * @param seed Semilla para Random
     * @param field Mapa base donde se creara (testeos)
     * @return
     */

    public Field createMapSeed(int size, Random seed, Field field){

        Field map = field;
        map.setRandom(seed);
        return getField(size, map, seed);
    }

    /**
     * Crea un mapa con la semilla del controlador
     * @param size Tamaño del mapa
     * @return El mapa
     */

    public Field createMap(int size){

        Field map = new Field();
        Random seed = map.getSeed();
        return getField(size, map, seed);
    }

    /**
     * Encargado de introducir las celdas al mapa
     * Con un numero al azar crea celdas con o sin vecinos
     * @param size Tamaño del mapa
     * @param map Mapa base
     * @param seed Semilla (testeos)
     * @return El mapa del juego
     */

    public Field getField(int size, Field map, Random seed) {
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                map.addCells(false, new Location(i, j));
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){


                int numeroRandom = seed.nextInt(2);
                if(numeroRandom == 0){

                    Location location = map.getCell(i ,j);
                    Set<Location> vecinos = location.getNeighbours();
                    Iterator<Location> itr = vecinos.iterator();
                    while(itr.hasNext()){
                        Location o = itr.next();
                        location.removeNeighbour(o);
                        o.removeNeighbour(location);
                    }
                }
            }
        }
        return checkMap(map);
    }
}
