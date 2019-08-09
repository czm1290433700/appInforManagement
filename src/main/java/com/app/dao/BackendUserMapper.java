package com.app.dao;

import com.app.entity.AppInfoExample;
import com.app.entity.BackendUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BackendUserMapper extends Mapper<BackendUser> {
    //查找所有审核未通过的App信息列表,返回的是一个APPinfo的包装类
    List<AppInfoExample> selectCheckNotPassAppInfoList() throws Exception;
    //查找所有审核通过的App信息列表,返回的是一个APPinfo的包装类
    List<AppInfoExample> selectCheckPassAppInfoList() throws Exception;
}
