package com.pilaf.cgame.equipment;

import com.pilaf.cgame.api.equipment.model.Armor;
import com.pilaf.cgame.api.equipment.model.Shield;
import com.pilaf.cgame.api.equipment.model.Weapon;
import com.pilaf.cgame.api.equipment.model.WeaponType;
import com.pilaf.cgame.shared.valueobject.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EquipmentInitializer {

    private final EquipmentRepository equipmentRepository;

    @EventListener(classes = {ContextStartedEvent.class})
    public void handleMultipleEvents() {
        createWeapons();
        createArmors();
        createShields();

    }

    private void createShields() {
        Shield lightShield = Shield.of(
                EquipmentIdMap.LIGHT_SHIELD,
                "light shield",
                Map.of(
                        DmgType.WEAPON, 2,
                        DmgType.ELEMENT, 2
                ),
                0,
                0,
                0,
                0,
                0,
                4
        );

        Shield towerShield = Shield.of(
                EquipmentIdMap.TOWER_SHIELD,
                "Tower shield",
                Map.of(
                       DmgType.WEAPON, 7,
                       DmgType.ELEMENT, 7
                ),
                0,
                10,
                1,
                2,
                2,
                12
        );

        equipmentRepository.saveShield(lightShield);
        equipmentRepository.saveShield(towerShield);
    }

    private void createArmors() {
        Armor robe = Armor.of(
                EquipmentIdMap.TRAVELER_ROBE,
                "Travelers robe",
                Map.of(
                        DmgType.ELEMENT,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON),
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                                )
                ),
                0,
                0,
                -1,
                0,
                0,
                0
        );

        Armor leatherArmor = Armor.of(
                EquipmentIdMap.LEATHER_ARMOR,
                "Leather armor",
                Map.of(
                        DmgType.ELEMENT,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                        ),
                        DmgType.WEAPON,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                                )
                ),
                0,
                0,
                6,
                0,
                0,
                2
        );

        Armor mailArmor = Armor.of(
                EquipmentIdMap.MAIL_ARMOR,
                "Mail armor",
                Map.of(
                        DmgType.ELEMENT,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                                )
                        ,
                        DmgType.WEAPON,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON),
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                                )
                ),
                0,
                2,
                4,
                0,
                0,
                4
        );

        Armor plateArmor = Armor.of(
                EquipmentIdMap.PLATE_ARMOR,
                "Mail armor",
                Map.of(
                        DmgType.ELEMENT,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                                )
                        ,
                        DmgType.WEAPON,
                                List.of(
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON),
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON),
                                        Dice.of(DiceType.SILVER, DiceLvl.COMMON)
                                )
                ),
                0,
                5,
                2,
                1,
                1,
                6
        );

        equipmentRepository.saveArmor(robe);
        equipmentRepository.saveArmor(leatherArmor);
        equipmentRepository.saveArmor(mailArmor);
        equipmentRepository.saveArmor(plateArmor);
    }

    private void createWeapons() {
        Weapon longSword = Weapon.of(
                EquipmentIdMap.LONG_SWORD,
                "Long Sword",
                WeaponType.LONG_SWORDS,
                List.of(
                        Dice.of(DiceType.RED, DiceLvl.COMMON),
                        Dice.of(DiceType.GREEN, DiceLvl.COMMON)),
                DmgType.CUT,
                5,
                0,
                0,
                HeroAttributeType.STRENTH,
                Collections.EMPTY_LIST
        );

        Weapon greatSword = Weapon.of(
                EquipmentIdMap.GREAT_SWORD,
                "Great Sword",
                WeaponType.GREAT_SWORDS,
                List.of(
                        Dice.of(DiceType.RED, DiceLvl.COMMON),
                        Dice.of(DiceType.RED, DiceLvl.COMMON),
                        Dice.of(DiceType.GREEN, DiceLvl.COMMON)),
                DmgType.CUT,
                5,
                0,
                0,
                HeroAttributeType.STRENTH,
                Collections.EMPTY_LIST
        );

        Weapon greatAxe = Weapon.of(
                EquipmentIdMap.GREAT_AXE,
                "Great axe",
                WeaponType.GREAT_AXES,
                List.of(
                        Dice.of(DiceType.RED, DiceLvl.COMMON),
                        Dice.of(DiceType.RED, DiceLvl.COMMON),
                        Dice.of(DiceType.RED, DiceLvl.COMMON)),
                DmgType.CUT,
                6,
                0,
                0,
                HeroAttributeType.STRENTH,
                Collections.EMPTY_LIST
        );

        Weapon dagger = Weapon.of(
                EquipmentIdMap.DAGGER,
                "Dagger",
                WeaponType.DAGGERS,
                List.of(
                        Dice.of(DiceType.GREEN, DiceLvl.COMMON)),
                DmgType.PIERCING,
                5,
                0,
                0,
                HeroAttributeType.STRENTH,
                Collections.EMPTY_LIST
        );

        equipmentRepository.saveWeapon(longSword);
        equipmentRepository.saveWeapon(greatSword);
        equipmentRepository.saveWeapon(greatAxe);
        equipmentRepository.saveWeapon(dagger);
    }
}
