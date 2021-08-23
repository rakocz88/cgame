package com.pilaf.cgame.api.combat;

import com.pilaf.cgame.api.combat.model.HeroInCombat;
import com.pilaf.cgame.shared.valueobject.BoardId;
import com.pilaf.cgame.shared.valueobject.GameId;
import com.pilaf.cgame.shared.valueobject.HeroId;

public interface CombatAPI {
    GameId startCombat(HeroId heroId1, HeroId heroId2, BoardId boardId);
    HeroInCombat getHeroInCombat(HeroId heroId);
}
