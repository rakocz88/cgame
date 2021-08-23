package com.pilaf.cgame.api.actions.model;

import com.pilaf.cgame.shared.interfaces.AdditionalEffectData;
import com.pilaf.cgame.shared.interfaces.Effect;
import com.pilaf.cgame.shared.valueobject.EffectId;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class EffectApply implements Effect {
    EffectId effectId;
    List<HeroEffectApply> heroEffectApplyList;

    @Value(staticConstructor = "of")
    public static class  HeroEffectApply {
       EffectResult effectResult;
       int value;
       List<AdditionalEffectData> effectAdditionalParameterInfo;
    }
}
