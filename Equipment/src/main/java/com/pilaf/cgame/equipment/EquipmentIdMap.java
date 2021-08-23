package com.pilaf.cgame.equipment;

import com.pilaf.cgame.api.equipment.model.Shield;
import com.pilaf.cgame.shared.valueobject.ArmorId;
import com.pilaf.cgame.shared.valueobject.ShieldId;
import com.pilaf.cgame.shared.valueobject.WeaponId;

import java.util.UUID;

public class EquipmentIdMap {
    public static final WeaponId LONG_SWORD = new WeaponId(UUID.randomUUID());
    public static final WeaponId GREAT_SWORD = new WeaponId(UUID.randomUUID());
    public static final WeaponId GREAT_AXE = new WeaponId(UUID.randomUUID());
    public static final WeaponId DAGGER = new WeaponId(UUID.randomUUID());
    public static final ArmorId TRAVELER_ROBE = new ArmorId(UUID.randomUUID());
    public static final ArmorId LEATHER_ARMOR = new ArmorId(UUID.randomUUID());
    public static final ArmorId MAIL_ARMOR = new ArmorId(UUID.randomUUID());
    public static final ArmorId PLATE_ARMOR = new ArmorId(UUID.randomUUID());
    public static final ShieldId LIGHT_SHIELD = new ShieldId(UUID.randomUUID());
    public static final ShieldId TOWER_SHIELD = new ShieldId(UUID.randomUUID());
}
