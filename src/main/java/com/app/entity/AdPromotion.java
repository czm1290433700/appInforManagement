package com.app.entity;


import java.util.Date;

public class AdPromotion {

  private Long id;
  private Long appId;
  private String adPicPath;
  private Long adPv;
  private Long carouselPosition;
  private Date startTime;
  private Date endTime;
  private Long createBy;
  private Date creationDate;
  private Date modifyDate;


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


  public String getAdPicPath() {
    return adPicPath;
  }

  public void setAdPicPath(String adPicPath) {
    this.adPicPath = adPicPath;
  }


  public Long getAdPv() {
    return adPv;
  }

  public void setAdPv(Long adPv) {
    this.adPv = adPv;
  }


  public Long getCarouselPosition() {
    return carouselPosition;
  }

  public void setCarouselPosition(Long carouselPosition) {
    this.carouselPosition = carouselPosition;
  }


  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }


  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }


  public Long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Long createBy) {
    this.createBy = createBy;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

}
