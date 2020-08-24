package com.kushal.myproject;

import com.kushal.myproject.beans.Board;
import com.kushal.myproject.beans.Cell;
import com.kushal.myproject.beans.Player;

import java.util.ArrayList;
import java.util.List;

public class BusinessHouseGame {

  static List<Player> players = new ArrayList<Player>();

  public static void main(String[] args) {

    Board board = new Board(5000);
    //Let's consider first line of input : cell is "J,H,L,H,E,L,H,L,H,J"
    String cellInput = "J,H,L,H,E,L,H,L,H,J";
    String[] cellTypes = cellInput.split(",");
    //Adding cells to the board
    addCellsToBoard(board, cellTypes);

    //adding players to the game
    addPlayers(3);

    //Play with 7 chances each
    int[][] diceInput = { {2,2,1},
                          {4,4,2},
                          {4,4,2},
                          {2,2,1},
                          {4,4,2},
                          {4,4,2},
                          {2,2,1}};
    /*int[][] diceInput = {
        {2,2,1}, {4,2,3}, {4,1,3}, {2,2,7}, {4,7,2}, {4,4,2}, {2,2,2}};*/
    play(board, diceInput);
  }

  private static void play(Board board, int[][] diceInput ) {
    int numOfCells = board.getCells().size();
    int numOfPlayers = players.size();
    int chances = diceInput.length;
    for(int i = 0; i< chances; i++) {
      for(int j = 0; j< numOfPlayers; j++){
        int move = diceInput[i][j];
        int currentPosition = players.get(j).getCurrentPosition();
        int targetPosition = (currentPosition + move) % (numOfCells);
        players.get(j).move(targetPosition);
        board.process(players.get(j));
      }
    }

    //Print Final Result
    printResult(board);
  }

  private static void printResult(Board board) {
    players.forEach(player -> {
           System.out.println(player.getPlayerName() + " has total money " + player.getMoneyInHand() + " and asset of amount : " + player.hotelTotalValue());
      }
    );
    System.out.println("Balance at Bank :" + board.getTotalMoney());
  }

  private static void addPlayers(int numOfPlayers) {
    for(int i=0; i<numOfPlayers; i++){
      players.add(new Player(-1,1000, "Player-"+i));
    }
  }

  private static void addCellsToBoard(Board board, String[] cellTypes) {
    List<Cell> cells = new ArrayList<Cell>();
    for(int i=0; i<cellTypes.length; i++){
      cells.add(new Cell(cellTypes[i]));
    }
    board.setCells(cells);
  }
}
