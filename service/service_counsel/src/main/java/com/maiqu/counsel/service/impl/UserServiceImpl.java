package com.maiqu.counsel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maiqu.counsel.entity.CounselUser;
import com.maiqu.counsel.mapper.CounselUserMapper;
import com.maiqu.counsel.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<CounselUserMapper,CounselUser> implements UserService {

}
