package com.app.service.impl;

import com.app.dao.DevUserMapper;
import com.app.entity.DevUser;
import com.app.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    DevUserMapper devUserMapper;

    @Override
    public DevUser userSelectById(Integer id) {
        DevUser devUser = new DevUser();
        devUser.setId(id.longValue());
        return devUserMapper.selectOne(devUser);
    }

    @Override
    public DevUser userSelectByPhone(String phone) {
        DevUser devUser = new DevUser();
        devUser.setPhone(phone);
        return devUserMapper.selectOne(devUser);
    }

    @Override
    public DevUser userSelectByEmail(String email) {
        DevUser devUser = new DevUser();
        devUser.setDevEmail(email);
        return devUserMapper.selectOne(devUser);
    }
}
