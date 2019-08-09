package com.app.service.impl;

import com.app.dao.BackendUserMapper;
import com.app.entity.BackendUser;
import com.app.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Autowired
    BackendUserMapper backendUserMapper;

    @Override
    public BackendUser findById(Integer id) {
        BackendUser backendUser = new BackendUser();
        backendUser.setId(id.longValue());
        return backendUserMapper.selectOne(backendUser);
    }

    @Override
    public BackendUser findByUserCode(String userCode) {
        BackendUser backendUser = new BackendUser();
        backendUser.setUserCode(userCode);
        return backendUserMapper.selectOne(backendUser);
    }
}
