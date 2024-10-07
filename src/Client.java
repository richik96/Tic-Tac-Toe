import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TicTacToe.Controllers.GameController;
import TicTacToe.Models.Bot;
import TicTacToe.Models.BotDifficultyLevel;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameState;
import TicTacToe.Models.Player;
import TicTacToe.Models.PlayerType;
import TicTacToe.Models.Symbol;
import TicTacToe.Strategies.WinningStrategy.ColumnWinningStrategy;
import TicTacToe.Strategies.WinningStrategy.DiagonalWinningStrategy;
import TicTacToe.Strategies.WinningStrategy.RowWinningStrategy;
import TicTacToe.Strategies.WinningStrategy.WinningStrategy;

public class Client {
    public static void main(String[] args) throws Exception {
        
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        try {
            int dimentions = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1L, "Player1", new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2L, "GPT", new Symbol('0'), PlayerType.BOT, BotDifficultyLevel.EASY));
            List<WinningStrategy> winningStratergies = new ArrayList<>();
            winningStratergies.add(new ColumnWinningStrategy());
            winningStratergies.add(new RowWinningStrategy());
            winningStratergies.add(new DiagonalWinningStrategy());

            Game game = GameController.startGame(dimentions, players, winningStratergies);

            while(gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.displayBoard(game);

                System.out.println("Do you want to do an undo (y/n)");
                String ans = sc.next();
                if(ans.equalsIgnoreCase("y")) {
                    gameController.undo(game);
                    continue;
                }
                gameController.makeMove(game);
            }

            if(gameController.checkState(game).equals(GameState.DRAW))
                System.out.println("Game is a drawn");
            
            if(gameController.checkState(game).equals(GameState.WIN))
                System.out.println("Winner is " + gameController.getWinner(game).getName());

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Something went wrong");
            System.out.println(e);
        }
        System.out.println("Game has been created");
        
    }
}
