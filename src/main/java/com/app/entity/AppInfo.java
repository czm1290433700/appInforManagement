package com.app.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class AppInfo {

  @Id//标识主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
  private Long id;
  private String softwareName;
  private String apkName;
  private String supportRom;
  private String interfaceLanguage;
  private Double softWareSize;
  private Date updateDate;
  private Long devId;
  private String appInfo;
  private Long status;
  private Date onSaleDate;
  private Date offSaleDate;
  private Long floatFormId;
  private Long categpryLevel3;
  private Long downloads;
  private Date creationDate;
  private Long modifyBy;
  private Date modifyDate;
  private Long categoryLevel1;
  private Long categoryLevel2;
  private Long versionId;
  private String logoPicPath;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getSoftwareName() {
    return softwareName;
  }

  public void setSoftwareName(String softwareName) {
    this.softwareName = softwareName;
  }


  public String getApkName() {
    return apkName;
  }

  public void setApkName(String apkName) {
    this.apkName = apkName;
  }


  public String getSupportRom() {
    return supportRom;
  }

  public void setSupportRom(String supportRom) {
    this.supportRom = supportRom;
  }


  public String getInterfaceLanguage() {
    return interfaceLanguage;
  }

  public void setInterfaceLanguage(String interfaceLanguage) {
    this.interfaceLanguage = interfaceLanguage;
  }


  public Double getSoftWareSize() {
    return softWareSize;
  }

  public void setSoftWareSize(Double softWareSize) {
    this.softWareSize = softWareSize;
  }


  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }


  public Long getDevId() {
    return devId;
  }

  public void setDevId(Long devId) {
    this.devId = devId;
  }


  public String getAppInfo() {
    return appInfo;
  }

  public void setAppInfo(String appInfo) {
    this.appInfo = appInfo;
  }


  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }


  public Date getOnSaleDate() {
    return onSaleDate;
  }

  public void setOnSaleDate(Date onSaleDate) {
    this.onSaleDate = onSaleDate;
  }


  public Date getOffSaleDate() {
    return offSaleDate;
  }

  public void setOffSaleDate(Date offSaleDate) {
    this.offSaleDate = offSaleDate;
  }


  public Long getFloatFormId() {
    return floatFormId;
  }

  public void setFloatFormId(Long floatFormId) {
    this.floatFormId = floatFormId;
  }


  public Long getCategpryLevel3() {
    return categpryLevel3;
  }

  public void setCategpryLevel3(Long categpryLevel3) {
    this.categpryLevel3 = categpryLevel3;
  }


  public Long getDownloads() {
    return downloads;
  }

  public void setDownloads(Long downloads) {
    this.downloads = downloads;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public Long getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
  }


  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }


  public Long getCategoryLevel1() {
    return categoryLevel1;
  }

  public void setCategoryLevel1(Long categoryLevel1) {
    this.categoryLevel1 = categoryLevel1;
  }


  public Long getCategoryLevel2() {
    return categoryLevel2;
  }

  public void setCategoryLevel2(Long categoryLevel2) {
    this.categoryLevel2 = categoryLevel2;
  }


  public Long getVersionId() {
    return versionId;
  }

  public void setVersionId(Long versionId) {
    this.versionId = versionId;
  }


  public String getLogoPicPath() {
    return logoPicPath;
  }

  public void setLogoPicPath(String logoPicPath) {
    this.logoPicPath = logoPicPath;
  }

}
