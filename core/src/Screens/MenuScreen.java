 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 *
 * @author gattolfo
 */
public class MenuScreen extends ScreenAdapter{
    private Stage stage;
    private Game game;
    private Table table;
    protected OrthographicCamera cam;
    protected TextButton startGameB;
    protected TextButton exitB;
    public MenuScreen(final OrthographicCamera cam,final Game game){
        this.game = game;
        this.cam = cam;
        stage = new Stage(new ScreenViewport(cam));
        table = new Table();
        table.setFillParent(true);
        
        
        //UI
        BitmapFont bt = new BitmapFont(Gdx.files.internal("HudPMF.fnt"));
        Skin skin = new Skin(Gdx.files.internal("skins/test.json"));
        //titolo gioco
        
        Label title = new Label(" PONG ",new Label.LabelStyle(bt,Color.WHITE));
        title.setAlignment(Align.center);
//        title.setY(Astro.HEIGHT*2/3);
//        title.setX(Astro.WIDTH/2);
        title.setWidth(300f);
        
        startGameB = new TextButton("play",skin);
        startGameB.addListener( new ClickListener() {              
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen( new GameScreen(cam,game) );
            };
        });
        exitB = new TextButton("exit", skin);
        exitB.addListener( new ClickListener() {              
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            };
        });
//        startGameB.setPosition((Astro.WIDTH*2/3)-10,Astro.WIDTH/2);
        
        table.add(title).fillX();
        table.row().pad(50, 0, 10, 0);
        table.add(startGameB).fillX();
        table.row();
        table.add(exitB).fillX();
        
        
        stage.addActor(table);   
        
        table.setDebug(false);
    }
    
    public void update(){
//        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
//            game.setScreen(new GameScreen(cam,game));
//        }
    }
    
    @Override
    public void render(float delta){
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    
    
    @Override
    public void show(){
        Gdx.input.setInputProcessor(stage);
    }
    
    @Override
    public void dispose(){
        stage.dispose();
    }
    
    @Override
    public void resize (int width, int height) {
	stage.getViewport().update(width, height, true);
    }
}
