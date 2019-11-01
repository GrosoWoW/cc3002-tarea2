package controller;

import java.util.ArrayList;
import java.util.List;

import factory.unit.*;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;
import java.util.Random;
import factory.*;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {

  private int numberOfPlayers;
  private int mapSize;
  private List<Tactician> listOfPlayers;
  private int actualRound;
  private List<Tactician> listOfWinners;
  private int maxRounds;
  private Tactician actualPlayer;
  private Field gameMap;
  private Random random;
  private int maxNumberOfPlayers;
  private MapFactory mapFactory;
  private IUnit actualUnit;


  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers the number of players for this game
   * @param mapSize         the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {

    this.numberOfPlayers = numberOfPlayers;
    this.mapSize = mapSize;
    this.actualRound = 1;
    this.maxRounds = -1;
    this.random = new Random();
    this.maxNumberOfPlayers = numberOfPlayers;
    this.mapFactory = new MapFactory();
    this.gameMap = mapFactory.createMap(mapSize);

  }

  /**
   * Crea la lista inicial de jugadores
   *
   * @param maxPlayers Cantidad maxima de jugadores de la partida
   * @return Lista con todos los jugadores
   */

  public List<Tactician> addPlayers(int maxPlayers) {

    List players = new ArrayList();
    for (int i = 0; i < maxPlayers; i++) {

      Tactician player = new Tactician("Player " + i, this);
      players.add(player);
    }
    return players;
  }

  /**
   * Reordena una lista de manera aleatoria, asegurando que el el ultimo jugador nunca
   * quede al inicio de la nueva lista
   *
   * @param numberPlayers Cantidad de jugadores actuales
   * @param players       Lista de jugadores a cambiar
   * @param seed          Semilla (para cosas de testeo)
   * @return Lista de jugadores
   */

  public List<Tactician> randomList(int numberPlayers, List<Tactician> players, Random seed) {

    List<Tactician> randomPlayers = new ArrayList<Tactician>();
    List<Tactician> jugadores = players;
    Tactician ultimoJugador = jugadores.get(jugadores.size() - 1);
    jugadores.remove(jugadores.size() - 1);

    for (int i = 0; i < numberPlayers - 1; i++) {

      int numeroRandom = seed.nextInt(numberPlayers - i - 1);
      randomPlayers.add(jugadores.get(numeroRandom));
      jugadores.remove(jugadores.get(numeroRandom));
    }

    int numRandom = seed.nextInt(numberPlayers);
    randomPlayers.add(numRandom, ultimoJugador);
    return randomPlayers;
  }

  /**
   * @return the list of all the tacticians participating in the game.
   */

  public List<Tactician> getTacticians() {
    return this.listOfPlayers;
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return this.gameMap;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return actualPlayer;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return this.actualRound;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return this.maxRounds;
  }

  public Tactician getActualPlayer() {
    return this.actualPlayer;
  }

  public void setActualPlayer(Tactician player) {

    this.actualPlayer = player;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {

    List<Tactician> list = this.listOfPlayers;
    int tamano = list.size();
    if (this.getTacticians().size() == 1) {

      this.listOfWinners = this.getTacticians();
    } else if (list.get(tamano - 1).getName() == this.actualPlayer.getName()) {

      endRound();
    } else {

      int i = list.indexOf(this.actualPlayer);
      actualPlayer = list.get(i + 1);
    }
  }

  /**
   * Termina una ronda cuando todas los Tactician han jugado su turno
   */

  public void endRound() {

    if (this.getTacticians().size() == 1) {

      this.listOfWinners = this.getTacticians();
    } else if (this.getRoundNumber() == this.getMaxRounds()) {

      this.listOfWinners = this.listOfPlayers;
    } else {

      this.actualRound++;
      this.listOfPlayers = randomList(this.numberOfPlayers, this.listOfPlayers, random);
      actualPlayer = listOfPlayers.get(0);
    }
  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician the player to be removed
   */
  public void removeTactician(String tactician) {

    for (int i = 0; i < this.getTacticians().size(); i++) {

      if (this.getTacticians().get(i).getName().equals(tactician)) {

        if ((this.getTacticians().size() >= 2) && (this.actualPlayer == this.getTacticians().get(i))) {
          this.actualPlayer = this.getTacticians().get(i + 1);
        }

        this.listOfPlayers.remove(i);
        this.numberOfPlayers--;

      }
      if (this.getTacticians().size() == 1) {

        this.listOfWinners = this.getTacticians();
      }
    }
  }
  /**
   * Starts the game.
   *
   * @param maxTurns the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {

    this.listOfWinners = null;
    this.listOfPlayers = randomList(maxNumberOfPlayers, addPlayers(numberOfPlayers), random);
    this.maxRounds = maxTurns;
    this.actualRound = 1;
    this.actualPlayer = this.listOfPlayers.get(0);

    for (int i = 0; i < listOfPlayers.size(); i++) {

      Tactician player = listOfPlayers.get(i);
      List<IUnit> list = setUnits(player);
      player.setUnits(list);

    }
  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {

    this.listOfWinners = null;
    this.listOfPlayers = randomList(maxNumberOfPlayers, addPlayers(maxNumberOfPlayers), random);
    this.actualRound = 1;
    this.actualPlayer = this.listOfPlayers.get(0);
    this.maxRounds = -1;

    for (int i = 0; i < listOfPlayers.size(); i++) {

      Tactician player = listOfPlayers.get(i);
      List<IUnit> list = setUnits(player);
      player.setUnits(list);
    }
  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<Tactician> getWinners() {
    return this.listOfWinners;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return this.actualPlayer.getActualUnit();
  }


  /**
   * Selects a unit in the game map
   *
   * @param x horizontal position of the unit
   * @param y vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {

    Location ubicacion = this.gameMap.getCell(x, y);
    IUnit unidadSeleccionada = ubicacion.getUnit();
    this.actualUnit = unidadSeleccionada;
  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return this.actualPlayer.getInventoryUnit();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index the location of the item in the inventory.
   */
  public void equipItem(int index) {

    if (this.actualPlayer.getInventoryUnit().get(index) != null) {

      IEquipableItem item = this.actualPlayer.getInventoryUnit().get(index);
      this.actualPlayer.setItem(item);
    }
  }

  /**
   * Uses the equipped item on a target
   *
   * @param x horizontal position of the target
   * @param y vertical position of the target
   */
  public void useItemOn(int x, int y) {

    Location locacion = this.getGameMap().getCell(x, y);
    IUnit unit = locacion.getUnit();
    this.actualPlayer.getActualUnit().attackEnemy(unit);

  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index the location of the item in the inventory.
   */
  public void selectItem(int index) {

    IEquipableItem item = this.actualPlayer.getInventoryUnit().get(index);
    this.actualPlayer.setActualItem(item);
  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x horizontal position of the target
   * @param y vertical position of the target
   */
  public void giveItemTo(int x, int y) {

    Location location = gameMap.getCell(x, y);
    IUnit unidad = location.getUnit();
    IUnit actualUnit = actualPlayer.getActualUnit();
    actualUnit.giveAway(unidad, actualPlayer.getActualItem());

  }

  /**
   * Entrega la cantidad de jugadores actuales en el juego
   * @return numero de jugadores
   */

  public int getNumberOfPlayers() {

    return this.numberOfPlayers;
  }

  public List<IUnit> setUnits(Tactician player) {

    List<IUnit> list = new ArrayList<>();

    IUnit alpaca = new AlpacaFactory(this.gameMap).createDefault(0, 1, player);
    IUnit archer = new ArcherFactory(this.gameMap).createDefault(0, 2, player);
    IUnit cleric = new ClericFactory(this.gameMap).createDefault(0, 3, player);
    IUnit fighter = new FighterFactory(this.gameMap).createDefault(0, 4, player);
    IUnit hero = new HeroFactory(this.gameMap).createDefault(1, 0, player);
    IUnit sorcerer = new SorcererFactory(this.gameMap).createDefault(2, 0, player);
    IUnit swordMaster = new SwordMasterFactory(this.gameMap).createDefault(3, 0, player);

    list.add(alpaca);
    list.add(archer);
    list.add(cleric);
    list.add(fighter);
    list.add(hero);
    list.add(sorcerer);
    list.add(swordMaster);

    return list;

  }

  public int getMaxNumberOfPlayers() {

    return this.maxNumberOfPlayers;
  }

  public IUnit getActualUnit() {

    return this.actualUnit;
  }

  public void setActualUnit(IUnit unit) {

    this.actualUnit = unit;
  }

  /**
   * Verifica que para los tacticians en juego, sus heros esten vivos
   */
 // public void verifyHero() {
   // int size = this.getTacticians().size();
    //for (int i = 0; i < size; i++) {

      //getTacticians().get(i).verifyUnits();
      //size = this.getTacticians().size();

   // }
 // }
}


