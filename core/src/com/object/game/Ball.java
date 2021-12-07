/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object.game;

import com.asteroids.game.Astro;
import Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.helper.game.BodyHelper;
import com.helper.game.Constant;
import com.helper.game.ContactType;

/**
 *
 * @author gattolfo
 */
public class Ball {
    
    private Body body;
    
    private float x,y,speed,velx,vely;
    private int width,height;
    
    private GameScreen gameScreen;
    private Texture texture;
    private final float startSpeed = 4;
    protected float waitTime = 0;
    protected float startTime = 0;
    
    public Ball(GameScreen gs){
        
        this.x = Astro.WIDTH/2;
        this.y = Astro.HEIGHT/2;
        this.speed = startSpeed;
        this.velx = getRandomDirection();
        this.vely = getRandomDirection();
        
        this.texture = new Texture("ball.png");
        this.gameScreen = gs;
        
        this.width = 64; this.height = 64;
        this.body = BodyHelper.createBody(x, y, width, height, false, 0, gameScreen.getWorld(), ContactType.BALL,0);
        startTime = Gdx.graphics.getDeltaTime();
        reset();
    }
    
    public void update(){
       
        
        x = body.getPosition().x * Constant.PPM - (width/2);
        y = body.getPosition().y * Constant.PPM - (height/2);
        
        this.body.setLinearVelocity(velx * speed, vely * speed);
        
        //score 
        if(x<-width){
            GameScreen.playWin();
            gameScreen.getPlayerAI().score();
            reset();
 
        }else if(x>Astro.WIDTH){
            GameScreen.playWin();
            gameScreen.getPlayer().score();
            reset();
        }
    }
    
    public void foo(){
        this.velx = getRandomDirection();
        this.vely = getRandomDirection();
        this.speed = startSpeed;
    }
    
    public void render(SpriteBatch batch){
        batch.draw(texture, x,y,width,height);
    }
    
    public void reverseVelx(){
        velx *= -1;
    }
    
    public void reverseVely(){
        vely *= -1;
    }
    
    public void difPlus(){
        speed *= 1.1f;
    }
    
    public void reset(){
        this.velx =0;
        this.vely =0;
        this.body.setTransform(Astro.WIDTH/2/Constant.PPM, Astro.HEIGHT/2/Constant.PPM, 0);

            new Thread(new Runnable() {
                 @Override
                 public void run() {
                     long time = System.currentTimeMillis();
                     while (System.currentTimeMillis() < time + 1000){}
                     Gdx.app.postRunnable(new Runnable() {
                         @Override
                         public void run() {
                             foo();
                         }
                     });
                 }
             }).start();
        
    }
    
   
    private float getRandomDirection(){
        return(Math.random()<0.5)? 1 : -1;
    }
    
    
    public float getY(){
        return y;
    }
    public float getX(){
        return x;
    }
}
