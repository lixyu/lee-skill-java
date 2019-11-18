package com.vcredit.starter.log.interceptor;

import com.alibaba.fastjson.JSON;
import com.vcredit.starter.log.bean.MsgBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;

public class LogMethodInterceptor implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LogMethodInterceptor.class);
    private LogRequestHandler logRequestHandler;
    private Pointcut annotationMatchingPointcut;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        MsgBean msg = this.packageMsg(invocation);
        long dtDate = System.currentTimeMillis();

        Object var15;
        try {
            Object obj = invocation.proceed();
            msg.put("result", JSON.toJSONString(obj));
            msg.put("level ", "INFO");
            var15 = obj;
        } catch (Exception var12) {
            Exception e = var12;
            List<StackTraceElement> list = new ArrayList();
            int i = 0;

            for(int j = var12.getStackTrace().length; i < j && !e.getStackTrace()[i].getClassName().toLowerCase().contains("logmethodinterceptor"); ++i) {
                list.add(e.getStackTrace()[i]);
            }

            msg.put("stack", list);
            msg.put("result", e.getMessage());
            msg.put("level", "ERROR");
            throw e;
        } finally {
            msg.put("runTime", System.currentTimeMillis() - dtDate);
            log.info(JSON.toJSONString(msg));
        }

        return var15;
    }

    private MsgBean packageMsg(MethodInvocation invocation) {
        MsgBean msg = new MsgBean();
        msg.put("className", invocation.getThis().getClass().getName());
        msg.put("methodName", invocation.getMethod().getName());
        msg.put("param", this.paramToString(invocation.getArguments()));
        msg.put("serviceName", this.logRequestHandler.service());
        msg.put("traceId", this.logRequestHandler.trace());
        msg.put("spanId", this.logRequestHandler.span());
        msg.put("parentSpanId", this.logRequestHandler.parent());
        msg.put("otherInfo", this.logRequestHandler.otherInfo());
        return msg;
    }

    private String paramToString(Object[] args) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(args).forEach((arg) -> {
            try {
                sb.append(JSON.toJSONString(arg)).append(";");
            } catch (Exception var3) {
                sb.append(arg);
            }

        });
        return sb.toString();
    }

    public LogRequestHandler getLogRequestHandler() {
        return this.logRequestHandler;
    }

    public Pointcut getAnnotationMatchingPointcut() {
        return this.annotationMatchingPointcut;
    }

    public void setLogRequestHandler(LogRequestHandler logRequestHandler) {
        this.logRequestHandler = logRequestHandler;
    }

    public void setAnnotationMatchingPointcut(Pointcut annotationMatchingPointcut) {
        this.annotationMatchingPointcut = annotationMatchingPointcut;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LogMethodInterceptor)) {
            return false;
        } else {
            LogMethodInterceptor other = (LogMethodInterceptor)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$logRequestHandler = this.getLogRequestHandler();
                Object other$logRequestHandler = other.getLogRequestHandler();
                if (this$logRequestHandler == null) {
                    if (other$logRequestHandler != null) {
                        return false;
                    }
                } else if (!this$logRequestHandler.equals(other$logRequestHandler)) {
                    return false;
                }

                Object this$annotationMatchingPointcut = this.getAnnotationMatchingPointcut();
                Object other$annotationMatchingPointcut = other.getAnnotationMatchingPointcut();
                if (this$annotationMatchingPointcut == null) {
                    if (other$annotationMatchingPointcut != null) {
                        return false;
                    }
                } else if (!this$annotationMatchingPointcut.equals(other$annotationMatchingPointcut)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof LogMethodInterceptor;
    }

    public int hashCode() {
        int result = 1;
        Object $logRequestHandler = this.getLogRequestHandler();
         result = result * 59 + ($logRequestHandler == null ? 43 : $logRequestHandler.hashCode());
        Object $annotationMatchingPointcut = this.getAnnotationMatchingPointcut();
        result = result * 59 + ($annotationMatchingPointcut == null ? 43 : $annotationMatchingPointcut.hashCode());
        return result;
    }

    public String toString() {
        return "LogMethodInterceptor(logRequestHandler=" + this.getLogRequestHandler() + ", annotationMatchingPointcut=" + this.getAnnotationMatchingPointcut() + ")";
    }

    public LogMethodInterceptor(LogRequestHandler logRequestHandler, Pointcut annotationMatchingPointcut) {
        this.logRequestHandler = logRequestHandler;
        this.annotationMatchingPointcut = annotationMatchingPointcut;
    }
}
