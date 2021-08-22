package com.pilaf.cgame.api.actions.model;

public enum EffectResult
{
    PARAMETER_INCREASE("Increase parameter"),
    PARAMETER_DECREASE("Increase parameter"),
    DMG("Increase parameter"),
    HEAL("Increase parameter"),
    SKILL_INCREASE("Increase parameter"),
    SKILL_DECREASE("Increase parameter"),
    SANE_DMG("Sane"),
    SANE_RESTORE("Sane"),
    FATIGUE_DMG("Fatigue"),
    FATIGUE_RESTORE("Fatigue"),
    DICE_LVL_INCREASE(""),
    DICE_LVL_DECREASE(""),
    DICE_AMOUNT_INCREASE(""),
    DICE_AMOUNT_DECREASE("");


    private String desc;

    EffectResult(String desc){
        this.desc = desc;
    }


}
