/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloWorldController
 * Author:   Dell
 * Date:     2018/10/6 10:18
 * Description: 用于测试springboot 项目搭建成功类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用于测试springboot 项目搭建成功类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */
@RestController
public class HelloWorldController {


    @GetMapping(value = "/hello")
    public  String hello(){
        return "hello world spring boot!";
    }
}
