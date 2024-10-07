package TicTacToe.Strategies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;
import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    /*
     * 
     * {
     *     {0 -> { X -> 0, 0 -> 2}}
     *    {1 -> { X -> 0, 0 -> 2}}
     *    {2 -> {X-> 2, 0 -> 2}}

     * }
     */
    Map<Integer, Map<Symbol, Integer>> counts = new HashMap<> ();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        if(!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> colMap = counts.get(col);
        if(!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }
        colMap.put(symbol, colMap.get(symbol)+1);
        if(colMap.get(symbol) == board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void undo(Board board, Move move) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol, Integer> colMap = counts.get(col);
        colMap.put(symbol, colMap.get(symbol)-1);
    }

}
