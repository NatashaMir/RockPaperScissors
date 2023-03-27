package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Round;
import com.example.rockpaperscissors.service.RoundService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoundServiceImplTest {

    @Mock
    ChoiceServiceRandom firstPlayerChoice;

    @Mock
    ChoiceServiceRandom secondPlayerChoice;

    RoundService roundService;

    @BeforeEach
    public void init() {
        roundService =  new RoundServiceImpl(firstPlayerChoice, secondPlayerChoice);
    }
    
    @Test
    void playRoundWithTwoEqualsChoice_GetDraw(){
        //Given
        Round round =  new Round(Choice.ROCK, Choice.ROCK, Result.DRAW);
        //When
        when(firstPlayerChoice.getChoice()).thenReturn(Choice.ROCK);
        when(secondPlayerChoice.getChoice()).thenReturn(Choice.ROCK);
        Round actual = roundService.playRound();
        //Then
        Assertions.assertEquals(round, actual);
    }

    @Test
    void playRoundWithTwoEqualsChoice_FirstPlayerWin(){
        //Given
        Round round =  new Round(Choice.ROCK, Choice.SCISSORS, Result.FIRST_PLAYER_WIN);
        //When
        when(firstPlayerChoice.getChoice()).thenReturn(Choice.ROCK);
        when(secondPlayerChoice.getChoice()).thenReturn(Choice.SCISSORS);
        Round actual = roundService.playRound();
        //Then
        Assertions.assertEquals(round, actual);
    }

    @Test
    void playRoundWithTwoEqualsChoice_SecondPlayerWin(){
        //Given
        Round round =  new Round(Choice.ROCK, Choice.PAPER, Result.SECOND_PLAYER_WIN);
        //When
        when(firstPlayerChoice.getChoice()).thenReturn(Choice.ROCK);
        when(secondPlayerChoice.getChoice()).thenReturn(Choice.PAPER);
        Round actual = roundService.playRound();
        //Then
        Assertions.assertEquals(round, actual);
    }

}