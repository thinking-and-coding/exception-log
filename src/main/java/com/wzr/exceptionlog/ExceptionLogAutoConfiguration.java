package com.wzr.exceptionlog;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description:// 异常日志切面
 * <p>
 * Create datetime: 2021/4/18 12:44 下午
 * author: wangziren
 **/
@EnableAspectJAutoProxy
@Configuration
public class ExceptionLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ExceptionLogAspect.class)
    public ExceptionLogAspect exceptionLogAspect() {
        return new ExceptionLogAspect();
    }
}
