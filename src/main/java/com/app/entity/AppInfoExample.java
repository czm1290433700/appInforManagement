/**
 * Copyright (C), 2019
 * 文件名: AppInfoExample
 * 作者:   HU
 * 日期:     2019/8/9 14:10
 * 描述:
 */
package com.app.entity;

public class AppInfoExample extends AppInfo{
   private String categoryName;
   private String downloadLink;
   private String valueName;//平台名字

    @Override
    public String toString() {
        return "AppInfoExample{" +
                "categoryName='" + categoryName + '\'' +
                ", downloadLink='" + downloadLink + '\'' +
                ", valueName='" + valueName + '\'' +
                '}';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}