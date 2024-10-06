package TicTacToe.Models;

import TicTacToe.Strategies.BotPlayingStrategy.BotPlayingStrategy;
import TicTacToe.Strategies.BotPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player implements BotPlayingStrategy{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;


    public Bot(Long id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStratergy(botDifficultyLevel);
    }

    public Move makeMove(Board board){
       Move move =  this.botPlayingStrategy.makeMove(board);
       move.setPlayer(this);
       return move;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
