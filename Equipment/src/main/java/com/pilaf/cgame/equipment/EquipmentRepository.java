package com.pilaf.cgame.equipment;

import com.pilaf.cgame.api.equipment.model.Armor;
import com.pilaf.cgame.api.equipment.model.Shield;
import com.pilaf.cgame.api.equipment.model.Weapon;
import com.pilaf.cgame.shared.valueobject.ArmorId;
import com.pilaf.cgame.shared.valueobject.ShieldId;
import com.pilaf.cgame.shared.valueobject.WeaponId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EquipmentRepository {

    private Map<WeaponId, Weapon> weaponMap = new HashMap<>();
    private Map<ArmorId, Armor> armorMap = new HashMap<>();
    private Map<ShieldId, Shield> shieldMap = new HashMap<>();

    public void saveWeapon(Weapon weapon){
         weaponMap.put(weapon.getWeaponId(), weapon);
    }

    public Weapon findWeapon(WeaponId weaponId){
        return weaponMap.get(weaponId);
    }

    public void saveArmor(Armor armor){
        armorMap.put(armor.getArmorId(), armor);
    }

    public Armor findArmor(ArmorId armorId){
        return armorMap.get(armorId);
    }

    public void saveShield(Shield shield){
         shieldMap.put(shield.getShieldId(), shield);
    }

    public Shield findShield(ShieldId shieldId){
        return shieldMap.get(shieldId);
    }

}
