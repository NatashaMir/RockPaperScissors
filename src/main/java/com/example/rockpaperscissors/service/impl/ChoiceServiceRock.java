package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.service.ChoiceService;
import org.springframework.stereotype.Service;

@Service
public class ChoiceServiceRock implements ChoiceService {
    @Override
    public Choice getChoice() {
        return Choice.ROCK;
    }
}
