/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: User
 * Author:   Dell
 * Date:     2018/10/6 12:40
 * Description: 用户实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 〈Coding never to stop〉<br> 
 * 〈用户实体类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private Long id;

    private String userName;

    private String passWord;

    private String mobileNum;

    private String email;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;
}
