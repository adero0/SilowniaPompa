package com.AbAmAk.Pompa.service;

public class LotteryServiceImpl {
    boolean hasWon;

    private void determineWinner(String name) {
        hasWon = name.equals("Poljanowicz");
    }
}
