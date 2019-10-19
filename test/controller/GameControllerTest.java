package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import factory.item.AxeFactory;
import factory.unit.AlpacaFactory;
import factory.unit.HeroFactory;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.InvalidLocation;
import model.map.Location;
import model.units.IUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */
class GameControllerTest {

  private GameController controller;
  private long randomSeed;
  private List<Tactician> testTacticians;
  private HeroFactory heroFactory;
  private AxeFactory axeFactory;
  private AlpacaFactory alpacaFactory;

  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests
    randomSeed = new Random().nextLong();
    controller = new GameController(4, 7);
    controller.initEndlessGame();
    testTacticians =  controller.getTacticians();
    heroFactory = new HeroFactory(controller.getGameMap());
    axeFactory = new AxeFactory();
    alpacaFactory = new AlpacaFactory(controller.getGameMap());
  }

  public IUnit randomUnit(){

    Field map = controller.getGameMap();
    InvalidLocation invalid = new InvalidLocation();
    for(int i = 0; i < map.getSize(); i++){
      for(int j = 0; j< map.getSize(); j++){

        if(!map.getCell(i,j).equals(invalid)){

          IUnit unit = heroFactory.create(20, i, j, null);
          map.getCell(i,j).setUnit(unit);
          return unit;
        }
      }
    }
    return null;
  }

  public boolean isTactician(String player, List<Tactician> list){

    for(int i = 0; i<list.size(); i++){

      if(list.get(i).getName().equals(player)){
        return true;
      }
    }
    return false;
  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {

      assertTrue(isTactician("Player "+i, tacticians));

    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(7, gameMap.getSize()); // getSize deben definirlo
    assertTrue(controller.getGameMap().isConnected());
    Random testRandom = new Random(randomSeed);
    // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
    //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
    //    las dimensiones definidas y que sea conexo.
    //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
    //    secuencia de números generada sea siempre la misma, así pueden predecir los
    //    resultados que van a obtener.
    //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
    //    usar el método setSeed de Random.
    //  ESTO ÚLTIMO NO ESTÁ IMPLEMENTADO EN EL MAPA, ASÍ QUE DEBEN AGREGARLO (!)
  }

  @Test
  void getTurnOwner() {
    //  En este caso deben hacer lo mismo que para el mapa
  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {

      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    Random randomTurnSequence = new Random();
    IntStream.range(0, 50).map(i -> randomTurnSequence.nextInt() & Integer.MAX_VALUE).forEach(nextInt -> {
      controller.initGame(nextInt);
      System.out.println(nextInt);
      assertEquals(nextInt, controller.getMaxRounds());
      System.out.println(nextInt);
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    Tactician firstPlayer = controller.getTurnOwner();
    // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
    Tactician secondPlayer = new Tactician("Player 1"); // <- Deben cambiar esto (!)
    assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

    controller.endTurn();
    assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
    assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians().forEach(tactician -> assertNotEquals("Player 0", tactician));
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 5");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    IntStream.range(0, 8).forEach(i -> controller.endTurn());
    assertEquals(4, controller.getWinners().size());
    controller.getWinners()
        .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

    controller.initGame(2);
    IntStream.range(0, 4).forEach(i -> controller.endTurn());
    assertNull(controller.getWinners());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 2");
    IntStream.range(0, 2).forEach(i -> controller.endTurn());
    List<String> winners = controller.getWinners();
    assertEquals(2, winners.size());
    assertTrue(List.of("Player 1", "Player 3").containsAll(winners));

    controller.initEndlessGame();
    for (int i = 0; i < 3; i++) {
      assertNull(controller.getWinners());
      controller.removeTactician("Player " + i);
    }
    assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {

    List<Tactician> listaTactician = controller.getTacticians();
    this.controller.setActualPlayer(listaTactician.get(0));
    IUnit unidadValida = randomUnit();
    assertNull(controller.getActualPlayer().getSelectIUnit());
    int x = unidadValida.getLocation().getRow();
    int y = unidadValida.getLocation().getColumn();
    controller.selectUnitIn(x,y);
    assertEquals(unidadValida, controller.getActualPlayer().getSelectIUnit());
    assertNotEquals(unidadValida, controller.getActualPlayer().getActualUnit());
    assertEquals(unidadValida, controller.getActualPlayer().getSelectIUnit());

  }

  @Test
  void selectUnitIn() {

      List<Tactician> listaTactician = controller.getTacticians();
      this.controller.setActualPlayer(listaTactician.get(1));
      IUnit unidadValida = randomUnit();
      int x = unidadValida.getLocation().getRow();
      int y = unidadValida.getLocation().getColumn();
      controller.selectUnitIn(x, y);
      assertEquals(unidadValida, controller.getActualPlayer().getSelectIUnit());
      assertNotEquals(unidadValida, controller.getActualPlayer().getActualUnit());
      assertEquals(unidadValida, controller.getActualPlayer().getSelectIUnit());


  }

  @Test
  void getItems() {

      List<Tactician> listaTactician = controller.getTacticians();
      Tactician player = listaTactician.get(0);
      this.controller.setActualPlayer(player);
      IUnit unidad = randomUnit();
      IEquipableItem objeto = axeFactory.create(2, 1, 2);
      List lista = new ArrayList();
      lista.add(objeto);
      unidad.addItem(objeto);
      player.addUnit(unidad);
      this.controller.getActualPlayer().setActualUnit(unidad);
      assertEquals(lista, this.controller.getItems());

  }

  @Test
  void equipItem() {

    List<Tactician> listaTactician = controller.getTacticians();
    Tactician player = listaTactician.get(0);
    this.controller.setActualPlayer(player);
    IEquipableItem objeto = axeFactory.create(2,1,2);
    IUnit unidad = randomUnit();
    List lista = new ArrayList();
    lista.add(objeto);
    player.addUnit(unidad);
    unidad.addItem(objeto);
    this.controller.getActualPlayer().setActualUnit(unidad);
    assertNull(this.controller.getActualPlayer().getActualUnit().getEquippedItem());
    this.controller.equipItem(0);
    assertEquals(objeto, this.controller.getActualPlayer().getActualUnit().getEquippedItem());


  }

  @Test
  void useItemOn() {

    List<Tactician> listaTactician = controller.getTacticians();
    this.controller.setActualPlayer(listaTactician.get(0));
    IUnit unidadValida = randomUnit();
    int x = unidadValida.getLocation().getRow();
    int y = unidadValida.getLocation().getColumn();
    controller.selectUnitIn(x,y);
    controller.getActualPlayer().addUnit(unidadValida);
    controller.getActualPlayer().setActualUnit(unidadValida);
    IUnit alpaca = alpacaFactory.create(100, 0, 0, listaTactician.get(0));
    controller.useItemOn(0,0);

  }

  @Test
  void selectItem() {

    List<Tactician> listaTactician = controller.getTacticians();
    Tactician player = listaTactician.get(0);
    this.controller.setActualPlayer(player);
    IEquipableItem objeto = axeFactory.create(2,1,2);
    IUnit unidad = randomUnit();
    unidad.addItem(objeto);
    player.addUnit(unidad);
    player.setActualUnit(unidad);
    assertNull(controller.getActualPlayer().getActualItem());
    controller.selectItem(0);
    assertEquals(objeto, controller.getActualPlayer().getActualItem());


  }

  @Test
  void giveItemTo() {

    IUnit selectUnit = heroFactory.createDefault(0,0, testTacticians.get(0));
    IUnit unit = heroFactory.createDefault(0,1, testTacticians.get(1));
    controller.getGameMap().getCell(0, 0).setUnit(selectUnit);
    controller.getGameMap().getCell(0, 1).setUnit(unit);
    IEquipableItem objeto = axeFactory.create(2,1,2);
    IEquipableItem objeto2 = axeFactory.create(3, 1, 3);
    unit.addItem(objeto2);
    assertFalse(selectUnit.getItems().contains(objeto));
    assertFalse(unit.getItems().contains(objeto));
    selectUnit.addItem(objeto);
    controller.getActualPlayer().addUnit(selectUnit);
    assertTrue(selectUnit.getItems().contains(objeto));
    assertFalse(unit.getItems().contains(objeto));
    controller.setActualPlayer(this.testTacticians.get(0));
    controller.getActualPlayer().setActualUnit(selectUnit);
    controller.getActualPlayer().setActualItem(objeto);
    controller.giveItemTo(0, 1);
    assertTrue(unit.getItems().contains(objeto));


  }

  @Test
  void getNumberPlayersTest(){


  }
}