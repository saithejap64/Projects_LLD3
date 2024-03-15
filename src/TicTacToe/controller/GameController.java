package TicTacToe.controller;

import TicTacToe.model.*;
import TicTacToe.service.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    //create game will automatically start the game
    public Game createGame(int dimensions, List<Player> players, WinningStrategy winningStrategy){
        return null;
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return null;
    }

    public Player getWinner(Game game){
        return null;
    }

    public Move exectueMove(Game game, Move lastMovePlayed){
        return null;
    }

    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }

    public void replayGame()
    {

    }

}
