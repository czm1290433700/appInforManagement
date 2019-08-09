package com.app.service.impl;

import com.app.dao.AppInfoMapper;
import com.app.dao.BackendUserMapper;
import com.app.entity.AppInfo;
import com.app.entity.AppInfoExample;
import com.app.entity.BackendUser;
import com.app.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Autowired
    BackendUserMapper backendUserMapper;
    @Autowired
    AppInfoMapper appInfoMapper;

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
    /**
     * 查找所有审核未通过的App信息列表,返回的是一个APPinfo的包装类
     */
    @Override
    public List<AppInfoExample> findCheckNotPassAppInfoList() throws Exception {
        return backendUserMapper.selectCheckNotPassAppInfoList();
    }
    /**
     * 查找所有审核通过的App信息列表,返回的是一个APPinfo的包装类
     */
    @Override
    public List<AppInfoExample> findCheckPassAppInfoList() throws Exception {
        return backendUserMapper.selectCheckPassAppInfoList();
    }

    /**
     * 审核通过
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkPass(Long id) throws Exception {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo.setStatus((long)5);
        int res =appInfoMapper.updateByPrimaryKeySelective(appInfo);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 审核不通过
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkNotPass(Long id) throws Exception {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo.setStatus((long)6);
        int res =appInfoMapper.updateByPrimaryKeySelective(appInfo);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
}
