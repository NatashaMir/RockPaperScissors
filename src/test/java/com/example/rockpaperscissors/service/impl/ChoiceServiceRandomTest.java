package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceServiceRandomTest {

    @Test
    void testGetChoice_RandomResultStatistic(){
        List<Choice> choiceList = Arrays.asList(Choice.ROCK, Choice.SCISSORS, Choice.PAPER);
        ChoiceServiceRandom choiceServiceRandom =  new ChoiceServiceRandom();
        final Choice choice = choiceServiceRandom.getChoice();
        Assertions.assertTrue(choiceList.contains(choice));
    }

}