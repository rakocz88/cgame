package com.pilaf.cgame.actions.actiontypes;

import com.pilaf.cgame.api.actions.model.EffectApply;
import com.pilaf.cgame.api.actions.model.EffectResult;
import com.pilaf.cgame.api.combat.model.HeroInCombat;
import com.pilaf.cgame.api.diceroll.DiceRollAPI;
import com.pilaf.cgame.api.diceroll.model.RollDiceResult;
import com.pilaf.cgame.api.equipment.EquipmentAPI;
import com.pilaf.cgame.api.equipment.model.Armor;
import com.pilaf.cgame.api.equipment.model.Shield;
import com.pilaf.cgame.api.equipment.model.Weapon;
import com.pilaf.cgame.shared.constants.ActionNames;
import com.pilaf.cgame.shared.interfaces.Action;
import com.pilaf.cgame.shared.interfaces.Effect;
import com.pilaf.cgame.shared.interfaces.Item;
import com.pilaf.cgame.shared.valueobject.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Qualifier(ActionNames.ATTACK)
public class Attack implements Action {

    public static final ActionId ACTION_ID = new ActionId(UUID.randomUUID());
    private static final int TO_HIT_TARGET = 6;
    private final EquipmentAPI equipmentAPI;
    private final DiceRollAPI diceRollAPI;

    @Override
    public ActionId getActionId() {
        return ACTION_ID;
    }

    @Override
    public int getActionPointsCost(Hero caster) {
        HeroInCombat heroInCombat = (HeroInCombat) caster;
        Item weapon1 = equipmentAPI.getWeapon(heroInCombat.getWeaponId());
        Item weapon2 = equipmentAPI.getWeapon(heroInCombat.getWeaponId2());
        Item armor = equipmentAPI.getArmor(heroInCombat.getArmorId());
        Item shield = equipmentAPI.getShield(heroInCombat.getShieldId());
        return Stream.of(weapon1, weapon2, armor, shield)
                .filter(Objects::nonNull)
                .map(Item::getSpeedPenalty)
                .reduce(Integer::sum).get();

    }

    @Override
    public Effect invoke(Hero caster, List<Hero> targets) {
        List<EffectApply.HeroEffectApply> heroEffectApplyList = new ArrayList<>();
        EffectApply.HeroEffectApply actionPointsEffectApply =
                EffectApply.HeroEffectApply.of(EffectResult.ACTION_POINTS_DECREASE, getActionPointsCost(caster), null);
        heroEffectApplyList.add(actionPointsEffectApply);
        HeroInCombat casterInCombat = (HeroInCombat) caster;
        var weapon1 = equipmentAPI.getWeapon(casterInCombat.getWeaponId());
        var weapon2 = equipmentAPI.getWeapon(casterInCombat.getWeaponId2());
        var heroDices = calculateHeroDices(casterInCombat, weapon1, weapon2);
        var weaponDices = calculateWeaponDices(casterInCombat, weapon1, weapon2);
        for (Hero target : targets) {
            HeroInCombat targetInCombat = (HeroInCombat) target;
            Armor armor = equipmentAPI.getArmor(targetInCombat.getArmorId());
            Shield shield = equipmentAPI.getShield(targetInCombat.getShieldId());
            var dodgeDices = calculateDodgeDices(targetInCombat, armor, shield);
            var armorDices = calculateArmorRolls(targetInCombat, armor, shield);
            var allDices = new ArrayList<Dice>();
            allDices.addAll(heroDices);
            allDices.addAll(weaponDices);
            allDices.addAll(dodgeDices);
            allDices.addAll(armorDices);
            var diceResult = diceRollAPI.rollDices(allDices);
            var attackModifier = 0;
            var dodgeModifier = 0;
            var dmgModifier = 0;
            var armorModifier = 0;
            var singleEffect = resultToEffect(diceResult, attackModifier, dodgeModifier, dmgModifier, armorModifier);
            heroEffectApplyList.add(singleEffect);
        }
        return EffectApply.of(
                new EffectId(UUID.randomUUID()),
                heroEffectApplyList
        );
    }

    private EffectApply.HeroEffectApply resultToEffect(RollDiceResult diceResult, int attackModifier, int dodgeModifier, int dmgModifier, int armorModifier) {
        var hitResult = diceResult.getHitResult() + attackModifier;
        if (hitResult < TO_HIT_TARGET + dodgeModifier){
            return EffectApply.HeroEffectApply.of(EffectResult.MISSED_ATTACK, 0, null);
        } else {
            var dmgResult = diceResult.getDmgResult() + dmgModifier;
            var armorResult = diceResult.getArmorResult() + armorModifier;
            var dmgDealt = Math.max(dmgResult - armorResult, 0);
            return EffectApply.HeroEffectApply.of(EffectResult.DMG, dmgDealt, null);
        }
    }

    private List<Dice> calculateDodgeDices(HeroInCombat targetInCombat, Armor armor, Shield shield) {
        var dices = calculateDodgeRolls(targetInCombat, armor, shield);
        return IntStream.range(0, dices)
                .mapToObj(value -> Dice.of(
                        DiceType.BRONZE, calculateDodgeLevel(targetInCombat, armor, shield))
                ).collect(Collectors.toList());
    }

    private List<Dice> calculateArmorRolls(HeroInCombat targetInCombat, Armor armor, Shield shield) {
        return armor.getArmorDice().get(DmgType.WEAPON);
    }

    private DiceLvl calculateDodgeLevel(HeroInCombat targetInCombat, Armor armor, Shield shield) {
        return DiceLvl.COMMON;
    }

    private int calculateDodgeRolls(HeroInCombat target, Armor armor, Shield shield) {
        int dexterity =
                target.getHeroAttributesMap().getAttributeValue(HeroAttributeType.DEXTERIXY) - armor.getDexterityPenalty() - shield.getDexterityPenalty();
        if (dexterity < 0) {
            return 0;
        } else {
            return dexterity;
        }
    }

    private List<Dice> calculateWeaponDices(HeroInCombat casterInCombat, Weapon weapon1, Weapon weapon2) {
        if (weapon2 == null) {
            return weapon1.getDices();
        } else {
            List<Dice> twoWeaponDices = weapon1.getDices();
            twoWeaponDices.addAll(weapon2.getDices());
            return twoWeaponDices;
        }
    }

    private List<Dice> calculateHeroDices(HeroInCombat casterInCombat, Weapon weapon1, Weapon weapon2) {
        var diceAmount = switch (weapon1.getUsedAttribute()) {
            case STRENTH -> casterInCombat.getHeroAttributesMap().getAttributeValue(HeroAttributeType.STRENTH);
            case DEXTERIXY -> casterInCombat.getHeroAttributesMap().getAttributeValue(HeroAttributeType.DEXTERIXY);
            case CONSTITUTION -> null;
            case FLAIR -> casterInCombat.getHeroAttributesMap().getAttributeValue(HeroAttributeType.FLAIR);
            case KNOWLEDGE -> casterInCombat.getHeroAttributesMap().getAttributeValue(HeroAttributeType.KNOWLEDGE);
            case OBSERVATION -> casterInCombat.getHeroAttributesMap().getAttributeValue(HeroAttributeType.OBSERVATION);
            case PERSONALITY -> casterInCombat.getHeroAttributesMap().getAttributeValue(HeroAttributeType.PERSONALITY);
        };

        var diceType = switch (weapon1.getUsedAttribute()) {
            case STRENTH -> DiceType.RED;
            case DEXTERIXY -> DiceType.GREEN;
            case CONSTITUTION, OBSERVATION -> null;
            case FLAIR, KNOWLEDGE, PERSONALITY -> DiceType.BLUE;
        };
        var diceLvl = calculateAttackDiceLvl();
        return IntStream.range(0, diceAmount).mapToObj(operand -> Dice.of(diceType, diceLvl)).collect(Collectors.toList());
    }

    private DiceLvl calculateAttackDiceLvl() {
        return DiceLvl.COMMON;
    }
}
