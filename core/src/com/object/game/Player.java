/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object.game;

import Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 *
 * @author gattolfo
 */
public class Player extends PlayerPaddle{

    public Player(float x, float y, GameScreen gameScreen){
        super(x,y,gameScreen);
        speed = 7;
    }
    
    @Override
    public void update(){
        super.update();
        
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            vely = 1;
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)|| Gdx.input.isKeyPressed(Input.Keys.S)){
            vely = -1;
        }else{
            vely =0;
        }
        
        body.setLinearVelocity(velx * speed, vely * speed);
    }
    

    
}
