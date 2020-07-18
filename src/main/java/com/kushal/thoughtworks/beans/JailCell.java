package com.kushal.thoughtworks.beans;

public class JailCell extends CellType{
  private static CellType jailCellType = new JailCell();
  public static CellType getInstance(){
    return jailCellType;
  }

  @Override public int getValue() {
    return CellTypeEnum.J.getValue();
  }

  @Override public int getAmountForBank() {
    return CellTypeEnum.J.getValue();
  }

  @Override public int getAmountForAnotherPlayer() {
    return 0;
  }
}
