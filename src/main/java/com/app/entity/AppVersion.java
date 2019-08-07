package com.app.entity;


import java.util.Date;

public class AppVersion {

  private Long id;
  private Long appId;
  private String versionNo;
  private String versionInfo;
  private Long publishStatus;
  private String downloadLink;
  private Double versionSize;
  private Date creationDate;
  private Long createBy;
  private String apkFileName;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getAppId() {
    return appId;
  }

  public void setAppId(Long appId) {
    this.appId = appId;
  }


  public String getVersionNo() {
    return versionNo;
  }

  public void setVersionNo(String versionNo) {
    this.versionNo = versionNo;
  }


  public String getVersionInfo() {
    return versionInfo;
  }

  public void setVersionInfo(String versionInfo) {
    this.versionInfo = versionInfo;
  }


  public Long getPublishStatus() {
    return publishStatus;
  }

  public void setPublishStatus(Long publishStatus) {
    this.publishStatus = publishStatus;
  }


  public String getDownloadLink() {
    return downloadLink;
  }

  public void setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
  }


  public Double getVersionSize() {
    return versionSize;
  }

  public void setVersionSize(Double versionSize) {
    this.versionSize = versionSize;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public Long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Long createBy) {
    this.createBy = createBy;
  }


  public String getApkFileName() {
    return apkFileName;
  }

  public void setApkFileName(String apkFileName) {
    this.apkFileName = apkFileName;
  }

}
