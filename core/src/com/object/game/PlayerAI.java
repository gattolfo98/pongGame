/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object.game;

import Screens.GameScreen;

/**
 *
 * @author gattolfo
 */
public class PlayerAI extends PlayerPaddle{
    
    public PlayerAI(float x, float y, GameScreen gs) {
        super(x, y, gs);
        speed = 7;
    }
    
    
    @Override
    public void update(){
        super.update();
        
        //inteligenza artificiale uuuuuuuuuuuuuuu
        
        Ball ball = gameScreen.getBall();
        
        if(ball.getY()> y+ height-(height/4))
            vely = 1;
        else if(ball.getY()< y +(height/4) )
            vely = -1;
        
        //System.out.println(speed);
        body.setLinearVelocity(0, vely *speed);
        
    }
    
    
}
