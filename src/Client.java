import java.util.ArrayList;
import java.util.List;

import TicTacToe.Controllers.GameController;
import TicTacToe.Models.Bot;
import TicTacToe.Models.BotDifficultyLevel;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameState;
import TicTacToe.Models.Player;
import TicTacToe.Models.PlayerType;
import TicTacToe.Models.Symbol;
import TicTacToe.Stratergies.WinningStrategy.WinningStrategy;

public class Client {
    public static void main(String[] args) throws Exception {
        
        GameController gameController = new GameController();

        try {
            int dimentions = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1L, "Player1", new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2L, "GPT", new Symbol('0'), PlayerType.BOT, BotDifficultyLevel.EASY));
            List<WinningStrategy> winningStratergies = new ArrayList<>();

            Game game = GameController.startGame(dimentions, players, winningStratergies);

            while(gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.displayBoard(game);
                gameController.makeMove(game);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Something went wrong");
            System.out.println(e);
        }
        System.out.println("Game has been created");
        
    }
}
