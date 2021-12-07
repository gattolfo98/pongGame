/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object.game;

import com.asteroids.game.Astro;
import Screens.GameScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.helper.game.BodyHelper;
import com.helper.game.ContactType;

/**
 *
 * @author gattolfo
 */
public class Wall {
    private Body body;
    
    private float x,y;
    private int width,height;
    
    private Texture texture;
    
    public Wall(float y,GameScreen gs){
        
        this.x = Astro.WIDTH/2;
        this.y = y;
        this.width = Astro.WIDTH;
        this.height = 32;
        
        
        this.texture = new Texture("aster.png");
        this.body = BodyHelper.createBody(x, this.y, width, height, true, 0, gs.getWorld(), ContactType.WALL,1);
    }
    
    public void render(SpriteBatch batch){
        batch.draw(texture,x -(Astro.WIDTH/2) ,y -(height/2) ,width,height);
    }
}
