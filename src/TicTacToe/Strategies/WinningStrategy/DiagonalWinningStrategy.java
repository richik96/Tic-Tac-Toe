package TicTacToe.Strategies.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy{

    Map<Symbol, Integer> leftDiagonalMap = new HashMap<>();
    Map<Symbol, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col) {
            if(!leftDiagonalMap.containsKey(symbol)) {
                leftDiagonalMap.put(symbol, 0);
            }
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol)+1);
            if(leftDiagonalMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        if(row+col == board.getSize() - 1) {
            if(!rightDiagonalMap.containsKey(symbol)) {
                rightDiagonalMap.put(symbol, 0);
            }
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)+1);
            if(rightDiagonalMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }

}
