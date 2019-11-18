/*    */ package com.vcredit.starter.log.config;
/*    */ 
/*    */ import org.springframework.boot.context.properties.ConfigurationProperties;
/*    */ 
/*    */ @ConfigurationProperties(prefix="vcredit.log")
/*    */ public class LogProperties
/*    */ {
/*    */   private String driver;
/*    */ 
/*    */   public String getDriver()
/*    */   {
/* 12 */     return this.driver;
/*    */   }
/*    */ 
/*    */   public void setDriver(String driver)
/*    */   {
/*  6 */     this.driver = driver; } 
/*  6 */   public boolean equals(Object o) { if (o == this) return true; if (!(o instanceof LogProperties)) return false; LogProperties other = (LogProperties)o; if (!other.canEqual(this)) return false; Object this$driver = getDriver(); Object other$driver = other.getDriver(); return this$driver == null ? other$driver == null : this$driver.equals(other$driver); } 
/*  6 */   protected boolean canEqual(Object other) { return other instanceof LogProperties; } 
/*  6 */   public int hashCode() { int PRIME = 59; int result = 1; Object $driver = getDriver(); return result * 59 + ($driver == null ? 43 : $driver.hashCode()); } 
/*  6 */   public String toString() { return "LogProperties(driver=" + getDriver() + ")";
/*    */   }
/*    */ }