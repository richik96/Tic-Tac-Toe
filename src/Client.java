import TicTacToe.Controllers.GameController;

public class Client {
    public static void main(String[] args) throws Exception {
        
        GameController gameController = new GameController();

        try {
            int dimentions = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player());
            players.add(new BOT());
            List<WinningStratergy> winningStratergies = new ArrayList<>();

            Game game = GameController.startGame(dimentions, players, winningStratergies);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Something went wrong");
        }
        System.out.println("Game has been created");
        
    }
}
