package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.service.ChoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceServiceRockTest {

    @Test
    void getChoice() {
        ChoiceService choiceService = new ChoiceServiceRock();
        int rockCount = 0;
        for (int i = 0; i < 10000; i++) {
            final Choice choice = choiceService.getChoice();
            if (choice == Choice.ROCK) {
                rockCount++;
            }
        }
        Assertions.assertEquals(10000, rockCount);
    }
}