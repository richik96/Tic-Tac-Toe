package TicTacToe.Strategies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;

public class RowWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
