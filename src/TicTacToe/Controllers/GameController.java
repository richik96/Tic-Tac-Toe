
package TicTacToe.Controllers;

import java.util.List;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameState;
import TicTacToe.Models.Player;
import TicTacToe.Strategies.WinningStrategy.WinningStrategy;

public class GameController {

    public static Game startGame(int dimentions, List<Player> players, 
                                            List<WinningStrategy> winningStrategies) 
                                            throws PlayerCountException, BotCountException , SymbolCountException{

        return Game.getBuilder().setDimentions(dimentions)
                                    .setPlayers(players)
                                    .setWinningStratergies(winningStrategies)
                                    .build();

    }

    public void displayBoard(Game game) {

        game.displayBoard();
        
    }

    public void makeMove(Game game) {

        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public void undo() {

    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
