package TicTacToe.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import TicTacToe.Strategies.WinningStrategy.WinningStrategy;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameStatus;
    private Player winner;
    private int nextPlayerTurnIndex;
    private List<WinningStrategy> winningStrategy;

    public Game(int dimentions, List<Player> players, List<WinningStrategy> winningStrategy) {
        this.board = new Board(dimentions);
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.moves = new ArrayList<>();
        this.gameStatus = GameState.IN_PROGRESS;
        this.nextPlayerTurnIndex = 0;
        
    }

    //verify the client inputs ---> builder design pattern
    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int dimentions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategy;

        public Game build() throws PlayerCountException, BotCountException , SymbolCountException{
            validate();
            return new Game(dimentions, players, winningStrategy);
        }

        private void validate() throws PlayerCountException, BotCountException , SymbolCountException{
            // TODO Auto-generated method stub
            validateBotCount();
            validatePlayerCount();
            validateSymbolCount();
        }

        private void validateBotCount() throws BotCountException{
            int countOfBot = 0;
            for(Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    countOfBot++;
                }
            }
            if(countOfBot > 1)
                throw new BotCountException();
        }
        private void validatePlayerCount() throws PlayerCountException{
            if(players.size() != dimentions-1) {
                throw new PlayerCountException();
            }
        }
        private void validateSymbolCount() throws SymbolCountException{
            Map<Character, Integer> symbolCount = new HashMap<>();
            for(Player player : players) {
                if(! symbolCount.containsKey(player.getSymbol().getaChar())) {
                    symbolCount.put(player.getSymbol().getaChar(), 0);
                }
                symbolCount.put(player.getSymbol().getaChar(), symbolCount.get(player.getSymbol().getaChar())+1);
                if(symbolCount.get(player.getSymbol().getaChar()) > 1)
                    throw new SymbolCountException();
            }
        }

        public int getDimentions() {
            return dimentions;
        }
        public Builder setDimentions(int dimentions) {
            this.dimentions = dimentions;
            return this;
        }
        public List<Player> getPlayers() {
            return players;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public List<WinningStrategy> getWinningStrategy() {
            return winningStrategy;
        }
        public Builder setWinningStratergies(List<WinningStrategy> winningStrategy) {
            this.winningStrategy= winningStrategy;
            return this;
        }
        
    }


    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }
    public void setWinningStratergies(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public GameState getGameState() {
        return gameStatus;
    }
    public void setGameState(GameState gameStatus) {
        this.gameStatus = gameStatus;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public int getNextPlayerTurnIndex() {
        return nextPlayerTurnIndex;
    }
    public void setNextPlayerTurnIndex(int nextPlayerTurnIndex) {
        this.nextPlayerTurnIndex = nextPlayerTurnIndex;
    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerTurnIndex);
        System.out.println("It is "+currentPlayer.getName() + "'s Move");
        Move move = currentPlayer.makeMove(board);

        System.out.println(currentPlayer.getName() +" has made a move at " + move.getCell().getRow() + ", " + move.getCell().getColumn());

        if(!validateMove(move)) {
            System.out.println("Invalid move, please try again");
            return;
        }

        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        Cell actuaCellofBoard = board.getCells().get(row).get(column);
        actuaCellofBoard.setCellState(CellState.FILLED);
        actuaCellofBoard.setPlayer(currentPlayer);
        Move actualMove = new Move(actuaCellofBoard, currentPlayer);
        moves.add(actualMove);

        nextPlayerTurnIndex += 1;
        nextPlayerTurnIndex = nextPlayerTurnIndex % players.size();

        if(checkWinner(move)) {
            setGameState(GameState.WIN);
            setWinner(currentPlayer);
            return;
        }

        if(moves.size() == board.getSize() * board.getSize()) {
            setGameState(GameState.DRAW);
            System.out.println("Game has been drawn");
        }
    }

    public boolean checkWinner(Move move) {
        for(WinningStrategy winningStrategy : winningStrategy) {
            if(winningStrategy.checkWinner(board, move))
                return true;
        }
        return false;
    }
    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        if(row < 0 || row >= board.getSize() || column < 0 || column >= board.getSize()) { //user trying to make move outside of the board
            System.out.println("Invalid Move, Please try again");
            return false;
        }
        if(board.getCells().get(row).get(column).getCellState().equals(CellState.FILLED)) { //
            System.out.println("Cell already occupied, Please try again");
            return false;
        }
        return true;
    }
}
