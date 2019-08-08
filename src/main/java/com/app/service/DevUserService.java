package com.app.service;

import com.app.entity.DevUser;
import org.springframework.stereotype.Service;

@Service
public interface DevUserService {
    /**
     * 根据id查找user
     */
    DevUser userSelectById(Integer id);
    /**
     * 根据手机号查找user
     */
    DevUser userSelectByPhone(String phone);
    /**
     * 根据邮箱查找user
     */
    DevUser userSelectByEmail(String email);
}
