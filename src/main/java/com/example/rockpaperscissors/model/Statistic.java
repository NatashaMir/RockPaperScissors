package com.example.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    private Long totalRound;
    private Long firstPlayerWinsCount;
    private Long secondPlayerWinsCount;
    private Long drawCount;

}
