package com.app.service;

import com.app.entity.AppInfoExample;
import com.app.entity.BackendUser;

import java.util.List;

/**
 * Create by CZM on 2019/8/9
 */
public interface BackendUserService {
    /**
     * 通过id查找管理员对象
     * @param id
     * @return
     */
    BackendUser findById(Integer id);

    /**
     * 通过userCode查找管理员对象
     * @param userCode
     * @return
     */
    BackendUser findByUserCode(String userCode);

    /**
     * 查找所有审核未通过的App信息列表,返回的是一个APPinfo的包装类
     */
    List<AppInfoExample>  findCheckNotPassAppInfoList() throws Exception;
    /**
     * 查找所有审核通过的App信息列表,返回的是一个APPinfo的包装类
     */
    List<AppInfoExample>  findCheckPassAppInfoList() throws Exception;
    /**
     * 点击通过，app审核通过
     */
    boolean checkPass(Long id) throws  Exception;

    /**
     * 点击不通过，app审核未通过
     */
    boolean checkNotPass(Long id) throws  Exception;

}
