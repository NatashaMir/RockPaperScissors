package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.model.Game;
import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Round;
import com.example.rockpaperscissors.service.RoundService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoundControllerTest {

    @Mock
    private RoundService roundService;

    @Test
    void testNewGame_SameGame() {
        final Game game = new RoundController(roundService).newGame();
        Assertions.assertEquals(new Game(1L, Collections.emptyList()), game);
    }

    @Test
    void testNewGame_DifferentGames() {
        final RoundController roundController = new RoundController(roundService);
        final Game gameFirst = roundController.newGame();
        final Game gameSecond = roundController.newGame();
        Assertions.assertEquals(new Game(1L, Collections.emptyList()), gameFirst);
        Assertions.assertEquals(new Game(2L, Collections.emptyList()), gameSecond);
    }

    @Test
    void testPlayRound_FindGame() {
        final RoundController roundController = new RoundController(roundService);
        Game game = roundController.newGame();
        Game actual = roundController.playRound(game.getGameId());
        Assertions.assertEquals(game, actual);
    }

    @Test
    void testPlayRound_GetGame(){
        when(roundService.playRound()).thenReturn(new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN));
        RoundController roundController = new RoundController(roundService);
        Game game = roundController.newGame();
        Game actual = roundController.playRound(game.getGameId());
        Assertions.assertEquals(List.of(new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN)), actual.getRounds());
    }

}