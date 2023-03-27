package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.service.ChoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChoiceServiceRandomTest {

    private final ChoiceService choiceService = new ChoiceServiceRandom();
    private final List<Choice> choiceList = Arrays.asList(Choice.values());

    @Test
    void testGetChoice_RandomResult() {
        //When
        final Choice choice = choiceService.getChoice();
        //Then
        Assertions.assertTrue(choiceList.contains(choice));
    }

    @Test
    void testGetChoice_RandomResultStatistic() {
        //Given
        int rockCount = 0, scissorsCount = 0, paperCount = 0, countOther = 0;
        //When
        for (int i = 0; i < 10000; i++){
            final Choice choice = choiceService.getChoice();
            if (choice == Choice.ROCK){
                rockCount++;
            } else if (choice == Choice.PAPER){
                paperCount++;
            } else if (choice == Choice.SCISSORS){
                scissorsCount++;
            } else {
                countOther++;
            }
        }
        //Then
        Assertions.assertTrue(rockCount > 0 && paperCount > 0 && scissorsCount > 0);
        assertEquals(0, countOther);
        Assertions.assertTrue(Math.abs(rockCount - paperCount) < 500 && Math.abs(rockCount - scissorsCount) < 500);
    }

}