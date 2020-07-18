package com.kushal.thoughtworks.beans;

import java.util.List;

public class Board {
  List<Cell> cells ;
  long totalMoney;

  public Board(long totalMoney) {
    this.totalMoney = totalMoney;
  }

  public List<Cell> getCells() {
    return cells;
  }

  public void setCells(List<Cell> cells) {
    this.cells = cells;
  }

  public long getTotalMoney() {
    return totalMoney;
  }

  public void setTotalMoney(long totalMoney) {
    this.totalMoney = totalMoney;
  }

  public void process(Player player) {
    int playerCurrentPosition = player.getCurrentPosition();
    this.getCells().get(playerCurrentPosition).process(player);
    this.setTotalMoney(this.getTotalMoney() +
        this.getCells().get(playerCurrentPosition).getType().getAmountForBank());
  }
}
