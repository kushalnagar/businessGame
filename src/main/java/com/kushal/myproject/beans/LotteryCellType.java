package com.kushal.myproject.beans;

public class LotteryCellType extends CellType {
  private static CellType LotteryCellType = new LotteryCellType();
  public static CellType getInstance(){
    return LotteryCellType;
  }

  @Override public int getValue() {
    return -CellTypeEnum.L.getValue();
  }

  @Override public int getAmountForBank() {
    return -(CellTypeEnum.L.getValue());
  }

  @Override public int getAmountForAnotherPlayer() {
    return 0;
  }
}
