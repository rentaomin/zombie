/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GlobalControllerExceptionHandle
 * Author:   Dell
 * Date:     2018/10/7 13:25
 * Description: 全局controller层异常捕获处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rtm.zombie.module.blog.core.configure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈Coding never to stop〉<br> 
 * 〈全局controller层异常捕获处理〉
 *  该@ControllerAdvice 注解会捕获全局controller层的异常，前提是没有
 *  try catch,若进行try catch 处理则会导致无法捕获异常
 *
 * @author zombie
 * @create 2018/10/7
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandle   {

    private Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandle.class);

    /**
     * 用于处理全局controllerc层异常的方法
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String  GlobleControllerExceptionHandler(HttpServletRequest request,Exception e){
        String message = e.getMessage();
        String url  = request.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(System.currentTimeMillis());
        logger.error("日期为："+time+"url:"+url+"当前请求发生了错误，正在处理，错误信息为：",message);
        return  "日期为："+time+" url:"+url+"当前请求发生了错误，正在处理，错误信息为："+message;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
            public void setAsText(String text){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    setValue(sdf.parse(text));
                } catch (ParseException e) {
                    logger.error("格式化日期出错！",e);
                }
            }
        });
    }

    private boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    private boolean isNotEmpty(String str) {
        return !(str == null || "".equals(str.trim()));
    }
}
