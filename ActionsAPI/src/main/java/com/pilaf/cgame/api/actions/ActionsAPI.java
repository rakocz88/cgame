package com.pilaf.cgame.api.actions;

import com.pilaf.cgame.api.actions.model.EffectApply;
import com.pilaf.cgame.shared.interfaces.Effect;
import com.pilaf.cgame.shared.valueobject.ActionId;
import com.pilaf.cgame.shared.valueobject.HeroId;

import java.util.List;

public interface ActionsAPI {

    Effect invokeAction(ActionId actionId, HeroId caster, List<HeroId> target);
}
