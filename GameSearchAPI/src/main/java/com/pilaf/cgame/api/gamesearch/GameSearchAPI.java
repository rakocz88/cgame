package com.pilaf.cgame.api.gamesearch;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GameSearchAPI {
    Mono<UUID> gameSearch(UUID userId);

    Flux<UUID> gameSearchMulti(UUID userId);
}
