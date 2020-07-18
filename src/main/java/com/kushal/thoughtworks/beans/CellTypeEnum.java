package com.kushal.thoughtworks.beans;

public enum CellTypeEnum {
  J(150, "Jail"),
  L(200, "Lottery"),
  E(0, "Empty"),
  H(0, "com.kushal.thoughtworks.beans.Hotel");

  int value;
  String desc;

  CellTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
