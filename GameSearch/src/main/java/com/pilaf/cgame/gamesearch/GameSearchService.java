package com.pilaf.cgame.gamesearch;

import com.pilaf.cgame.api.gamesearch.GameSearchAPI;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class GameSearchService implements GameSearchAPI {
    @Override
    public Mono<UUID> gameSearch(UUID userId) {
        return Mono.just(UUID.randomUUID());
    }
}
