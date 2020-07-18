package com.kushal.thoughtworks.beans;

public class HotelCell extends CellType {

  private Player owner;

  private HotelTypeEnum hotelCategory;

  private int amountForBank;

  private HotelCell(){
    super();
  }

  public HotelCell(HotelTypeEnum hotelCategory) {
    this.hotelCategory = hotelCategory;
  }

  @Override public int getValue() {
    return hotelCategory.getValue();
  }

  @Override public int getAmountForBank() {
    return amountForBank;
  }

  public void calcuateAmountForBank() {
    switch (hotelCategory) {
    case S:
      amountForBank = hotelCategory.getValue();
      break;
    case G:
      amountForBank = hotelCategory.getValue() - HotelTypeEnum.S.getValue();
      break;
    case P:
      amountForBank = hotelCategory.getValue() - HotelTypeEnum.G.getValue();
      break;
    default:
      amountForBank = 0;
      break;
    }
  }

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  @Override public int getAmountForAnotherPlayer() {
    return hotelCategory.getRent();
  }

  @Override
  public void process(Player player) {
    if(this.getOwner() == null ){
      if(player.getMoneyInHand() >= hotelCategory.getValue()) {
        this.setOwner(player);
        player.setMoneyInHand(player.getMoneyInHand() - hotelCategory.getValue());
        player.getHotelsOwned().add(this);
        calcuateAmountForBank();
      }
    } else if (this.getOwner() != null && this.getOwner().equals(player)){
      this.upgrade();
      if(player.getMoneyInHand() < this.getAmountForBank()) {
        this.downgrade();
      }
      player.setMoneyInHand(player.getMoneyInHand() - this.getAmountForBank());
      calcuateAmountForBank();
    } else {
      if(player.getMoneyInHand() > this.getAmountForAnotherPlayer()) {
        player.setMoneyInHand(player.getMoneyInHand() - this.getAmountForAnotherPlayer());
        owner.setMoneyInHand(owner.getMoneyInHand() + this.getAmountForAnotherPlayer());
        amountForBank = 0;
      }
    }
  }

  private void downgrade() {
    switch(hotelCategory) {
    case P:
      hotelCategory = HotelTypeEnum.G;
      break;
    case G:
      hotelCategory = HotelTypeEnum.S;
      break;
    case S:
    default:
      break;
    }
  }

  private void upgrade() {
    switch(hotelCategory) {
    case S:
      hotelCategory = HotelTypeEnum.G;
      break;
    case G:
      hotelCategory = HotelTypeEnum.P;
      break;
    case P:
    default:
      break;
    }
  }

}
