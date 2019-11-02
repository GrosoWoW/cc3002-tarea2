package factory;

import controller.GameController;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Clase para testear la fabrica del mapa
 * @author Cristobal Jaramillo Andrade
 * @since 2.0
 */
public class mapFactoryTest {

    private GameController controller;
    private Field map;
    private MapFactory mapFactory;


    /**
     * Preparacion antes de ejecutar los test
     */
    @BeforeEach
    void setUp(){

        controller = new GameController(4, 7);
        this.map = controller.getGameMap();
        this.mapFactory = new MapFactory();
    }

    /**
     * Se encarga de tomar el mapa del controller y crear uno nuevo con la misma semilla
     * Se verifica que estos dos sean iguales
     */
    @Test
    void equalsMap(){

        Field nuevoMapa = mapFactory.createMap(7);
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j< map.getSize(); j++){

                Location xMap = this.map.getCell(i,j);
                Location xNuevo = nuevoMapa.getCell(i,j);
                assertTrue(xMap.equals(xNuevo));
            }
        }
    }
}
