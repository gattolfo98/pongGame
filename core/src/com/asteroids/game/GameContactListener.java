/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asteroids.game;

import Screens.GameScreen;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.helper.game.ContactType;



/**
 *
 * @author gattolfo
 */
public class GameContactListener implements ContactListener{
    
    private GameScreen gameScreen;

    public GameContactListener(GameScreen gs){
        this.gameScreen = gs;
        
    }
    @Override
    public void beginContact(Contact cntct) {
        Fixture a = cntct.getFixtureA();
        
        Fixture b = cntct.getFixtureB();
        
        if(a == null || b == null)return;
        if(a.getUserData()== null|| b.getUserData() == null)return;
        
        if(a.getUserData() == ContactType.BALL ||b.getUserData() == ContactType.BALL ){
            
            if(a.getUserData() == ContactType.PLAYER || b.getUserData() == ContactType.PLAYER){
                gameScreen.getBall().reverseVelx();
                gameScreen.getBall().difPlus();
            }
            if(a.getUserData() == ContactType.WALL || b.getUserData() == ContactType.WALL){
                gameScreen.getBall().reverseVely();
            }
            
            GameScreen.playPog();
        }
            
        
    }

    @Override
    public void endContact(Contact cntct) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preSolve(Contact cntct, Manifold mnfld) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postSolve(Contact cntct, ContactImpulse ci) {
        //To change body of generated methods, choose Tools | Templates.
    }
    

}
