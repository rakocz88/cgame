package com.pilaf.cgame.api.equipment.model;

import com.pilaf.cgame.shared.interfaces.HandUsable;
import com.pilaf.cgame.shared.interfaces.Item;
import com.pilaf.cgame.shared.valueobject.DmgType;
import com.pilaf.cgame.shared.valueobject.ShieldId;
import lombok.Value;
import java.util.Map;

@Value(staticConstructor = "of")
public class Shield implements HandUsable, Item {
    ShieldId shieldId;
    String name;
    Map<DmgType, Integer> armorDice;
    int weight;
    int dodgePenalty;
    int dexterityPenalty;
    int speedPenalty;
    int attackSpeedPenalty;
    int spellCastPenalty;
}
