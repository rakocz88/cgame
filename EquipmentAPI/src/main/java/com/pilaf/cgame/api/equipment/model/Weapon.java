package com.pilaf.cgame.api.equipment.model;

import com.pilaf.cgame.shared.interfaces.HandUsable;
import com.pilaf.cgame.shared.interfaces.Item;
import com.pilaf.cgame.shared.valueobject.Dice;
import com.pilaf.cgame.shared.valueobject.DmgType;
import com.pilaf.cgame.shared.valueobject.HeroAttributeType;
import com.pilaf.cgame.shared.valueobject.WeaponId;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class Weapon implements HandUsable, Item {
    WeaponId weaponId;
    String weaponName;
    WeaponType weaponType;
    List<Dice> dices;
    DmgType dmgType;
    int speedPenalty;
    int weight;
    int price;
    HeroAttributeType usedAttribute;
    List<Object> specialEffect;


}
