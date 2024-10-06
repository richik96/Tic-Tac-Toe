package TicTacToe.Models;

import TicTacToe.Stratergies.BotPlayingStratergy.BotPlayingStratergy;

public class Bot extends Player implements BotPlayingStratergy{

    private BotDifficultyLevel difficultylevel;
    private BotPlayingStratergy botPlayingStratergy;


    public Bot(Long id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel difficultylevel) {
        super(id, name, symbol, playerType);
        this.difficultylevel = difficultylevel;
    }

    public BotDifficultyLevel getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(BotDifficultyLevel difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    
}
