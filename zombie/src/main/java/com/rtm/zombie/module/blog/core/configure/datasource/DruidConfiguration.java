/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DruidConfiguration
 * Author:   Dell
 * Date:     2018/10/6 15:45
 * Description: Druid 连接池配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.configure.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.swing.*;
import java.sql.SQLException;

/**
 * 〈Coding never to stop〉<br> 
 * 〈Druid 连接池配置类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */

@Configuration
public class DruidConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Autowired
    private DruidProperties druidProperties;

    @Bean(name = "dataSource")
    public DruidDataSource getDruidDataSource(DruidProperties druidProperties){
        DruidDataSource druidDataSource = new DruidDataSource();
        if (druidProperties == null) {
            logger.error("初始化阿里数据库连接池出错！");
            return druidDataSource;
        }
        druidProperties = this.druidProperties;
        druidDataSource.setUrl(druidProperties.getUrl());
        druidDataSource.setUsername(druidProperties.getUsername());
        druidDataSource.setPassword(druidProperties.getPassword());
        druidDataSource.setDriverClassName(druidProperties.getDriverClassName());
        druidDataSource.setInitialSize(druidProperties.getInitialSize());
        druidDataSource.setMinIdle(druidProperties.getMinIdle());
        druidDataSource.setMaxActive(druidProperties.getMaxActive());
        druidDataSource.setMaxWait(druidProperties.getMaxWait());
        druidDataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(druidProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(druidProperties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(druidProperties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(druidProperties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(druidProperties.isPoolPreparedStatements());
        druidDataSource.setUseGlobalDataSourceStat(druidProperties.isUseGlobalDataSourceStat());
        druidDataSource.setConnectProperties(druidProperties.getConnectionProperties());
        try {
            druidDataSource.setFilters(druidProperties.getFilters());
        } catch (SQLException e) {
            logger.error("初始化druid 数据源出错！",e);
        }
        logger.info("druid连接池初始化成功！连接数据库地址为："+druidDataSource.getUrl());
        return druidDataSource;
    }


    @Bean
    public ServletRegistrationBean statViewServlet() {
        logger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 注册 IP 白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 注册IP 黑名单，（共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.206.1");
        // 控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        logger.info("calling druid exclusins filter");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}