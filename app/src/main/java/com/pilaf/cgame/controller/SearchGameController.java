package com.pilaf.cgame.controller;

import com.pilaf.cgame.api.gamesearch.GameSearchAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SearchGameController {

    private final GameSearchAPI gameSearchAPI;

    @GetMapping("/game-search/{userId}")
    public Mono<UUID> searchGame(@PathVariable("userId") UUID userId){
        return gameSearchAPI.gameSearch(userId);
    }

    @GetMapping("/game-search-multi/{userId}")
    public Mono<UUID> searchGameMulti(@PathVariable("userId") UUID userId){
        return gameSearchAPI.gameSearch(userId);
    }
}
