package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Statistic;
import com.example.rockpaperscissors.service.StatisticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StatisticServiceImpTest {

    StatisticService statisticService;

    @BeforeEach
    public void init() {
        statisticService =  new StatisticServiceImp();
    }

    @Test
    void testGetStatistic() {
        //Given
        Statistic statistic = new Statistic(1L, 0L, 1L, 0L);
        Result result = Result.SECOND_PLAYER_WIN;
        //When
        statisticService.addStatistic(result);
        final Statistic actual = statisticService.getStatistic();
        //Then
        Assertions.assertEquals(statistic, actual);
    }

    @Test
    void testGetStatistic_Run10Times_CountTotalRounds() {
        //Given
        for (int i = 0; i < 10; i++) {
            final Result result = randomGenerator();
            statisticService.addStatistic(result);
        }
        //When
        final Statistic actual = statisticService.getStatistic();
        long countTotal = actual.getTotalRound();
        //Then
        Assertions.assertEquals(10L, countTotal);
    }

    @Test
    void testAddStatistic_WhenUnexpectedResultValue_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> statisticService.addStatistic(null));
    }

    private static Result randomGenerator() {
        final List<Result> values = List.of(Result.values());
        return values.get(new Random().nextInt(values.size()));
    }
}