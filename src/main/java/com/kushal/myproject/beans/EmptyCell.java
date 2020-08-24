package com.kushal.myproject.beans;

public class EmptyCell extends CellType {
  private static CellType emptyCellType = new EmptyCell();
  public static CellType getInstance(){
    return emptyCellType;
  }

  @Override public int getValue() {
    return CellTypeEnum.E.getValue();
  }

  @Override public int getAmountForBank() {
    return CellTypeEnum.E.getValue();
  }

  @Override public int getAmountForAnotherPlayer() {
    return 0;
  }

}
