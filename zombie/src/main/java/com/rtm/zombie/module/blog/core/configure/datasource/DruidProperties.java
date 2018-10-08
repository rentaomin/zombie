/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DruidProperties
 * Author:   Dell
 * Date:     2018/10/7 19:47
 * Description: druid 属性配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.configure.datasource;

import com.alibaba.druid.filter.Filter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 〈Coding never to stop〉<br> 
 * 〈druid 属性配置类〉
 *
 * @author zombie
 * @create 2018/10/7
 * @since 1.0.0
 */

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DruidProperties  {

    /** 数据库连接地址url */
    private String url ;

    /** 数据库用户名称*/
    private String username;

    /** 数据库密码 */
    private String password;

    /** 数据库驱动名称 */
    private String driverClassName;

    /** # 配置数据源 */
    private String type;

    /** 初始化连接数 */
    private int initialSize;

    /** 最小空小连接数 */
    private int minIdle;

    /** 最大连接数 */
    private int maxActive;

    /** 配置获取连接超时最大等待时间 */
    private long maxWait;

    /** 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 */
    private long timeBetweenEvictionRunsMillis;

    /** 配置一个连接在池中最小生存的时间，单位是毫秒 */
    private long minEvictableIdleTimeMillis;

    /** 验证sql，校验数据库是否连接正常 */
    private String validationQuery ;

    /** 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。 */
    private boolean testWhileIdle;

    /** 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。*/
    private boolean testOnBorrow ;

    /** 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能 */
    private boolean testOnReturn;

    /** 是否缓存preparedStatement，也就是PSCache。比如说oracle 提升性能大。在mysql下建议关闭。 */
    private  boolean poolPreparedStatements;

    /** 配置扩展插件 监控统计用的filter:stat日志用的filter:log4j防御sql注入的filter:wall */
    private String filters;

    /** 通过connectProperties属性来打开mergeSql功能；慢SQL记录 */
    private java.util.Properties connectionProperties ;

    /** 合并多个DruidDataSource的监控数据 */
    private  boolean useGlobalDataSourceStat;

}
