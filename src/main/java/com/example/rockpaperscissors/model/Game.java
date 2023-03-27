package com.example.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private Long gameId;
    private List<Round> rounds;

    public synchronized List<Round> getRounds(){
        return List.copyOf(rounds);
    }

    public synchronized void addRound(Round newRound){
        rounds.add(newRound);
    }
}
