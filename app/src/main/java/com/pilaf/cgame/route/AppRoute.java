package com.pilaf.cgame.route;

import com.pilaf.cgame.api.gamesearch.GameSearchAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class AppRoute {

    private final GameSearchAPI gameSearchAPI;

    @Bean
    RouterFunction<ServerResponse> route() {
        return RouterFunctions.route().GET(
                "/search-game/user/{userId}",
                request ->
                        ServerResponse.ok().body(gameSearchAPI.gameSearch(UUID.fromString(request.pathVariable("userId"))).subscribe(), Mono.class))
                .build();

    }
}
