package com.pilaf.cgame.api.diceroll.model;

import lombok.Value;

@Value
public class RollDiceResult {
    int hitResult;
    int dodgeResult;
    int dmgResult;
    int armorResult;
    int combatTrickResult;
    int spellTrickResult;
}
