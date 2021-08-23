package com.pilaf.cgame.shared.interfaces;

import com.pilaf.cgame.shared.valueobject.ActionId;
import com.pilaf.cgame.shared.valueobject.Hero;
import com.pilaf.cgame.shared.valueobject.HeroId;
import com.pilaf.cgame.shared.valueobject.WeaponId;

import java.util.List;

public interface Action {

    ActionId getActionId();
    int getActionPointsCost(Hero caster);
    Effect invoke(Hero caster, List<Hero> targets);

}
