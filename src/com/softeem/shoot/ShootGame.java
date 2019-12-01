/*     */ package com.softeem.shoot;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShootGame
/*     */   extends JPanel
/*     */ {
/*     */   public static final int WIDTH = 400;
/*     */   public static final int HEIGHT = 600;
/*     */   private int state;
/*     */   public static final int START = 0;
/*     */   public static final int RUNNING = 1;
/*     */   public static final int PAUSE = 2;
/*     */   public static final int GAME_OVER = 3;
/*  30 */   private int score = 0;
/*     */   private Timer timer;
/*  32 */   private int intervel = 10;
/*     */   
/*     */   public static BufferedImage background;
/*     */   public static BufferedImage start;
/*     */   public static BufferedImage pause;
/*     */   public static BufferedImage gameover;
/*     */   public static BufferedImage bullet;
/*     */   public static BufferedImage airplane;
/*  40 */   public static BufferedImage[] airplaneEmber = new BufferedImage[4];
/*     */   public static BufferedImage bee;
/*  42 */   public static BufferedImage[] beeEmber = new BufferedImage[4];
/*     */   public static BufferedImage hero0;
/*     */   public static BufferedImage hero1;
/*  45 */   public static BufferedImage[] heroEmber = new BufferedImage[4];
/*     */   public static BufferedImage bigPlane;
/*  47 */   public static BufferedImage[] bigPlaneEmber = new BufferedImage[4];
/*     */   
/*  49 */   private FlyingObject[] flyings = new FlyingObject[0];
/*  50 */   private Bullet[] bullets = new Bullet[0];
/*  51 */   private Hero hero = new Hero();
/*  52 */   private Ember[] embers = new Ember[0];
/*     */   
/*     */   static  {
/*     */     try {
/*  56 */       background = ImageIO.read(ShootGame.class
/*  57 */           .getResource("background.png"));
/*  58 */       bigPlane = 
/*  59 */         ImageIO.read(ShootGame.class.getResource("bigplane.png"));
/*  60 */       airplane = 
/*  61 */         ImageIO.read(ShootGame.class.getResource("airplane.png"));
/*  62 */       bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
/*  63 */       bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
/*  64 */       hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
/*  65 */       hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
/*  66 */       pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
/*  67 */       gameover = 
/*  68 */         ImageIO.read(ShootGame.class.getResource("gameover.png"));
/*  69 */       start = 
/*  70 */         ImageIO.read(ShootGame.class.getResource("start.png"));
/*  71 */       for (int i = 0; i < 4; i++) {
/*  72 */         beeEmber[i] = ImageIO.read(
/*  73 */             ShootGame.class.getResource("bee_ember" + i + ".png"));
/*  74 */         airplaneEmber[i] = ImageIO.read(
/*  75 */             ShootGame.class.getResource("airplane_ember" + i + ".png"));
/*  76 */         bigPlaneEmber[i] = ImageIO.read(
/*  77 */             ShootGame.class.getResource("bigplane_ember" + i + ".png"));
/*  78 */         heroEmber[i] = ImageIO.read(
/*  79 */             ShootGame.class.getResource("hero_ember" + i + ".png"));
/*     */       } 
/*  81 */     } catch (Exception e) {
/*  82 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  88 */     g.drawImage(background, 0, 0, null);
/*  89 */     paintEmber(g);
/*  90 */     paintHero(g);
/*  91 */     paintBullets(g);
/*  92 */     paintFlyingObjects(g);
/*  93 */     paintScore(g);
/*  94 */     paintState(g);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  99 */   public void paintHero(Graphics g) { g.drawImage(this.hero.getImage(), this.hero.getX(), this.hero.getY(), null); }
/*     */ 
/*     */   
/*     */   public void paintEmber(Graphics g) {
/* 103 */     for (int i = 0; i < this.embers.length; i++) {
/* 104 */       Ember e = this.embers[i];
/* 105 */       g.drawImage(e.getImage(), e.getX(), e.getY(), null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void paintBullets(Graphics g) {
/* 111 */     for (int i = 0; i < this.bullets.length; i++) {
/* 112 */       Bullet b = this.bullets[i];
/* 113 */       if (!b.isBomb()) {
/* 114 */         g.drawImage(b.getImage(), b.getX() - b.getWidth() / 2, b.getY(), 
/* 115 */             null);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void paintFlyingObjects(Graphics g) {
/* 121 */     for (int i = 0; i < this.flyings.length; i++) {
/* 122 */       FlyingObject f = this.flyings[i];
/* 123 */       g.drawImage(f.getImage(), f.getX(), f.getY(), null);
/*     */     } 
/*     */   }
/* 126 */   Object a = new Object();
/*     */   
/*     */   public void paintScore(Graphics g) {
/* 129 */     int x = 10;
/* 130 */     int y = 25;
/* 131 */     Font font = new Font("SansSerif", 1, 14);
/* 132 */     g.setColor(new Color(3816251));
/* 133 */     g.setFont(font);
/* 134 */     g.drawString("SCORE:" + this.score, x, y);
/* 135 */     y += 20;
/* 136 */     g.drawString("LIFE:" + this.hero.getLife(), x, y);
/*     */   }
/*     */   
/*     */   public void paintState(Graphics g) {
/* 140 */     switch (this.state) {
/*     */       case 0:
/* 142 */         g.drawImage(start, 0, 0, null);
/*     */         break;
/*     */       case 2:
/* 145 */         g.drawImage(pause, 0, 0, null);
/*     */         break;
/*     */       case 3:
/* 148 */         g.drawImage(gameover, 0, 0, null);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 154 */     JFrame frame = new JFrame("Shoot Game");
/* 155 */     ShootGame game = new ShootGame();
/* 156 */     frame.add(game);
/* 157 */     frame.setSize(400, 600);
/* 158 */     frame.setAlwaysOnTop(true);
/* 159 */     frame.setDefaultCloseOperation(3);
/* 160 */     frame.setIconImage((new ImageIcon("images/icon.jpg")).getImage());
/* 161 */     frame.setLocationRelativeTo(null);
/* 162 */     frame.setVisible(true);
/*     */     
/* 164 */     game.action();
/*     */   }
/*     */ 
/*     */   
/*     */   public void action() {
/* 169 */     MouseAdapter l = new MouseAdapter()
/*     */       {
/*     */         public void mouseMoved(MouseEvent e) {
/* 172 */           if (ShootGame.this.state == 1) {
/* 173 */             int x = e.getX();
/* 174 */             int y = e.getY();
/* 175 */             ShootGame.this.hero.moveTo(x, y);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void mouseEntered(MouseEvent e) {
/* 181 */           if (ShootGame.this.state == 2) {
/* 182 */             ShootGame.this.state = 1;
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void mouseExited(MouseEvent e) {
/* 188 */           if (ShootGame.this.state != 3) {
/* 189 */             ShootGame.this.state = 2;
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void mouseClicked(MouseEvent e) {
/* 195 */           switch (ShootGame.this.state) {
/*     */             case 0:
/* 197 */               ShootGame.this.state = 1;
/*     */               break;
/*     */             case 3:
/* 200 */               ShootGame.this.flyings = new FlyingObject[0];
/* 201 */               ShootGame.this.bullets = new Bullet[0];
/* 202 */               ShootGame.this.hero = new Hero();
/* 203 */               ShootGame.this.score = 0;
/* 204 */               ShootGame.this.state = 0;
/*     */               break;
/*     */           } 
/*     */         }
/*     */       };
/* 209 */     addMouseListener(l);
/* 210 */     addMouseMotionListener(l);
/*     */     
/* 212 */     this.timer = new Timer();
/* 213 */     this.timer.schedule(new TimerTask()
/*     */         {
/*     */           public void run() {
/* 216 */             if (ShootGame.this.state == 1) {
/* 217 */               ShootGame.this.enterAction();
/* 218 */               ShootGame.this.stepAction();
/* 219 */               ShootGame.this.shootAction();
/* 220 */               ShootGame.this.bangAction();
/* 221 */               ShootGame.this.outOfBoundsAction();
/* 222 */               ShootGame.this.checkGameOverAction();
/* 223 */               ShootGame.this.emberAction();
/*     */             } 
/* 225 */             ShootGame.this.repaint();
/*     */           }
/*     */         }, 
/*     */         
/* 229 */         this.intervel, this.intervel);
/*     */   }
/*     */   
/*     */   private void emberAction() {
/* 233 */     Ember[] live = new Ember[this.embers.length];
/* 234 */     int index = 0;
/* 235 */     for (int i = 0; i < this.embers.length; i++) {
/* 236 */       Ember ember = this.embers[i];
/* 237 */       if (!ember.burnDown()) {
/* 238 */         live[index++] = ember;
/*     */       }
/*     */     } 
/* 241 */     this.embers = Arrays.copyOf(live, index);
/*     */   }
/* 243 */   int flyEnteredIndex = 0;
/*     */ 
/*     */   
/*     */   public void enterAction() {
/* 247 */     this.flyEnteredIndex++;
/* 248 */     if (this.flyEnteredIndex % 40 == 0) {
/* 249 */       FlyingObject obj = nextOne();
/* 250 */       this.flyings = Arrays.copyOf(this.flyings, this.flyings.length + 1);
/* 251 */       this.flyings[this.flyings.length - 1] = obj;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stepAction() {
/* 258 */     for (int i = 0; i < this.flyings.length; i++) {
/* 259 */       FlyingObject f = this.flyings[i];
/* 260 */       f.step();
/*     */     } 
/*     */ 
/*     */     
/* 264 */     for (int i = 0; i < this.bullets.length; i++) {
/* 265 */       Bullet b = this.bullets[i];
/* 266 */       b.step();
/*     */     } 
/* 268 */     this.hero.step();
/*     */   }
/*     */   
/* 271 */   int shootIndex = 0;
/*     */ 
/*     */   
/*     */   public void shootAction() {
/* 275 */     this.shootIndex++;
/* 276 */     if (this.shootIndex % 30 == 0) {
/* 277 */       Bullet[] bs = this.hero.shoot();
/* 278 */       this.bullets = Arrays.copyOf(this.bullets, this.bullets.length + bs.length);
/* 279 */       System.arraycopy(bs, 0, this.bullets, this.bullets.length - bs.length, 
/* 280 */           bs.length);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void bangAction() {
/* 286 */     for (int i = 0; i < this.bullets.length; i++) {
/* 287 */       Bullet b = this.bullets[i];
/* 288 */       bang(b);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void outOfBoundsAction() {
/* 294 */     int index = 0;
/* 295 */     FlyingObject[] flyingLives = new FlyingObject[this.flyings.length];
/* 296 */     for (int i = 0; i < this.flyings.length; i++) {
/* 297 */       FlyingObject f = this.flyings[i];
/* 298 */       if (!f.outOfBounds()) {
/* 299 */         flyingLives[index++] = f;
/*     */       }
/*     */     } 
/* 302 */     this.flyings = Arrays.copyOf(flyingLives, index);
/*     */     
/* 304 */     index = 0;
/* 305 */     Bullet[] bulletLives = new Bullet[this.bullets.length];
/* 306 */     for (int i = 0; i < this.bullets.length; i++) {
/* 307 */       Bullet b = this.bullets[i];
/* 308 */       if (!b.outOfBounds()) {
/* 309 */         bulletLives[index++] = b;
/*     */       }
/*     */     } 
/* 312 */     this.bullets = Arrays.copyOf(bulletLives, index);
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkGameOverAction() {
/* 317 */     if (isGameOver()) {
/* 318 */       this.state = 3;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGameOver() {
/* 324 */     int index = -1;
/* 325 */     for (int i = 0; i < this.flyings.length; i++) {
/* 326 */       FlyingObject obj = this.flyings[i];
/* 327 */       if (this.hero.hit(obj)) {
/* 328 */         this.hero.subtractLife();
/* 329 */         this.hero.setDoubleFire(0);
/* 330 */         index = i;
/*     */         
/* 332 */         Ember ember = new Ember(this.hero);
/* 333 */         this.embers = Arrays.copyOf(this.embers, this.embers.length + 1);
/* 334 */         this.embers[this.embers.length - 1] = ember;
/*     */       } 
/*     */     } 
/* 337 */     if (index != -1) {
/* 338 */       FlyingObject t = this.flyings[index];
/* 339 */       this.flyings[index] = this.flyings[this.flyings.length - 1];
/* 340 */       this.flyings[this.flyings.length - 1] = t;
/* 341 */       this.flyings = Arrays.copyOf(this.flyings, this.flyings.length - 1);
/*     */       
/* 343 */       Ember ember = new Ember(t);
/* 344 */       this.embers = Arrays.copyOf(this.embers, this.embers.length + 1);
/* 345 */       this.embers[this.embers.length - 1] = ember;
/*     */     } 
/* 347 */     return (this.hero.getLife() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bang(Bullet bullet) {
/* 352 */     int index = -1;
/* 353 */     for (int i = 0; i < this.flyings.length; i++) {
/* 354 */       FlyingObject obj = this.flyings[i];
/* 355 */       if (obj.shootBy(bullet)) {
/* 356 */         index = i;
/*     */         break;
/*     */       } 
/*     */     } 
/* 360 */     if (index != -1) {
/* 361 */       FlyingObject one = this.flyings[index];
/* 362 */       FlyingObject temp = this.flyings[index];
/* 363 */       this.flyings[index] = this.flyings[this.flyings.length - 1];
/* 364 */       this.flyings[this.flyings.length - 1] = temp;
/*     */       
/* 366 */       this.flyings = Arrays.copyOf(this.flyings, this.flyings.length - 1);
/*     */ 
/*     */       
/* 369 */       if (one instanceof Enemy) {
/* 370 */         Enemy e = (Enemy)one;
/* 371 */         this.score += e.getScore();
/*     */       } 
/*     */       
/* 374 */       if (one instanceof Award) {
/* 375 */         Award a = (Award)one;
/* 376 */         int type = a.getType();
/* 377 */         switch (type) {
/*     */           case 0:
/* 379 */             this.hero.addDoubleFire();
/*     */             break;
/*     */           case 1:
/* 382 */             this.hero.addLife();
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/* 388 */       Ember ember = new Ember(one);
/* 389 */       this.embers = Arrays.copyOf(this.embers, this.embers.length + 1);
/* 390 */       this.embers[this.embers.length - 1] = ember;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FlyingObject nextOne() {
/* 400 */     Random random = new Random();
/* 401 */     int type = random.nextInt(20);
/* 402 */     if (type == 0)
/* 403 */       return new Bee(); 
/* 404 */     if (type <= 2) {
/* 405 */       return new BigPlane();
/*     */     }
/* 407 */     return new Airplane();
/*     */   }
/*     */ }


/* Location:              C:\Users\letto\Desktop\飞机\学员作品3.jar!\com\softeem\shoot\ShootGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.2
 */