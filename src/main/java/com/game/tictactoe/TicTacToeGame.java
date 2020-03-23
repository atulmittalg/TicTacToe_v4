package com.game.tictactoe;

public class TicTacToeGame {
    private char[][] gameBoardLayout = new char[3][3];
    private char currentPlayerToBePlayed = 'X';

    public String playTurnAt(final int positionX, final int positionY) throws PositionAlreadyInUseException {
        checkIsPositionAlreadyFilled(positionX, positionY);
        gameBoardLayout[positionX][positionY] = currentPlayerToBePlayed;
        if (isXWinnerByRow()) return "Player X is the Winner";
        if (isOWinnerByRow()) return "Player O is the Winner";
        if (isXWinnerByColumn()) return "Player X is the Winner";
        if ((getPlayerAt(0,0) == 'O') &&
                (getPlayerAt(0,0) == getPlayerAt(1,0)) &&
                (getPlayerAt(0,0) == getPlayerAt(2,0))) {
            return "Player O is the Winner";
        }
        currentPlayerToBePlayed = getNextPlayerToBePlayed();
        return null;
    }

    private boolean isXWinnerByColumn() {
        for(int column = 0; column <3 ; column++) {
            if ((getPlayerAt(0,column) == 'X') &&
                    (getPlayerAt(0,column) == getPlayerAt(1,column)) &&
                    (getPlayerAt(0,column) == getPlayerAt(2,column))) {
                return true;
            }
        }
        return false;
    }

    private boolean isOWinnerByRow() {
        for(int row = 0; row <3 ; row++) {
            if ((getPlayerAt(row,0) == 'O') &&
                    (getPlayerAt(row,0) == getPlayerAt(row,1)) &&
                    (getPlayerAt(row,0) == getPlayerAt(row,2))) {
                return true;
            }
        }
        return false;
    }

    private boolean isXWinnerByRow() {
        for(int row = 0; row <3 ; row++) {
            if ((getPlayerAt(row,0) == 'X') &&
                    (getPlayerAt(row,0) == getPlayerAt(row,1)) &&
                    (getPlayerAt(row,0) == getPlayerAt(row,2))) {
                return true;
            }
        }
        return false;
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