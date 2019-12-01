/*    */ package com.softeem.shoot;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class BigPlane
/*    */   extends FlyingObject implements Enemy, Award {
/*  7 */   private int speed = 1;
/*    */   private int life;
/*    */   private int awardType;
/*    */   
/*    */   public BigPlane() {
/* 12 */     this.life = 4;
/* 13 */     this.image = ShootGame.bigPlane;
/* 14 */     this.ember = ShootGame.bigPlaneEmber;
/* 15 */     this.width = this.image.getWidth();
/* 16 */     this.height = this.image.getHeight();
/* 17 */     this.y = -this.height;
/* 18 */     Random rand = new Random();
/* 19 */     this.x = rand.nextInt(400 - this.width);
/* 20 */     this.awardType = rand.nextInt(2);
/*    */   }
/*    */ 
/*    */   
/* 24 */   public int getType() { return this.awardType; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   public int getScore() { return 50; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public boolean outOfBounds() { return false; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   public void step() { this.y += this.speed; }
/*    */ 
/*    */   
/*    */   public boolean shootBy(Bullet bullet) {
/* 54 */     if (super.shootBy(bullet)) {
/* 55 */       this.life--;
/*    */     }
/* 57 */     return (this.life == 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\BigPlane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */