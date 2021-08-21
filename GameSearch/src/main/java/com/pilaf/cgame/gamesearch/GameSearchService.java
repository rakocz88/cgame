package com.pilaf.cgame.gamesearch;

import com.pilaf.cgame.api.gamesearch.GameSearchAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GameSearchService implements GameSearchAPI {
    @Override
    public Mono<UUID> gameSearch(UUID userId) {
        return Mono.just(UUID.randomUUID());
    }

    @Override
    public Flux<UUID> gameSearchMulti(UUID userId) {
        return Flux.from(s -> UUID.randomUUID());
    }
}
