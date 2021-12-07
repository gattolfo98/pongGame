/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object.game;

import Screens.GameScreen;
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
public class PlayerPaddle {
    protected Body body;
    protected float x,y, speed, vely,velx;
    protected int width, height;
    int score;
    protected Texture texture;
    protected GameScreen gameScreen;
    public PlayerPaddle(float x, float y, GameScreen gs){
        this.score = 0;
        this.x = x;
        this.y = y;
        this.gameScreen = gs;
        this.speed = 6;
        this.width = 18;
        this.height = 276;
        this.texture = new Texture("aster.png");
        this.body = BodyHelper.createBody(x, y, width, height, false, 100000,gameScreen.getWorld() , ContactType.PLAYER,1);
    }
    
    public void update(){
        x = body.getPosition().x * Constant.PPM - (width/2);
        y = body.getPosition().y * Constant.PPM - (height/2);
        velx = 0;
        
        
    }
    
    public void render (SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
        
    }
    
    public void score(){
       this.score++; 
    }
    
    public int getScore(){
        return score;
    }
}
