package TicTacToe.Models;

import java.util.Scanner;

public class Player {

    private Long id;
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    private Scanner scanner;

    public Player(Long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board) {
        System.out.println("Enter the row and column number to place your symbol");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new Move(new Cell(row, column), this);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    

}
