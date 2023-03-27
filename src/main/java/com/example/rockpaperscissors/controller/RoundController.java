package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Game;
import com.example.rockpaperscissors.model.Round;
import com.example.rockpaperscissors.model.Statistic;
import com.example.rockpaperscissors.service.RoundService;
import com.example.rockpaperscissors.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RoundController {

    private final RoundService roundService;
    private final StatisticService statisticService;

    private final AtomicLong nextGameId = new AtomicLong(1);
    private final Map<Long, Game> gamesMap = new ConcurrentHashMap<>();

    public RoundController(RoundService roundService, StatisticService statisticService) {
        this.roundService = roundService;
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/restart")
    @Operation(summary = "Restart game",
            description = "In this case, a new game is being created. The number of rounds in the new game is zero.")
    public Game newGame() {
        final Game game = new Game(nextGameId.getAndIncrement(), new ArrayList<>());
        gamesMap.put(game.getGameId(), game);
        return game;
    }

    @GetMapping(value = "/play/{gameId}")
    @Operation(summary = "Create new round",
            description = "As a result of creating a new round, we get an Game object that contains the game ID and " +
                    "the list of previous rounds and the current round.")
    public Game playRound(@Parameter(description = "game id") @PathVariable Long gameId) {
        final Game game = gamesMap.get(gameId);
        final Round newRound = roundService.playRound();
        game.addRound(newRound);
        statisticService.addStatistic(newRound.getGameResult());
        return game;
    }

    @GetMapping(value = "/statistic")
    @Operation(summary = "Generating game statistics",
            description = "Generating game statistics based on the results of all games. The statistics object contains " +
                    "the following fields: the total number of rounds, the number of wins of the first player, the " +
                    "number of wins of the second player, the number of games drawn.")
    public Statistic getStatistic() {
        return statisticService.getStatistic();
    }

}
