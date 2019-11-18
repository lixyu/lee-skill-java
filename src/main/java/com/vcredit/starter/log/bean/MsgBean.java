/*    */ package com.vcredit.starter.log.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class MsgBean extends HashMap<String, Object>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2735567932041924087L;
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 13 */     if (o == this) return true; if (!(o instanceof MsgBean)) return false; MsgBean other = (MsgBean)o; if (!other.canEqual(this)) return false; return super.equals(o); } 
/* 13 */   protected boolean canEqual(Object other) { return other instanceof MsgBean; } 
/* 13 */   public int hashCode() { return super.hashCode(); } 
/* 14 */   public String toString() { return "MsgBean()";
/*    */   }
/*    */ }
