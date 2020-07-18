package com.kushal.thoughtworks.beans;

public abstract class CellType {

  int value;
  int amountForBank;
  int amountForAnotherPlayer;

  public abstract int getValue();

  public abstract int getAmountForBank();

  public abstract int getAmountForAnotherPlayer();

  public void process(Player player) {
    if(player.getMoneyInHand() >= this.getValue()){
      player.setMoneyInHand(player.getMoneyInHand() - this.getValue());
    }
  }

}
