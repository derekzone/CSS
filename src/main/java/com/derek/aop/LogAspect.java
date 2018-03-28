package com.derek.aop;

import com.derek.annotation.Log;
import com.derek.annotation.LogLevel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by derek on 2017/5/12.
 */
@Component
@Aspect
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(* com.derek.controller..*.*(..))&&"
            + "@annotation(log)")
    public void mark(Log log) {
    }

    @Around("mark(log)")
    public Object saveLog(ProceedingJoinPoint pjd, Log log) throws Throwable {
        Object result = null;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] args = pjd.getArgs();
            if (args != null) {
                for (Object arg : args) {
                    String className = arg.getClass().getName();
                    if (className.startsWith("java.lang") || className.startsWith("com.derek")) {
                        sb.append(arg);
                    }
                }
            }
        } catch (Throwable e) {
            printLog(e.toString(), LogLevel.ERRO);
        }
        try {
            result = pjd.proceed();
        } catch (Throwable e) {
            printLog(e.toString(), LogLevel.ERRO);
            throw e;
        }
        try {
            sb.append(result);
            printLog(sb.toString(), log.level());
        } catch (Throwable e) {
            printLog(e.toString(), LogLevel.ERRO);
        }
        return result;
    }

    /**
     * 打印日志
     *
     * @param msg
     * @param level
     */
    private void printLog(String msg, LogLevel level) {
        switch (level) {
            case ERRO: {
                logger.error(msg);
                break;
            }
            case INFO: {
                logger.info(msg);
                break;
            }
            case DEBUG: {
                logger.info(msg);
                break;
            }
            default: {
                logger.info(msg);
            }
        }
    }
}
