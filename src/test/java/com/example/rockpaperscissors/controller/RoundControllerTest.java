package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RoundControllerTest {

    @Test
    void testNewGame_SameGame(){
        final Game game = new RoundController().newGame();
        Assertions.assertEquals(new Game(1L, Collections.emptyList()), game);
    }

    @Test
    void testNewGame_DifferentGames(){
        final RoundController roundController = new RoundController();
        final Game gameFirst = roundController.newGame();
        final Game gameSecond = roundController.newGame();
        Assertions.assertEquals(new Game(1L, Collections.emptyList()), gameFirst);
        Assertions.assertEquals(new Game(2L, Collections.emptyList()), gameSecond);
    }

}