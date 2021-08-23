package com.pilaf.cgame.api.equipment.model;

import com.pilaf.cgame.shared.interfaces.Item;
import com.pilaf.cgame.shared.valueobject.ArmorId;
import com.pilaf.cgame.shared.valueobject.Dice;
import com.pilaf.cgame.shared.valueobject.DmgType;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value(staticConstructor = "of")
public class Armor implements Item {
    ArmorId armorId;
    String name;
    Map<DmgType, List<Dice>> armorDice;
    int weight;
    int dodgePenalty;
    int dexterityPenalty;
    int speedPenalty;
    int attackSpeedPenalty;
    int spellCastPenalty;
}
