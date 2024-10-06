package TicTacToe.Models;

public class Cell{

    private int row;
    private int column;
    private CellState state;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.column = col;
        this.state = CellState.EMPTY;
    }
}
