package com.pilaf.cgame.api.hero;

import com.pilaf.cgame.api.hero.model.Hero;
import com.pilaf.cgame.shared.valueobject.HeroId;
import reactor.core.publisher.Mono;

public interface HeroAPI {

    Mono<Hero> findHeroById(HeroId heroId);


}
