package factory;

import controller.GameController;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class mapFactoryTest {

    private GameController controller;
    private Field map;
    private MapFactory mapFactory;



    @BeforeEach
    void setUp(){

        controller = new GameController(4, 7);
        this.map = controller.getGameMap();
        this.mapFactory = new MapFactory();
    }




    @Test
    void equalsMap(){

        Random random = this.map.getSeed();
        Field nuevoMapa = mapFactory.createMapSeed(7, random);
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j< map.getSize(); j++){

                Location xMap = this.map.getCell(i,j);
                Location xNuevo = nuevoMapa.getCell(i,j);
                assertTrue(xMap.equals(xNuevo));
            }
        }



    }









}
