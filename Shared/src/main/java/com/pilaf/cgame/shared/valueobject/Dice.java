package com.pilaf.cgame.shared.valueobject;

import lombok.Value;

@Value(staticConstructor = "of")
public class Dice {
    DiceType diceType;
    DiceLvl diceLvl;
}
