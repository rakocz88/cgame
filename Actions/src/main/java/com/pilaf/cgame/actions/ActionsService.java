package com.pilaf.cgame.actions;

import com.pilaf.cgame.api.actions.ActionsAPI;
import com.pilaf.cgame.api.actions.model.EffectApply;
import com.pilaf.cgame.shared.valueobject.ActionId;
import com.pilaf.cgame.shared.valueobject.HeroId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ActionsService implements ActionsAPI {

    private final ActionRepository actionRepository;


    @Override
    public EffectApply invokeAction(ActionId actionId, HeroId caster, List<HeroId> target) {
        actionRepository.getAction(actionId);
        return null;
    }
}
