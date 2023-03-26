package com.example.rockpaperscissors.service.impl;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Round;
import com.example.rockpaperscissors.service.ChoiceService;
import com.example.rockpaperscissors.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

    private final ChoiceService firstPlayerChoice;

    private final ChoiceService secondPlayerChoice;

    @Autowired
    public RoundServiceImpl(@Qualifier("choiceServiceRock") ChoiceService firstPlayerChoice,
                            @Qualifier("choiceServiceRandom") ChoiceService secondPlayerChoice) {
        this.firstPlayerChoice = firstPlayerChoice;
        this.secondPlayerChoice = secondPlayerChoice;
    }

    @Override
    public Round playRound() {
        Choice firstPlayer = firstPlayerChoice.getChoice();
        Choice secondPlayer = secondPlayerChoice.getChoice();
        Result result = getResult(firstPlayer, secondPlayer);
        return new Round(firstPlayer, secondPlayer, result);
    }

    private Result getResult(Choice firstPlayer, Choice secondPlayer) {
        if (firstPlayer == secondPlayer) {
            return Result.DRAW;
        } else if (firstPlayer == Choice.ROCK && secondPlayer == Choice.SCISSORS ||
        firstPlayer == Choice.SCISSORS && secondPlayer == Choice.PAPER ||
        firstPlayer == Choice.PAPER && secondPlayer == Choice.ROCK){
            return Result.FIRST_PLAYER_WIN;
        } else {
            return Result.SECOND_PLAYER_WIN;
        }
    }
}
