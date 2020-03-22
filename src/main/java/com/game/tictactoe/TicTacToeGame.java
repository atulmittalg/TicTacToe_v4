package com.game.tictactoe;

public class TicTacToeGame {
    private char[][] gameBoardLayout = new char[3][3];
    private char currentPlayerToBePlayed = 'X';

    public void playTurnAt(final int positionX, final int positionY) {
        gameBoardLayout[positionX][positionY] = currentPlayerToBePlayed;
        currentPlayerToBePlayed = 'O';
    }

    public char getPlayerAt(final int positionX, final int positionY) {
        return gameBoardLayout[positionX][positionY];
    }
}
