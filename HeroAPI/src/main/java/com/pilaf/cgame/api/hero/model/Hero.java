package com.pilaf.cgame.api.hero.model;

import com.pilaf.cgame.shared.valueobject.HeroAttributesMap;
import com.pilaf.cgame.shared.valueobject.HeroId;
import lombok.Value;

@Value
public class Hero {
    HeroId heroId;
    HeroAttributesMap heroAttributesMap;

}
