/*    */ package com.vcredit.starter.log.interceptor;
/*    */ 
/*    */ import org.slf4j.MDC;
/*    */ 
/*    */ public class SleuthLogRequestHandler
/*    */   implements LogRequestHandler
/*    */ {
/*    */   public String trace()
/*    */   {
/* 11 */     return MDC.get("X-B3-TraceId");
/*    */   }
/*    */ 
/*    */   public String span()
/*    */   {
/* 16 */     return MDC.get("X-B3-SpanId");
/*    */   }
/*    */ 
/*    */   public String parent()
/*    */   {
/* 21 */     return MDC.get("X-B3-ParentSpanId");
/*    */   }
/*    */ 
/*    */   public String service()
/*    */   {
/* 26 */     return MDC.get("springAppName");
/*    */   }

    @Override
    public String otherInfo() {
        return null;
    }
    /*    */ }

