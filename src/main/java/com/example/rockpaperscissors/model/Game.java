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

}
