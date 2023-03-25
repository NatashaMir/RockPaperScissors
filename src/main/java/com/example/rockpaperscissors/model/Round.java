package com.example.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Round {

    private Choice firstPlayer;

    private Choice secondPlayer;

    private Result gameResult;

}
