package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Choice;
import com.example.rockpaperscissors.model.Game;
import com.example.rockpaperscissors.service.ChoiceService;
import com.example.rockpaperscissors.service.RoundService;
import com.example.rockpaperscissors.service.StatisticService;
import com.example.rockpaperscissors.service.impl.ChoiceServiceRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RoundController.class)
@AutoConfigureMockMvc
class RoundControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoundService roundService;

    @MockBean
    private StatisticService statisticService;

    private final static long GAME_ID = 1L;

    @Test
    void testGetGameNumber() throws Exception {
        mockMvc.perform(get("/restart")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.gameId").value(1))
                .andExpect(jsonPath("$.rounds").isArray())
                .andExpect(jsonPath("$.rounds").isEmpty());
    }

}