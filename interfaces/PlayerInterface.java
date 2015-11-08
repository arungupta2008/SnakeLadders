package SnakeLadders.interfaces;

import SnakeLadders.service.Entity;
import java.util.HashMap;

/**
 * Created by arun.gupta on 21/08/15.
 */
public interface PlayerInterface {
    public int getPlayerCurrentLocation();

    public int updatePlayerLocation(int playerId, int diceValue, HashMap<Integer, Entity> board, HashMap<Integer, Integer> boardEntityMapping);
}
