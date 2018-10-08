/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MybatisConfig
 * Author:   Dell
 * Date:     2018/10/7 9:52
 * Description: mbatis mapper类扫描配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.configure.orm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 〈Coding never to stop〉<br> 
 * 〈mbatis mapper类扫描配置〉
 *
 * @author zombie
 * @create 2018/10/7
 * @since 1.0.0
 */
@Configuration
@MapperScan(basePackages = "com.rtm.zombie.module.blog.core.dao")
public class MybatisConfig {

}
