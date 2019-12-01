/*    */ package com.softeem.shoot;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Airplane
/*    */   extends FlyingObject
/*    */   implements Enemy
/*    */ {
/* 10 */   int speed = 2;
/*    */   
/*    */   public Airplane() {
/* 13 */     this.image = ShootGame.airplane;
/* 14 */     this.ember = ShootGame.airplaneEmber;
/* 15 */     this.width = this.image.getWidth();
/* 16 */     this.height = this.image.getHeight();
/* 17 */     this.y = -this.height;
/* 18 */     this.x = (int)(Math.random() * (400 - this.width));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   public int getScore() { return 5; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   public boolean outOfBounds() { return (this.y > 600); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void step() { this.y += this.speed; }
/*    */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\Airplane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */