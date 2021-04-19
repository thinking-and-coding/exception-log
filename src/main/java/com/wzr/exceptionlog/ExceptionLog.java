package com.wzr.exceptionlog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:// 异常日志注解
 * <p>
 * Create datetime: 2021/4/18 12:42 下午
 * author: wangziren
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionLog {
}
