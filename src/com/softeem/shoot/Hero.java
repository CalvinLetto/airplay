/*     */ package com.softeem.shoot;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Hero
/*     */   extends FlyingObject
/*     */ {
/*  14 */   protected BufferedImage[] images = new BufferedImage[0];
/*  15 */   protected int index = 0;
/*     */   
/*     */   private int doubleFire;
/*     */   
/*     */   private int life;
/*     */   
/*     */   public Hero() {
/*  22 */     this.life = 3;
/*  23 */     this.doubleFire = 0;
/*  24 */     this.image = ShootGame.hero0;
/*  25 */     this.ember = ShootGame.heroEmber;
/*  26 */     this.images = new BufferedImage[] { ShootGame.hero0, ShootGame.hero1 };
/*  27 */     this.width = this.image.getWidth();
/*  28 */     this.height = this.image.getHeight();
/*  29 */     this.x = 150;
/*  30 */     this.y = 400;
/*     */   }
/*     */ 
/*     */   
/*  34 */   public int isDoubleFire() { return this.doubleFire; }
/*     */ 
/*     */ 
/*     */   
/*  38 */   public void addDoubleFire() { this.doubleFire = 40; }
/*     */ 
/*     */ 
/*     */   
/*  42 */   public void setDoubleFire(int doubleFire) { this.doubleFire = doubleFire; }
/*     */ 
/*     */ 
/*     */   
/*  46 */   public void addLife() { this.life++; }
/*     */ 
/*     */ 
/*     */   
/*  50 */   public void subtractLife() { this.life--; }
/*     */ 
/*     */ 
/*     */   
/*  54 */   public int getLife() { return this.life; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(int x, int y) {
/*  61 */     this.x = x - this.width / 2;
/*  62 */     this.y = y - this.height / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  67 */   public boolean outOfBounds() { return !(this.x >= 0 && this.x <= 400 - this.width && this.y >= 0 && 
/*  68 */       this.y <= 600 - this.height); }
/*     */ 
/*     */   
/*     */   public Bullet[] shoot() {
/*  72 */     int xStep = this.width / 4;
/*  73 */     int yStep = 20;
/*  74 */     if (this.doubleFire > 0) {
/*  75 */       Bullet[] bullets = new Bullet[2];
/*  76 */       bullets[0] = new Bullet(this.x + xStep, this.y - yStep);
/*  77 */       bullets[1] = new Bullet(this.x + 3 * xStep, this.y - yStep);
/*  78 */       this.doubleFire -= 2;
/*  79 */       return bullets;
/*     */     } 
/*  81 */     Bullet[] bullets = new Bullet[1];
/*  82 */     bullets[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
/*  83 */     return bullets;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void step() {
/*  89 */     if (this.images.length > 0) {
/*  90 */       this.image = this.images[this.index++ / 10 % this.images.length];
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hit(FlyingObject other) {
/*  96 */     int x1 = other.x - this.width / 2;
/*  97 */     int x2 = other.x + other.width + this.width / 2;
/*  98 */     int y1 = other.y - this.height / 2;
/*  99 */     int y2 = other.y + other.height + this.height / 2;
/* 100 */     return (this.x + this.width / 2 > x1 && this.x + this.width / 2 < x2 && 
/* 101 */       this.y + this.height / 2 > y1 && 
/* 102 */       this.y + this.width / 2 < y2);
/*     */   }
/*     */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\Hero.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */