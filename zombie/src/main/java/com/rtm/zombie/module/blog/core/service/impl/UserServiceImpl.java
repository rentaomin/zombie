/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Dell
 * Date:     2018/10/6 12:50
 * Description: 用户接口实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.service.impl;

import com.rtm.zombie.module.blog.core.dao.UserDao;
import com.rtm.zombie.module.blog.core.entity.User;
import com.rtm.zombie.module.blog.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用户接口实现类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        List<User> userList = null;
        userList = userDao.getUserList();
        try {
            userList = userDao.getUserList();
        } catch (Exception e) {
            logger.error("查询用户列表信息出错！",e);
        }
        return userList;
    }

    @Override
    @Transactional
    public int save(User user) {
        user.setEmail("939943844Wqq.com");
        user.setMobileNum("13520726631");
        user.setStatus("1");
        user.setInsertTime(new Date());
        user.setOperateTime(new Date());
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
         userDao.deleteById(id);
    }
}
