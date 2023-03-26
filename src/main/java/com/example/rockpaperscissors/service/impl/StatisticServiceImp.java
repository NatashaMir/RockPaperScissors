package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Statistic;
import com.example.rockpaperscissors.service.StatisticService;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImp implements StatisticService {

    private long firstPlayerWinsCount = 0L;
    private long secondPlayerWinsCount = 0L;
    private long drawCount = 0L;
    private long totalRound = 0L;

    @Override
    public synchronized void addStatistic(Result result) {
        totalRound++;
        if (result == Result.FIRST_PLAYER_WIN){
            firstPlayerWinsCount++;
        } else if (result == Result.SECOND_PLAYER_WIN){
            secondPlayerWinsCount++;
        } else if (result == Result.DRAW){
            drawCount++;
        } else {
            throw new IllegalArgumentException("Invalid result type: " + result);
        }
    }

    @Override
    public synchronized Statistic getStatistic() {
        return new Statistic(totalRound, firstPlayerWinsCount, secondPlayerWinsCount, drawCount);
    }

}
