package com.example.rockpaperscissors.service;

import com.example.rockpaperscissors.model.Result;
import com.example.rockpaperscissors.model.Statistic;

public interface StatisticService {

    void addStatistic(Result result);

    Statistic getStatistic();

}
