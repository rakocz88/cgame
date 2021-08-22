package com.pilaf.cgame.api.actions.model;

import com.pilaf.cgame.shared.interfaces.Action;
import com.pilaf.cgame.shared.valueobject.ActionId;
import lombok.Value;

@Value
public class HeroAction implements Action {

    ActionId actionId;

}
