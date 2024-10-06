package TicTacToe.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolCountException;
import TicTacToe.Stratergies.WinningStratergy.WinningStratergy;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameStatus;
    private Player winner;
    private int nextPlayerTurnIndex;
    private List<WinningStratergy> winningStratergies;

    private Game(int dimentions, List<Player> players, List<WinningStratergy> winningStratergies) {
        board = new Board(dimentions);
        this.players = players;
        this.winningStratergies = winningStratergies;
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
        private List<WinningStratergy> winningStratergies;

        private Game build() throws PlayerCountException, BotCountException , SymbolCountException{
            validate();
            return new Game(dimentions, players, winningStratergies);
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
        public List<WinningStratergy> getWinningStratergies() {
            return winningStratergies;
        }
        public Builder setWinningStratergies(List<WinningStratergy> winningStratergies) {
            this.winningStratergies = winningStratergies;
            return this;
        }
        
    }


    public List<WinningStratergy> getWinningStratergies() {
        return winningStratergies;
    }
    public void setWinningStratergies(List<WinningStratergy> winningStratergies) {
        this.winningStratergies = winningStratergies;
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
    public GameState getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameState gameStatus) {
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
    
}
