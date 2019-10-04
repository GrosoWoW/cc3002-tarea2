package controller;

import java.util.ArrayList;
import java.util.List;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;
import java.util.Random;

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
  private List listOfPlayers;
  private int actualRound;
  private List listOfWinners;
  private int maxRounds;
  private Tactician actualPlayer;

  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {

    this.numberOfPlayers = numberOfPlayers;
    this.mapSize = mapSize;
    this.listOfPlayers = randomList(numberOfPlayers, addPlayers(numberOfPlayers));
    this.actualRound = 0;
    this.listOfWinners = null;
    this.maxRounds = 0;
    this.actualPlayer = null;

  }

  /**
   * @return the list of all the tacticians participating in the game.
   */

  public List<Tactician> addPlayers(int maxPlayers) {

    List players = new ArrayList();
    for (int i = 0; i < maxPlayers; i++) {

      Tactician player = new Tactician("Player " + i);
      players.add(player);
    }
    return players;
  }

    public List<Tactician> randomList(int numberPlayers, List<Tactician> players){
    Random r = new Random();
    List randomPlayers = new ArrayList();

    for(int i = 0; i < numberPlayers; i++){

      int numeroRandom = r.nextInt(numberPlayers - i);
      randomPlayers.add(players.get(numeroRandom));
      players.remove(players.get(numeroRandom));
    }
    return randomPlayers;
  }
  public List<Tactician> getTacticians() {
    return this.listOfPlayers;
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return null;
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

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {

    this.listOfPlayers = randomList(numberOfPlayers, this.listOfPlayers);
    this.actualRound++;

  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {

  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {




  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {

  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    return listOfWinners;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return null;
  }

  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {

  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return null;
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {

  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {

  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {

  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {

  }

  public int getNumberOfPlayers(){

    return this.numberOfPlayers;
  }
}
