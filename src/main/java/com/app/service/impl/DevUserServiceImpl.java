package com.app.service.impl;

import com.app.dao.DevUserMapper;
import com.app.entity.DevUser;
import com.app.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Override
    public int register(DevUser devUser) {
        return devUserMapper.insert(devUser);
    }

    @Override
    @Transactional
    public boolean modifyDevUser(DevUser devUser) throws Exception {
        //updateByPrimaryKeySelective会对字段进行判断再更新(如果为Null就忽略更新)，如果你只想更新某一字段，可以用这个方法
        int res = devUserMapper.updateByPrimaryKey(devUser);
//        int i =10/0;除0异常
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public int deleteByEmail(String email) {
        DevUser devUser = new DevUser();
        devUser.setDevEmail(email);
        return devUserMapper.delete(devUser);
    }

    @Override
    public int update(DevUser devUser) {
        return devUserMapper.updateByPrimaryKeySelective(devUser);
    }

}
