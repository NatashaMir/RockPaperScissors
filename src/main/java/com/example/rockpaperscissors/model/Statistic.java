package com.example.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    private long totalRound;
    private long firstPlayerWinsCount;
    private long secondPlayerWinsCount;
    private long drawCount;

}
