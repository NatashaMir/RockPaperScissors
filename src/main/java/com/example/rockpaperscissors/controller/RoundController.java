package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class RoundController {

    private final AtomicLong nextGameId = new AtomicLong(1);
    private final Map<Long,Game> gamesMap = new HashMap<>();

    @GetMapping("/restart")
    public Game newGame() {
        final Game game = new Game(nextGameId.getAndIncrement(), Collections.emptyList());
        gamesMap.put(game.getGameId(), game);
        return game;
    }


}
