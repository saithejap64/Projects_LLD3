package TicTacToe.model;

import TicTacToe.exception.InvalidBotCountException;
import TicTacToe.exception.InvalidPlayerSizeException;
import TicTacToe.exception.InvalidSymbolSetupException;
import TicTacToe.service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStatus;
    private WinningStrategy winningStrategy;
    private int numberOfSymbols;

    private Game(Board currentBoard, List<Player> players, Player currentPlayer, GameStatus gameStatus, List<Move> moves, List<Board> boardStatus, WinningStrategy winningStrategy, int numberOfSymbols) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStatus = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStatus() {
        return boardStatus;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoardStatus(List<Board> boardStatus) {
        this.boardStatus = boardStatus;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }


    public static class Builder{
        private Board currentBoard;
        private List<Player> players;
        private Player currentPlayer;
        private GameStatus gameStatus;
        private List<Move> moves;
        private List<Board> boardStatus;
        private WinningStrategy winningStrategy;
        private int numberOfSymbols;

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setCurrentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
            return this;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder setBoardStatus(List<Board> boardStatus) {
            this.boardStatus = boardStatus;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setNumberOfSymbols(int numberOfSymbols) {
            this.numberOfSymbols = numberOfSymbols;
            return this;
        }

        private void validateNumberOfPlayers(){
            //TODO: Convert below code into lambda expressions using streams
            //N, no bot -> players = N-1
            //N, bot -> players = N-2
            if(players.size()<=currentBoard.getDimension()-2 || players.size()>=currentBoard.getDimension()){
                throw new InvalidPlayerSizeException("Player size should be N-2 or N-1 as per board size");
            }
        }

        private void ValidatePlayerSymbols(){
            //TODO: Convert below code into lambda expressions using streams
            HashSet<Character> symbols=new HashSet<>();
            for(Player player: players){
                symbols.add(player.getSymbol());
            }

            if(symbols.size()!=players.size()){
                throw new InvalidSymbolSetupException("There should be unique symbol for all the players");
            }
        }

        private void ValidateBotCount(){
            //TODO: Convert below code into lambda expressions using streams
            int botCount=0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCount++;
            }
            if(botCount>1 || botCount<0){
                throw new InvalidBotCountException("We can have maximum of 1 bot per game");
            }
        }
    }
}
