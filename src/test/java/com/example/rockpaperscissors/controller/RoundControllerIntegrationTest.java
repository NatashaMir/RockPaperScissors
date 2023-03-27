package com.example.rockpaperscissors.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RoundController.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.example.rockpaperscissors"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RoundControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    RoundController roundController;

    private final static long GAME_ID = 1L;
    private final static int ROUND_AMOUNT = 10;

    @Test
    void testGetGameNumber() throws Exception {
        mockMvc.perform(get("/restart")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.gameId").value(1))
                .andExpect(jsonPath("$.rounds").isArray())
                .andExpect(jsonPath("$.rounds").isEmpty())
                .andReturn();
    }

    @Test
    void testPlayRound_CheckResultGame() throws Exception {
        roundController.newGame();
        mockMvc.perform(get("/play/" + GAME_ID)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.gameId").value(1))
                .andExpect(jsonPath("$.rounds").isArray())
                .andExpect(jsonPath("$.rounds[0].firstPlayer").value("ROCK"))
                .andReturn();
    }

    @Test
    void testGetStatistic_CheckRoundsAmount() throws Exception {
        roundController.newGame();
        for(int i=0; i<ROUND_AMOUNT; i++) {
            roundController.playRound(GAME_ID);
        }
        mockMvc.perform(get("/statistic")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.totalRound").value(ROUND_AMOUNT))
                .andReturn();
    }

}