package com.game.tictactoe;

public class GameOverException extends Exception {
    public String toString(){
        return ("Game is Already Over!");
    }
}
