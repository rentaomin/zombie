/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserService
 * Author:   zombie
 * Date:     2018/10/6 12:49
 * Description: 用户接口类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.service;

import com.rtm.zombie.module.blog.core.entity.User;

import java.util.List;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用户接口类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 查询所用用户列表信息
     * @return 用户列表
     */
    List<User> getUserList();

    /**
     * 保存用户，返回用户主键id
     * @return
     */
    int save(User user);

    /**
     * 通过主键删除用户信息
     * @param id
     */
    void deleteById(int id);
}
