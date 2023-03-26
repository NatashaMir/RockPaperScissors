package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.service.ChoiceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Qualifier("choiceServiceRandom")
public class ChoiceServiceRandom implements ChoiceService {
    private static final List<Choice> allValues = List.of(Choice.values());
    private static final Random random = new Random();
    @Override
    public Choice getChoice() {
        return allValues.get(random.nextInt(allValues.size()));
    }
}
