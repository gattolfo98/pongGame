package com.asteroids.game;

import Screens.GameScreen;
import Screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public final class Astro extends Game {

    public static int WIDTH;
    public static int HEIGHT;
    
    //camera
    protected static OrthographicCamera cam;
    private static Game game;
    
    public Astro(){
        game = this;
    }
    @Override
    public void create() {
        
        //settaggi
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        
        //xcamera
        cam = new OrthographicCamera(WIDTH,HEIGHT);
        cam.translate(WIDTH/2, WIDTH/2);
        cam.update();
        
        //setScreen(new GameScreen(cam)); 
        setScreen(new MenuScreen(cam,this)); 
        
    }
    
    @Override
    public void render(){
        super.render();
    }
    

}
