package com.kushal.myproject.beans;

public class Cell {
  private String cellType;
  private CellType type;

  public Cell(String cellType) {
    this.cellType = cellType;
    switch(cellType) {
    case "E":
      type = EmptyCell.getInstance();
      break;
    case "H":
      type = new HotelCell(HotelTypeEnum.S);
      break;
    case "L":
      type = LotteryCellType.getInstance();
      break;
    case "J":
      type = JailCell.getInstance();
    }
  }

  public void process(Player player) {
    type.process(player);
  }

  public CellType getType() {
    return type;
  }

  public void setType(CellType type) {
    this.type = type;
  }
}
