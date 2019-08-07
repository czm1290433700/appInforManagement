package com.app.service;

import com.app.entity.DevUser;
import org.springframework.stereotype.Service;

@Service
public interface DevUserService {
    int insert(DevUser devUser);
}
