package com.kushal.myproject.beans;

public enum HotelTypeEnum {

  S(200, 50, "Silver"),
  G(300,150,"Gold"),
  P(500, 300, "Platinum");

  int value;
  int rent;
  String desc;

  HotelTypeEnum(int value, int rent, String desc) {
    this.value = value;
    this.rent = rent;
    this.desc = desc;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getRent() {
    return rent;
  }

  public void setRent(int rent) {
    this.rent = rent;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}


