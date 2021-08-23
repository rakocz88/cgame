package com.pilaf.cgame.api.diceroll;

import com.pilaf.cgame.api.diceroll.model.RollDiceResult;
import com.pilaf.cgame.shared.valueobject.Dice;

import java.util.List;

public interface DiceRollAPI {

    RollDiceResult rollDices(List<Dice> dices);
}
