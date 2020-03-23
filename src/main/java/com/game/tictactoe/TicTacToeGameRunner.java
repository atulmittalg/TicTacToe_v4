package com.game.tictactoe;

import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class TicTacToeGameRunner {
    private static final Logger logger = Logger.getLogger(TicTacToeGameRunner.class.getName());

    public static void main(String[] args) throws PositionAlreadyInUseException, GameOverException {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        String gameResult = playTicToeToe(ticTacToeGame);
        drawGameBoard(ticTacToeGame);
        logger.log(INFO, gameResult);
    }

    private static String playTicToeToe(final TicTacToeGame ticTacToeGame) throws PositionAlreadyInUseException, GameOverException {
        int positionX;
        int positionY;
        Scanner sc = new Scanner(System.in);
        String gameResult = null;
        while (null == gameResult) {
            logger.log(INFO, "Enter the Coordinates X and Y for the chance to be played at: ");
            positionX = sc.nextInt();
            positionY = sc.nextInt();
            gameResult = ticTacToeGame.playTurnAt(positionX, positionY);
        }
        return gameResult;
    }

    private static void drawGameBoard(final TicTacToeGame ticTacToeGame) {
        char[][] gameBoardLayout = ticTacToeGame.getGameBoardLayout();
        StringBuilder gameLayoutDisplay = new StringBuilder("\n");
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                gameLayoutDisplay.append(gameBoardLayout[row][column]);
                if (column != 2) {
                    gameLayoutDisplay.append(" | ");
                }
            }
            appendBreakForNextLine(gameLayoutDisplay, row);
        }
        logger.log(INFO, gameLayoutDisplay.toString());
    }

    private static void appendBreakForNextLine(final StringBuilder gameLayoutDisplay, final int row) {
        gameLayoutDisplay.append("\n");
        if (row != 2) {
            gameLayoutDisplay.append("--  --  --");
            gameLayoutDisplay.append("\n");
        }
    }
}