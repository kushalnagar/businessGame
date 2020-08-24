package com.kushal.myproject.beans;

import java.util.ArrayList;
import java.util.List;

public class Player {
  String playerName;
  int currentPosition;
  long moneyInHand;
  List<CellType> hotelsOwned = new ArrayList<CellType>();

  public Player(int currentPosition, long moneyInHand, String name) {
    this.currentPosition = currentPosition;
    this.moneyInHand = moneyInHand;
    this.playerName = name;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int currentPosition) {
    this.currentPosition = currentPosition;
  }

  public long getMoneyInHand() {
    return moneyInHand;
  }

  public void setMoneyInHand(long moneyInHand) {
    this.moneyInHand = moneyInHand;
  }

  public List<CellType> getHotelsOwned() {
    return hotelsOwned;
  }

  public void setHotelsOwned(List<CellType> hotelsOwned) {
    this.hotelsOwned = hotelsOwned;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void move(int targetPosition) {
    this.setCurrentPosition(targetPosition);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    Player c = (Player) o;
    return this.getPlayerName().equals(c.getPlayerName());
  }

  public int hotelTotalValue(){
    int totalValue = 0;
    for(CellType hc : hotelsOwned) {
      totalValue =+ hc.getValue();
    }
    return totalValue;
  }
}
