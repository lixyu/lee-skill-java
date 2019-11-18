/*    */ package com.vcredit.starter.log.interceptor;
/*    */ 
/*    */ public abstract interface LogRequestHandler
/*    */ {
/*    */   public abstract String trace();
/*    */ 
/*    */   public abstract String span();
/*    */ 
/*    */   public abstract String parent();
/*    */ 
/*    */   public abstract String service();
/*    */ 
/*    */   public String otherInfo();
/*    */
/*    */ }
