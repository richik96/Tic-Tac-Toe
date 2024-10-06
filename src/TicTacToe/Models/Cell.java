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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellState getCellState() {
        return state;
    }

    public void setCellState(CellState state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
