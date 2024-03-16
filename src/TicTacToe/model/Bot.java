package TicTacToe.model;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;


    public Bot(int id, String name, char symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, "BOT", symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        return null;
    }
}
