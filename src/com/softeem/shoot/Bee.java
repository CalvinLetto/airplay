/*    */ package com.softeem.shoot;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Bee extends FlyingObject implements Award {
/*  6 */   private int xSpeed = 1;
/*  7 */   private int ySpeed = 2;
/*    */   private int awardType;
/*    */   
/*    */   public Bee() {
/* 11 */     this.image = ShootGame.bee;
/* 12 */     this.ember = ShootGame.beeEmber;
/* 13 */     this.width = this.image.getWidth();
/* 14 */     this.height = this.image.getHeight();
/* 15 */     this.y = -this.height;
/* 16 */     Random rand = new Random();
/* 17 */     this.x = rand.nextInt(400 - this.width);
/* 18 */     this.awardType = rand.nextInt(2);
/*    */   }
/*    */ 
/*    */   
/* 22 */   public int getType() { return this.awardType; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   public boolean outOfBounds() { return (this.y > 600); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void step() {
/* 32 */     this.x += this.xSpeed;
/* 33 */     this.y += this.ySpeed;
/* 34 */     if (this.x > 400 - this.width) {
/* 35 */       this.xSpeed = -1;
/*    */     }
/* 37 */     if (this.x < 0)
/* 38 */       this.xSpeed = 1; 
/*    */   }
/*    */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\Bee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */