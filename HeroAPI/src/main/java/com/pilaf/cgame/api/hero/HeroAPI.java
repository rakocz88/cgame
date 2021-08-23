package com.pilaf.cgame.api.hero;

import com.pilaf.cgame.api.hero.model.Hero;
import com.pilaf.cgame.shared.valueobject.ActionId;
import com.pilaf.cgame.shared.valueobject.HeroId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HeroAPI {

    Mono<Hero> findHeroById(HeroId heroId);

    Flux<ActionId> getAvailableActions(HeroId heroId);


}
