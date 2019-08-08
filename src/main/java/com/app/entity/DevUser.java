package com.app.entity;

import java.util.Date;

public class DevUser {

  private Long id;
  private String devCode;
  private String devName;
  private String devPassword;
  private String devEmail;
  private String devInfo;
  private Date creationDate;
  private String phone;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getDevCode() {
    return devCode;
  }

  public void setDevCode(String devCode) {
    this.devCode = devCode;
  }


  public String getDevName() {
    return devName;
  }

  public void setDevName(String devName) {
    this.devName = devName;
  }


  public String getDevPassword() {
    return devPassword;
  }

  public void setDevPassword(String devPassword) {
    this.devPassword = devPassword;
  }


  public String getDevEmail() {
    return devEmail;
  }

  public void setDevEmail(String devEmail) {
    this.devEmail = devEmail;
  }


  public String getDevInfo() {
    return devInfo;
  }

  public void setDevInfo(String devInfo) {
    this.devInfo = devInfo;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}
