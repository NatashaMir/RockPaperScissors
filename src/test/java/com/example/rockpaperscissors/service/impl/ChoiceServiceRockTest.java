package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.service.ChoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChoiceServiceRockTest {

    @Test
    void getChoice() {
        //Given
        ChoiceService choiceService = new ChoiceServiceRock();
        int rockCount = 0;
        //When
        for (int i = 0; i < 10000; i++) {
            final Choice choice = choiceService.getChoice();
            if (choice == Choice.ROCK) {
                rockCount++;
            }
        }
        //Then
        Assertions.assertEquals(10000, rockCount);
    }
}