/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Role
 * Author:   Dell
 * Date:     2018/10/6 20:17
 * Description: 角色实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈Coding never to stop〉<br> 
 * 〈角色实体类〉
 *
 * @author zombie
 * @create 2018/10/6
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {

    private long id;

    private String roleName;

    private String status;

    private String  remark;

    private Date insertTime;

    private Date operateTime;
}
