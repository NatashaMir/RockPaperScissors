package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Game;
import com.example.rockpaperscissors.model.Round;
import com.example.rockpaperscissors.model.Statistic;
import com.example.rockpaperscissors.service.RoundService;
import com.example.rockpaperscissors.service.StatisticService;
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
    public Game newGame() {
        final Game game = new Game(nextGameId.getAndIncrement(), new ArrayList<>());
        gamesMap.put(game.getGameId(), game);
        return game;
    }

    @GetMapping(value = "/play/{gameId}")
    public Game playRound(@PathVariable Long gameId) {
        final Game game = gamesMap.get(gameId);
        final Round newRound = roundService.playRound();
        game.addRound(newRound);
        statisticService.addStatistic(newRound.getGameResult());
        return game;
    }

    @GetMapping(value = "/statistic")
    public Statistic getStatistic() {
        return statisticService.getStatistic();
    }

}
