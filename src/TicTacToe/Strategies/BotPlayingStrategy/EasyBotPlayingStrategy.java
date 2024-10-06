package TicTacToe.Strategies.BotPlayingStrategy;

import java.util.List;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.CellState;
import TicTacToe.Models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row : board.getCells()) {
            for (Cell cell: row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
