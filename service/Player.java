package SnakeLadders.service;

/**
 * Created by arun.gupta on 21/08/15.
 */
public class Player {

    private int playerId;
    private int playerLocation;


    public Player(Integer playerId) {
        this.playerLocation = 0;
        this.playerId = playerId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Integer playerLocation) {
        this.playerLocation = playerLocation;
    }
}
