package com.pilaf.cgame.equipment;

import com.pilaf.cgame.api.equipment.EquipmentAPI;
import com.pilaf.cgame.api.equipment.model.Armor;
import com.pilaf.cgame.api.equipment.model.Shield;
import com.pilaf.cgame.api.equipment.model.Weapon;
import com.pilaf.cgame.shared.valueobject.ArmorId;
import com.pilaf.cgame.shared.valueobject.ShieldId;
import com.pilaf.cgame.shared.valueobject.WeaponId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentService implements EquipmentAPI {

    private final EquipmentRepository equipmentRepository;


    @Override
    public Weapon getWeapon(WeaponId weaponId) {
        return equipmentRepository.findWeapon(weaponId);
    }

    @Override
    public Armor getArmor(ArmorId armorId) {
        return equipmentRepository.findArmor(armorId);
    }

    @Override
    public Shield getShield(ShieldId shieldId) {
        return equipmentRepository.findShield(shieldId);
    }
}
