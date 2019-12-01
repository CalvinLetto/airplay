/*    */ package com.softeem.shoot;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FlyingObject
/*    */ {
/*    */   protected int x;
/*    */   protected int y;
/*    */   protected int width;
/*    */   protected int height;
/*    */   protected BufferedImage image;
/*    */   protected BufferedImage[] ember;
/*    */   
/* 17 */   public int getX() { return this.x; }
/*    */ 
/*    */ 
/*    */   
/* 21 */   public void setX(int x) { this.x = x; }
/*    */ 
/*    */ 
/*    */   
/* 25 */   public int getY() { return this.y; }
/*    */ 
/*    */ 
/*    */   
/* 29 */   public void setY(int y) { this.y = y; }
/*    */ 
/*    */ 
/*    */   
/* 33 */   public int getWidth() { return this.width; }
/*    */ 
/*    */ 
/*    */   
/* 37 */   public void setWidth(int width) { this.width = width; }
/*    */ 
/*    */ 
/*    */   
/* 41 */   public int getHeight() { return this.height; }
/*    */ 
/*    */ 
/*    */   
/* 45 */   public void setHeight(int height) { this.height = height; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   public BufferedImage getImage() { return this.image; }
/*    */ 
/*    */ 
/*    */   
/* 54 */   public void setImage(BufferedImage image) { this.image = image; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean outOfBounds();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void step();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shootBy(Bullet bullet) {
/* 77 */     if (bullet.isBomb()) {
/* 78 */       return false;
/*    */     }
/* 80 */     int x = bullet.x;
/* 81 */     int y = bullet.y;
/* 82 */     boolean shoot = (this.x < x && x < this.x + this.width && this.y < y && y < this.y + this.height);
/* 83 */     if (shoot) {
/* 84 */       bullet.setBomb(true);
/*    */     }
/* 86 */     return shoot;
/*    */   }
/*    */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\FlyingObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */