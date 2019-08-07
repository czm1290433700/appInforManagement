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
    public int insert(DevUser devUser) {
        return devUserMapper.insert(devUser);
    }
}
