package com.game.tictactoe;

public class TicTacToeGame {
    private char[][] gameBoardLayout = new char[3][3];
    private char currentPlayerToBePlayed = 'X';

    public String playTurnAt(final int positionX, final int positionY) throws PositionAlreadyInUseException {
        checkIsPositionAlreadyFilled(positionX, positionY);
        gameBoardLayout[positionX][positionY] = currentPlayerToBePlayed;
        if ((getPlayerAt(0,0) == 'X' ) &&
                (getPlayerAt(0,0) == getPlayerAt(0,1)) &&
                (getPlayerAt(0,0) == (getPlayerAt(0,2)))) {
            return "Player X is the Winner";
        }
        if ((getPlayerAt(1,0) == 'X' ) &&
                (getPlayerAt(1,0) == getPlayerAt(1,1)) &&
                (getPlayerAt(1,0) == (getPlayerAt(1,2)))) {
            return "Player X is the Winner";
        }
        currentPlayerToBePlayed = getNextPlayerToBePlayed();
        return null;
    }

    private void checkIsPositionAlreadyFilled(final int positionX, final int positionY) throws PositionAlreadyInUseException {
        if(gameBoardLayout[positionX][positionY] != '\0') {
            throw new PositionAlreadyInUseException(positionX, positionY);
        }
    }

    private char getNextPlayerToBePlayed() {
        return (currentPlayerToBePlayed == 'X') ? 'O' : 'X';
    }

    public char getPlayerAt(final int positionX, final int positionY) {
        return gameBoardLayout[positionX][positionY];
    }
}