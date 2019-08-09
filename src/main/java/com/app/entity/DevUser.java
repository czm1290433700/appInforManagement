package com.app.entity;


import com.app.controller.validation.ValidGroup1;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class DevUser {
@Id
  private Long id;
  private String devCode;
  @NotBlank(message = "昵称不能为空",groups = {ValidGroup1.class})
  @Size(min=2,max=10,message="昵称的长度在2~10之间!",groups = {ValidGroup1.class})
  private String devName;
  @NotBlank(message="密码不能为空!",groups = {ValidGroup1.class})
  private String devPassword;
  @Email(message="邮箱不合法!",groups = {ValidGroup1.class})
  private String devEmail;
  private String devInfo;

  private Date creationDate;
  @NotBlank(message="手机不能为空!",groups = {ValidGroup1.class})
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
