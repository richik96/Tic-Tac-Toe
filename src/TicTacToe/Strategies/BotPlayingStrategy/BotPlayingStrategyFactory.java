package TicTacToe.Strategies.BotPlayingStrategy;

import TicTacToe.Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStratergy(BotDifficultyLevel botDifficultyLevel) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getBotPlayingStratergy'");
        if (botDifficultyLevel.equals(BotDifficultyLevel.EASY))
            return new EasyBotPlayingStrategy();
        if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM))
            return new MediumBotPlayingStrategy();
        return new EasyBotPlayingStrategy();
    }
}
