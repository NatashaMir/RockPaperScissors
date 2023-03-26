package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Statistic;
import com.example.rockpaperscissors.service.StatisticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatisticServiceImpTest {

    @Test
    void getStatistic() {
        Statistic statistic = new Statistic(1L, 0L, 1L, 0L);
        StatisticService statisticService =  new StatisticServiceImp();
        Result result = Result.SECOND_PLAYER_WIN;
        statisticService.addStatistic(result);
        final Statistic actual = statisticService.getStatistic();
        Assertions.assertEquals(actual, statistic);
    }
}