package com.dbzq.springboot.service.impl;

import com.dbzq.springboot.entity.User;
import com.dbzq.springboot.mapper.UserMapper;
import com.dbzq.springboot.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuld
 * @since 2019-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
