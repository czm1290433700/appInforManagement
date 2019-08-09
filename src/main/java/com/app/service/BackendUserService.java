package com.app.service;

import com.app.entity.BackendUser;

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
}
