package SnakeLadders.service;

import SnakeLadders.interfaces.EntityType;
import SnakeLadders.interfaces.PlayerInterface;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arun.gupta on 08/11/15.
 */
public class PlayerService implements PlayerInterface {

    private List<Player> players;

    public PlayerService(LinkedList<Player> players) {
        this.players = players;
    }

    public Player getPlayer(int playerLocation) {
        return players.get(playerLocation);
    }

    public int getPlayerSize() {
        return players.size();
    }

    public void addPlayer(int playerId, Player player) {
        players.add(playerId, player);
    }

    @Override
    public int getPlayerCurrentLocation() {
        return 0;
    }

    @Override
    public int updatePlayerLocation(int playerId, int diceValue, HashMap<Integer, Entity> board, HashMap<Integer, Integer> boardEntityMapping) {
        Player player = players.get(playerId);
        Integer entityId = isEntityAtPlayersCurrentLocation(player.getPlayerLocation() + diceValue, boardEntityMapping);
        if (entityId == null) {
            player.setPlayerLocation(player.getPlayerLocation() + diceValue);
        } else {
            player.setPlayerLocation(getPlayerNewLocation(player, entityId, diceValue, board));
        }
        return player.getPlayerLocation();
    }

    public Integer isEntityAtPlayersCurrentLocation(int location, HashMap<Integer, Integer> boardEntityMapping) {
        return boardEntityMapping.get(location);
    }

    private Integer getPlayerNewLocation(Player player, Integer entityId, Integer diceValue, HashMap<Integer, Entity> board) {
        Entity entityService = board.get(entityId);
        if (entityService.getEntityType() == EntityType.SNAKE) {
            player.setPlayerLocation(entityService.getEndPosition());
        } else if (entityService.getEntityType() == EntityType.LADDER) {
            player.setPlayerLocation(entityService.getEndPosition());
        }
        return player.getPlayerLocation();
    }
}
