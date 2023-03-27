package com.example.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Game {

    private final Long gameId;
    private final List<Round> rounds;

    public synchronized List<Round> getRounds(){
        return List.copyOf(rounds);
    }

    public synchronized void addRound(Round newRound){
        rounds.add(newRound);
    }
}
