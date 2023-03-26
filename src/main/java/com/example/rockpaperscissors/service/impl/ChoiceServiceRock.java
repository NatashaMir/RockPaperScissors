package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.service.ChoiceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("choiceServiceRock")
public class ChoiceServiceRock implements ChoiceService {

    @Override
    public Choice getChoice() {
        return Choice.ROCK;
    }
}
