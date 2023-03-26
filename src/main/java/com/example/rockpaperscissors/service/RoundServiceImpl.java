package com.example.rockpaperscissors.service;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Round;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService{

    @Override
    public Round playRound() {
        Choice firstPlayer = Choice.ROCK;
        Choice secondPlayer = Choice.PAPER;
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
