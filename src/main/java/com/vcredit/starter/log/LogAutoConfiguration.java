/*    */ package com.vcredit.starter.log;
/*    */ 
/*    */ import com.vcredit.starter.log.annotation.Log;
/*    */ import com.vcredit.starter.log.config.LogProperties;
/*    */ import com.vcredit.starter.log.interceptor.LogMethodInterceptor;
/*    */ import com.vcredit.starter.log.interceptor.LogRequestHandler;
/*    */ import com.vcredit.starter.log.interceptor.SleuthLogRequestHandler;
/*    */ import javax.annotation.PostConstruct;
/*    */ import org.aopalliance.aop.Advice;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.aop.Pointcut;
/*    */ import org.springframework.aop.support.AbstractPointcutAdvisor;
/*    */ import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
/*    */ import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
/*    */ import org.springframework.boot.context.properties.EnableConfigurationProperties;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ 
/*    */ @ConditionalOnClass({LogRequestHandler.class})
/*    */ @EnableConfigurationProperties({LogProperties.class})
/*    */ public class LogAutoConfiguration extends AbstractPointcutAdvisor
/*    */ {
/* 26 */   private static final Logger log = LoggerFactory.getLogger(LogAutoConfiguration.class);
/*    */   private static final long serialVersionUID = 5318746171559055607L;
/*    */   private Pointcut pointcut;
/*    */   private Advice advice;
/*    */ 
/*    */   @Autowired
/*    */   private LogRequestHandler logRequestHandler;
/*    */ 
/*    */   @Autowired
/*    */   private LogProperties logProperties;
/*    */ 
/*    */   @Bean
/*    */   @ConditionalOnMissingBean({LogRequestHandler.class})
/*    */   public LogRequestHandler logRequestHandler()
/*    */   {
/* 44 */     return new SleuthLogRequestHandler();
/*    */   }
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 53 */     log.info("init LogAutoConfiguration start");
/* 54 */     this.pointcut = new AnnotationMatchingPointcut(null, Log.class);
/* 55 */     this.advice = new LogMethodInterceptor(this.logRequestHandler, this.pointcut);
/* 56 */     log.info("init LogAutoConfiguration end");
/*    */   }
/*    */ 
/*    */   public Pointcut getPointcut()
/*    */   {
/* 34 */     return this.pointcut;
/*    */   }
/* 36 */   public Advice getAdvice() { return this.advice; }
/*    */ 
/*    */   public LogRequestHandler getLogRequestHandler() {
/* 39 */     return this.logRequestHandler;
/*    */   }
/*    */ 
/*    */   public LogProperties getLogProperties()
/*    */   {
/* 49 */     return this.logProperties;
/*    */   }
/*    */ 
/*    */   public void setPointcut(Pointcut pointcut)
/*    */   {
/* 27 */     this.pointcut = pointcut; } 
/* 27 */   public void setAdvice(Advice advice) { this.advice = advice; } 
/* 27 */   public void setLogRequestHandler(LogRequestHandler logRequestHandler) { this.logRequestHandler = logRequestHandler; } 
/* 27 */   public void setLogProperties(LogProperties logProperties) { this.logProperties = logProperties; } 
/* 27 */   public String toString() { return "LogAutoConfiguration(pointcut=" + getPointcut() + ", advice=" + getAdvice() + ", logRequestHandler=" + getLogRequestHandler() + ", logProperties=" + getLogProperties() + ")"; } 
/* 28 */   public boolean equals(Object o) { if (o == this) return true; if (!(o instanceof LogAutoConfiguration)) return false; LogAutoConfiguration other = (LogAutoConfiguration)o; if (!other.canEqual(this)) return false; if (!super.equals(o)) return false; Object this$pointcut = getPointcut(); Object other$pointcut = other.getPointcut(); if (this$pointcut == null ? other$pointcut != null : !this$pointcut.equals(other$pointcut)) return false; Object this$advice = getAdvice(); Object other$advice = other.getAdvice(); if (this$advice == null ? other$advice != null : !this$advice.equals(other$advice)) return false; Object this$logRequestHandler = getLogRequestHandler(); Object other$logRequestHandler = other.getLogRequestHandler(); if (this$logRequestHandler == null ? other$logRequestHandler != null : !this$logRequestHandler.equals(other$logRequestHandler)) return false; Object this$logProperties = getLogProperties(); Object other$logProperties = other.getLogProperties(); return this$logProperties == null ? other$logProperties == null : this$logProperties.equals(other$logProperties); } 
/* 28 */   protected boolean canEqual(Object other) { return other instanceof LogAutoConfiguration; } 
/* 28 */   public int hashCode() { int PRIME = 59; int result = super.hashCode(); Object $pointcut = getPointcut(); result = result * 59 + ($pointcut == null ? 43 : $pointcut.hashCode()); Object $advice = getAdvice(); result = result * 59 + ($advice == null ? 43 : $advice.hashCode()); Object $logRequestHandler = getLogRequestHandler(); result = result * 59 + ($logRequestHandler == null ? 43 : $logRequestHandler.hashCode()); Object $logProperties = getLogProperties(); return result * 59 + ($logProperties == null ? 43 : $logProperties.hashCode());
/*    */   }
/*    */ }
