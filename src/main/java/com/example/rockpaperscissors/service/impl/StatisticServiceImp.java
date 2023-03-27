package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Statistic;
import com.example.rockpaperscissors.service.StatisticService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class StatisticServiceImp implements StatisticService {

    private final AtomicLong firstPlayerWinsCount = new AtomicLong(0);
    private final AtomicLong secondPlayerWinsCount = new AtomicLong(0);
    private final AtomicLong drawCount = new AtomicLong(0);

    @Override
    public void addStatistic(Result result) {
        if (result == Result.FIRST_PLAYER_WIN){
            firstPlayerWinsCount.getAndIncrement();
        } else if (result == Result.SECOND_PLAYER_WIN){
            secondPlayerWinsCount.getAndIncrement();
        } else if (result == Result.DRAW){
            drawCount.getAndIncrement();
        } else {
            throw new IllegalArgumentException("Invalid result type: " + result);
        }
    }

    @Override
    public Statistic getStatistic() {
        long draws = drawCount.get();
        long firstPlayerWins = firstPlayerWinsCount.get();
        long secondPlayerWins = secondPlayerWinsCount.get();
        long totalRound = draws + firstPlayerWins + secondPlayerWins;
        return new Statistic(totalRound, firstPlayerWins, secondPlayerWins, draws);
    }

}
