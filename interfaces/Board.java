package SnakeLadders.interfaces;

import SnakeLadders.exceptions.BoardSizeExceedsException;
import SnakeLadders.service.Entity;
import SnakeLadders.service.Player;

/**
 * Created by arun.gupta on 21/08/15.
 */
public interface Board extends Dice {

    public void createBoard(int length, int width);

    public void addEntityInBoard(Entity entity) throws BoardSizeExceedsException;

    // ToBe implement
    public int getNextLocation(int location);

    public String validateEntities();

    public void addPlayer(int playerId, Player player);

    public boolean anyOneWon();
}
