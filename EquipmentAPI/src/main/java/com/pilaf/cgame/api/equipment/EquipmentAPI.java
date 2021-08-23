package com.pilaf.cgame.api.equipment;

import com.pilaf.cgame.api.equipment.model.Armor;
import com.pilaf.cgame.api.equipment.model.Shield;
import com.pilaf.cgame.api.equipment.model.Weapon;
import com.pilaf.cgame.shared.valueobject.ArmorId;
import com.pilaf.cgame.shared.valueobject.ShieldId;
import com.pilaf.cgame.shared.valueobject.WeaponId;

public interface EquipmentAPI {

    Weapon getWeapon(WeaponId weaponId);
    Armor getArmor(ArmorId armorId);
    Shield getShield(ShieldId shieldId);


}
