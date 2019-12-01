/*    */ package com.softeem.shoot;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Bullet
/*    */   extends FlyingObject
/*    */ {
/*  8 */   private int speed = 3;
/*    */   
/*    */   public Bullet(int x, int y) {
/* 11 */     this.x = x;
/* 12 */     this.y = y;
/* 13 */     this.image = ShootGame.bullet;
/*    */   }
/*    */   private boolean bomb;
/*    */   
/* 17 */   public void setBomb(boolean bomb) { this.bomb = bomb; }
/*    */ 
/*    */ 
/*    */   
/* 21 */   public boolean isBomb() { return this.bomb; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 26 */   public void step() { this.y -= this.speed; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   public boolean outOfBounds() { return (this.y < -this.height); }
/*    */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\Bullet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */