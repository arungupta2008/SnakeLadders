package SnakeLadders.service;

import SnakeLadders.interfaces.Dice;

/**
 * Created by arun.gupta on 21/08/15.
 */
public class DiceService implements Dice {

    @Override
    public int getDiceValue() {
        return 0;
    }

    @Override
    public Boolean isValidDiceValue(Integer diceValue) {
        if (diceValue > 0 || diceValue < 7)
            return true;
        else return false;
    }
}
