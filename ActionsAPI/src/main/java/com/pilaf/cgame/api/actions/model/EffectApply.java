package com.pilaf.cgame.api.actions.model;

import com.pilaf.cgame.shared.interfaces.AdditionalEffectData;
import com.pilaf.cgame.shared.valueobject.EffectId;
import lombok.Value;

import java.util.List;

@Value
public class EffectApply {
    EffectId effectId;
    List<HeroEffectApply> heroEffectApplyList;

    @Value
    public static class HeroEffectApply {
       EffectResult effectResult;
       int value;
       List<AdditionalEffectData> effectAdditionalParameterInfo;
    }
}
