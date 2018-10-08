/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   Dell
 * Date:     2018/10/6 13:06
 * Description: 用户请求分发类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.controller;

import com.rtm.zombie.module.blog.core.entity.User;
import com.rtm.zombie.module.blog.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用户请求分发类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表信息
     * @return
     */
    @GetMapping(value = "list")
    public List<User> getUserList(){
       return userService.getUserList();
    }

    /**
     * 保存用户信息
     * @param userName
     * @param passWord
     * @return
     */
    @GetMapping(value = "/saveUser")
    public String saveUser(@RequestParam String userName, @RequestParam String passWord){
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        int id = userService.save(user);
        return "user:"+user.getUserName()+" saved "+id;
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam int id){
        userService.deleteById(id);
        return id+" user deleted";
    }
}
