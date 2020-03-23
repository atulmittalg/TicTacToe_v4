package com.game.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeGameTest {


    private TicTacToeGame ticTacToeGame;

    @Before
    public void initializeTicTacToeGameObject(){
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    public void getPlayerAtShouldReturnXWhenFirstTurnIsPlayed() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        assertEquals('X', ticTacToeGame.getPlayerAt(0,0));
    }

    @Test
    public void getPlayerAtShouldReturnOWhenSecondTurnIsPlayed() throws PositionAlreadyInUseException , GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,1);
        assertEquals('O', ticTacToeGame.getPlayerAt(0,1));
    }

    @Test
    public void getPlayerAtShouldReturnXWhenThirdTurnIsPlayed() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(0,2);
        assertEquals('X', ticTacToeGame.getPlayerAt(0,2));
    }

    @Test(expected = PositionAlreadyInUseException.class)
    public void playTurnAtShouldThrowPositionAlreadyFilledExceptionWhenPlayingAtAUsedPosition() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,0);
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireFirstRowIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(2,0);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(0,2));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireSecondRowIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(2,0);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(1,2));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireThirdRowIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(2,1);
        ticTacToeGame.playTurnAt(1,0);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(2,2));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireFirstRowIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(2,2);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(0,2));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireSecondRowIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(2,2);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(1,2));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireThirdRowIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(2,1);
        ticTacToeGame.playTurnAt(0,2);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(2,2));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireFirstColumnIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(0,2);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(2,0));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireSecondColumnIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(0,2);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(2,1));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireThirdColumnIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(0,1);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(2,2));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireFirstColumnIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(2,2);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(2,0));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireSecondColumnIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(2,0);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(2,1));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireThirdColumnIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(2,0);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(2,2));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireLeftToRightDiagonalIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(0,2);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(2,2));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireLeftToRightDiagonalIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(1,2);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(2,2));
    }

    @Test
    public void playTurnAtShouldReturnXIsWinnerWhenEntireRightToLeftDiagonalIsOccupiedByX() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(0,0);
        assertEquals("Player X is the Winner", ticTacToeGame.playTurnAt(2,0));
    }

    @Test
    public void playTurnAtShouldReturnOIsWinnerWhenEntireRightToLeftDiagonalIsOccupiedByO() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(1,0);
        assertEquals("Player O is the Winner", ticTacToeGame.playTurnAt(2,0));
    }

    @Test
    public void playTurnAtShouldReturnItsADrawWhenNineChancesArePlayedAndNeitherPlayerHas3InARow() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(2,1);
        assertEquals("It is a Draw", ticTacToeGame.playTurnAt(2,2));
    }

    @Test(expected = GameOverException.class)
    public void playTurnAtShouldThrowGameOverExceptionWhenTurnIsPlayedAfterOutcomeWinIsReached() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(2,2);

    }

    @Test(expected = GameOverException.class)
    public void playTurnAtShouldThrowGameOverExceptionWhenTurnIsPlayedAfterOutcomeDrawIsReached() throws PositionAlreadyInUseException, GameOverException {
        ticTacToeGame.playTurnAt(0,0);
        ticTacToeGame.playTurnAt(0,2);
        ticTacToeGame.playTurnAt(0,1);
        ticTacToeGame.playTurnAt(1,0);
        ticTacToeGame.playTurnAt(1,2);
        ticTacToeGame.playTurnAt(1,1);
        ticTacToeGame.playTurnAt(2,0);
        ticTacToeGame.playTurnAt(2,1);
        ticTacToeGame.playTurnAt(2,2);
        ticTacToeGame.playTurnAt(1,1);
    }
}