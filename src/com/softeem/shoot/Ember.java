/*    */ package com.softeem.shoot;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ember
/*    */ {
/* 10 */   private BufferedImage[] images = new BufferedImage[0];
/*    */   private int index;
/*    */   private int i;
/*    */   private BufferedImage image;
/* 14 */   private int intevel = 10; private int x;
/*    */   
/*    */   public Ember(FlyingObject object) {
/* 17 */     this.images = object.ember;
/* 18 */     this.image = object.image;
/* 19 */     this.x = object.x;
/* 20 */     this.y = object.y;
/* 21 */     this.index = 0;
/* 22 */     this.i = 0;
/*    */   }
/*    */   private int y;
/*    */   public boolean burnDown() {
/* 26 */     this.i++;
/* 27 */     if (this.i % this.intevel == 0) {
/* 28 */       if (this.index == this.images.length) {
/* 29 */         return true;
/*    */       }
/* 31 */       this.image = this.images[this.index++];
/*    */     } 
/* 33 */     return false;
/*    */   }
/*    */   
/* 36 */   public int getX() { return this.x; }
/*    */ 
/*    */   
/* 39 */   public int getY() { return this.y; }
/*    */ 
/*    */   
/* 42 */   public BufferedImage getImage() { return this.image; }
/*    */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\Ember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */