package com.example.rockpaperscissors.service;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Round;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RoundServiceImplTest {

    @Test
    void playRoundWithTwoEqualsChoice_GetDraw(){
        final RoundService roundService = new RoundServiceImpl();
        Round round =  new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN);
        Round actual = roundService.playRound();
        Assertions.assertEquals(round, actual);
    }

}