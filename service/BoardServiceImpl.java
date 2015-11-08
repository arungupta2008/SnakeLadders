package SnakeLadders.service;

import SnakeLadders.exceptions.BoardSizeExceedsException;
import SnakeLadders.interfaces.Board;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by arun.gupta on 21/08/15.
 */
public class BoardServiceImpl implements Board {

    int length;
    int width;
    Integer entityCount = 1;
    HashMap<Integer, Entity> board;
    HashMap<Integer, Integer> boardEntityMapping;
    PlayerService playerService;
    EntityService entityService;
    DiceService dice;

    @Override
    public void createBoard(int length, int width) {
        this.length = length;
        this.width = width;
        board = new HashMap<Integer, Entity>();
        boardEntityMapping = new HashMap<Integer, Integer>();
        playerService = new PlayerService(new LinkedList<Player>());
        entityService = new EntityService();
        dice = new DiceService();
        //implementBoard();
        System.out.println("Board Size is :" + length * width);

    }

    @Override
    public void addEntityInBoard(Entity entity) throws BoardSizeExceedsException {
        putOnBoard(entity);
    }

    private int boardSize() {
        return length * width;
    }

    // TODO Valdate this
    private void putOnBoard(Entity entity) throws BoardSizeExceedsException {

        if (entity.getStartPosition() < 1 || entity.getStartPosition() > boardSize()) {
            throw new BoardSizeExceedsException("Starting Point is Invalid");
        }
        if (entity.getEndPosition() < 1 || entity.getEndPosition() > boardSize()) {
            throw new BoardSizeExceedsException("Starting Point is Invalid");
        }
        board.put(entityCount, entity);
        boardEntityMapping.put(entity.getStartPosition(), entityCount);
        ++entityCount;
    }

    @Override
    public int getNextLocation(int location) {
        return 0;
    }

    @Override
    public String validateEntities() {
        return entityService.validateEntities(board);
    }

    @Override
    public void addPlayer(int playerId, Player player) {
        playerService.addPlayer(playerId, player);
    }

    @Override
    public boolean anyOneWon() {
        return false;
    }

    public Player getFirstPlayer() {
        return playerService.getPlayer(0);
    }


    public void createPlayers(Integer playerCount) {
        Integer i = 0;
        while (i < playerCount) {
            addPlayer(i, new Player(i));
            ++i;
        }
    }


    @Override
    public int getDiceValue() {
        return 0;
    }

    @Override
    public Boolean isValidDiceValue(Integer diceValue) {
        if (diceValue > 0 && diceValue < 7)
            return true;
        else return false;
    }

    public boolean ifPlayerNotWon(Player currentPlayer) {
        if (currentPlayer.getPlayerLocation() >= (length * width))
            return true;
        else return false;
    }

    public Player getNextPlayer(Player currentPlayer) {
        return playerService.getPlayer(((currentPlayer.getPlayerId() + 1) % playerService.getPlayerSize()));
    }

    public int updatePlayerLocation(Integer playerId, Integer diceValue) throws BoardSizeExceedsException {
        isValidMove(playerId, diceValue);
        return playerService.updatePlayerLocation(playerId, diceValue, board, boardEntityMapping);
    }

    private void isValidMove(Integer playerId, Integer diceValue) throws BoardSizeExceedsException {
        Player player = playerService.getPlayer(playerId);
        if ((player.getPlayerLocation() + diceValue) > boardSize()) {
            throw new BoardSizeExceedsException("Player's current dice value is invalid, " +
                    "Player's current location is " + player.getPlayerLocation() + " " +
                    "and board size is " + boardSize());
        }
    }
}
