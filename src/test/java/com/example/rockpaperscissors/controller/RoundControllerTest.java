package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.*;
import com.example.rockpaperscissors.service.RoundService;
import com.example.rockpaperscissors.service.StatisticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoundControllerTest {

    @Mock
    private RoundService roundService;

    @Mock
    private StatisticService statisticService;

    @InjectMocks
    private RoundController roundController;

    @Test
    void testNewGame_SameGame() {
        //When
        Game game = roundController.newGame();
        //Then
        Assertions.assertEquals(new Game(1L, Collections.emptyList()), game);
    }

    @Test
    void testNewGame_DifferentGames() {
        //When
        Game gameFirst = roundController.newGame();
        Game gameSecond = roundController.newGame();
        //Then
        Assertions.assertEquals(new Game(1L, Collections.emptyList()), gameFirst);
        Assertions.assertEquals(new Game(2L, Collections.emptyList()), gameSecond);
    }

    @Test
    void testPlayRound_GetGame(){
        //When
        when(roundService.playRound()).thenReturn(new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN));
        Game game = roundController.newGame();
        Game actual = roundController.playRound(game.getGameId());
        //Then
        Assertions.assertEquals(List.of(new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN)), actual.getRounds());
        Assertions.assertEquals(game.getGameId(), actual.getGameId());
    }

    @Test
    void testGetStatistic(){
        //Given
        Statistic statistic = new Statistic(1L, 1L, 0L, 0L);
        //When
        Game game = roundController.newGame();
        when(roundService.playRound()).thenReturn(new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN));
        when(statisticService.getStatistic()).thenReturn(new Statistic(1L, 1L, 0L, 0L));
        Game playedGame = roundController.playRound(game.getGameId());
        Statistic actual = roundController.getStatistic();
        //Then
        Assertions.assertEquals(statistic, actual);
    }

}