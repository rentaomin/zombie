/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserDao
 * Author:   zombie
 * Date:     2018/10/6 12:55
 * Description: 用户 dao层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.dao;

import com.rtm.zombie.module.blog.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用户 dao层〉
 *
 * @Mapper 此处可以写mapper注解，用于表明该类为maapper类，或者在启动类加入注解扫描也可以
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */
public interface UserDao{

    /**
     * 查询所有用户列表信息
     * @return 用户列表
     */
    List<User> getUserList();

    /**
     * 保存用户信息，返回主键id
     * @return
     */
    int save(User user);

    /**
     * 通过用户主键删除用户信息
     * @param id
     */
    void deleteById(long id);
}
