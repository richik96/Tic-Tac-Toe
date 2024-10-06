package TicTacToe.Stratergies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;

public interface WinningStrategy {

    public boolean checkWinner(Board board, Move move);
}
