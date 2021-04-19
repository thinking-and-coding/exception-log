package com.wzr.exceptionlog;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Description:// 异常日志切面
 * <p>
 * Create datetime: 2021/4/18 12:44 下午
 * author: wangziren
 **/
@Slf4j
@Aspect
@Component
public class ExceptionLogAspect {

    /**
     * The syntax of pointcut : https://blog.csdn.net/zhengchao1991/article/details/53391244
     */
    @Pointcut("@annotation(ExceptionLog)||@within(ExceptionLog)")
    public void pointcut() {
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        // 打印方法参数及异常信息
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        String[] params = methodSignature.getParameterNames();
        Object[] args = jp.getArgs();
        String method = jp.getTarget().getClass().getName() + "." + methodSignature.getName();
        boolean noParams = (params == null || params.length == 0) || (args == null || args.length == 0);
        if (noParams) {
            log.error("方法:[{}()]调用出现异常!", method);
        } else {
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                stringBuffer.append(params[i]).append(":").append(args[i]);
            }
            log.error("|->方法:[{}({})]调用出现异常!", method, stringBuffer.toString());
        }
        log.error("|->异常信息:", e);
    }
}
