package com.game.tictactoe;

public class TicTacToeGame {
    private final char PLAYERX = 'X';
    private final int MAXGRIDSIZE = 3;
    private char[][] gameBoardLayout = new char[MAXGRIDSIZE][MAXGRIDSIZE];
    private char currentPlayerToBePlayed = PLAYERX;
    private int totalTurnsPlayed;

    public String playTurnAt(final int positionX, final int positionY) throws PositionAlreadyInUseException {
        checkIsPositionAlreadyFilled(positionX, positionY);
        gameBoardLayout[positionX][positionY] = currentPlayerToBePlayed;
        totalTurnsPlayed++;
        if (isCurrentPlayerWinner()) return ("Player " + currentPlayerToBePlayed + " is the Winner");
        if (isGameDraw()) return "It is a Draw";
        currentPlayerToBePlayed = getNextPlayerToBePlayed();
        return null;
    }

    private boolean isGameDraw() {
        return (totalTurnsPlayed == 9);
    }

    private boolean isCurrentPlayerWinner() {
        return (isCurrentPlayerWinnerByRow() ||
                isCurrentPlayerWinnerByColumn() ||
                isCurrentPlayerWinnerByLeftToRightDiagonal() ||
                isCurrentPlayerWinnerByRightToLeftDiagonal());
    }

    private boolean isCurrentPlayerWinnerByRightToLeftDiagonal() {
        return (getPlayerAt(0, 2) == currentPlayerToBePlayed) &&
                (getPlayerAt(0, 2) == getPlayerAt(1, 1)) &&
                (getPlayerAt(0, 2) == (getPlayerAt(2, 0)));
    }

    private boolean isCurrentPlayerWinnerByLeftToRightDiagonal() {
        return (getPlayerAt(0, 0) == currentPlayerToBePlayed) &&
                (getPlayerAt(0, 0) == getPlayerAt(1, 1)) &&
                (getPlayerAt(0, 0) == (getPlayerAt(2, 2)));
    }

    private boolean isCurrentPlayerWinnerByColumn() {
        for(int column = 0; column <MAXGRIDSIZE ; column++) {
            if ((getPlayerAt(0,column) == currentPlayerToBePlayed) &&
                    (getPlayerAt(0,column) == getPlayerAt(1,column)) &&
                    (getPlayerAt(0,column) == getPlayerAt(2,column))) {
                return true;
            }
        }
        return false;
    }

    private boolean isCurrentPlayerWinnerByRow(){
        for(int row = 0; row <MAXGRIDSIZE ; row++) {
            if ((getPlayerAt(row,0) == currentPlayerToBePlayed) &&
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
        return (currentPlayerToBePlayed == PLAYERX) ? 'O' : PLAYERX;
    }

    public char getPlayerAt(final int positionX, final int positionY) {
        return gameBoardLayout[positionX][positionY];
    }
}