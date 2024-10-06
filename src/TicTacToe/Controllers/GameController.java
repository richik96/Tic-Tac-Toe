
package TicTacToe.Controllers;

import java.util.List;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import TicTacToe.Models.Game;
import TicTacToe.Models.Player;
import TicTacToe.Stratergies.WinningStratergy.WinningStratergy;

public class GameController {

    public static Game startGame(int dimentions, List<Player> players, List<WinningStratergy> winningStratergies) throws PlayerCountException, BotCountException , SymbolCountException{

        return new Game.getBuilder().setDimentions(dimentions)
                                    .setPlayers(players)
                                    .setWinningStratergies(winningStratergies)
                                    .build();

    }

    public void makeMove() {

    }

    public void checkState() {

    }

    public void undo() {

    }
}
