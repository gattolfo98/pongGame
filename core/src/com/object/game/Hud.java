/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object.game;

import Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 *
 * @author gattolfo
 */
public class Hud extends Stage{

    protected GameScreen gameScreen;
    protected Label playerPoint1;
    protected Label playerPoint2;
    protected Label spacer;
    protected Table table;
    protected ScreenViewport viewport;
    protected final int SPACE_TOP = 20;
    protected final float FONT_DIM = 4f;
    public Hud(GameScreen gameScreen, SpriteBatch batch ,ScreenViewport viewport ){
        
        super(viewport,batch);
        this.viewport = viewport;
        this.setViewport(viewport);
        
        this.gameScreen = gameScreen;
        
        table = new Table();
        table.top();
        table.setFillParent(true);
        
        BitmapFont bt = new BitmapFont(Gdx.files.internal("HudPMF.fnt"));
        
        
        playerPoint1 = new Label(Integer.toString(gameScreen.getPlayer().getScore()),new Label.LabelStyle(bt,Color.WHITE));
        //playerPoint1.setFontScale(FONT_DIM);
        playerPoint1.scaleBy(30f);
        playerPoint2 = new Label(Integer.toString(gameScreen.getPlayerAI().getScore()),new Label.LabelStyle(bt,Color.WHITE));
        //playerPoint2.setFontScale(FONT_DIM);
        spacer = new Label(" : ",new Label.LabelStyle(bt,Color.WHITE));
        //spacer.setFontScale(FONT_DIM);
        
        table.add(playerPoint1).center().padTop(SPACE_TOP).padRight(20);
        table.add(spacer).center().padTop(SPACE_TOP);
        table.add(playerPoint2).center().padTop(SPACE_TOP).padLeft(20);
        
        this.addActor(table);
        
    }
    public void update(){
        playerPoint1.setText(Integer.toString(gameScreen.getPlayer().getScore()));
        playerPoint2.setText(Integer.toString(gameScreen.getPlayerAI().getScore()));
    }
    
    public void resize(int width, int height){
        viewport.update(width, height);
        
    }

}
