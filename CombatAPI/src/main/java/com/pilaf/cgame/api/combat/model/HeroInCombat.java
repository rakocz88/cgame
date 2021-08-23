package com.pilaf.cgame.api.combat.model;

import com.pilaf.cgame.shared.valueobject.*;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class HeroInCombat implements Hero {
    HeroId heroId;
    HeroLocation heroLocation;
    int initHealthPoints;
    int currentHealthPoints;
    FatigueLevel fatigueLevel;
    SaneLevel saneLevel;
    WeaponId weaponId;
    WeaponId weaponId2;
    ShieldId shieldId;
    ArmorId armorId;
    List<Object> modifiers;
    HeroAttributesMap heroAttributesMap;

}
