/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.asteroids.game.Astro;
import com.asteroids.game.GameContactListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.helper.game.Constant;
import com.object.game.Ball;
import com.object.game.Hud;
import com.object.game.Player;
import com.object.game.PlayerAI;
import com.object.game.PlayerPaddle;
import com.object.game.Wall;

/**
 *
 * @author gattolfo
 */
public class GameScreen extends ScreenAdapter{
    protected Game game;
    //camera
    protected OrthographicCamera cam;
    protected SpriteBatch batch;
    //mondo2d
    protected World wd;
    
    //debug
    protected Box2DDebugRenderer bdRenderer;
    
    //player atttivo
    private PlayerPaddle player;
    //player passivo (AI)
    private PlayerPaddle playerAI;
    //ball
    public Ball ball;
    //wall
    private Wall wallUp,wallDown;
    
    
    //contatti
    private GameContactListener gtl;
    
    //UI
    Hud ui;
    //suoni
    static Sound pogSound;
    static Sound winSound;
    //gestione del gioco
    public static int state;

    public GameScreen(OrthographicCamera cam, Game game){
        this.game = game;
        //camera
        this.cam = cam;
        this.cam.position.set(new Vector3(Astro.WIDTH/2,Astro.HEIGHT/2,0));
        batch = new SpriteBatch();
        
        //mondo per gli oggetti 2d
        wd = new World(new Vector2(0,0),false);
        
        //debug renderer 
        bdRenderer = new Box2DDebugRenderer();
         
        //player
        player = new Player(6,Astro.HEIGHT/2, this);
        //player AI
        playerAI = new PlayerAI(Astro.WIDTH-6,Astro.HEIGHT/2, this);
        //ball

        
        this.ball = new Ball(this);
        //wall
        wallDown = new Wall(0,this);
        wallUp = new Wall(Astro.HEIGHT , this);
        
        //gtl
        gtl = new GameContactListener(this);
        wd.setContactListener(gtl);
        //UI
        ui = new Hud(this,batch, new ScreenViewport());
        //suono
        pogSound = Gdx.audio.newSound(Gdx.files.internal("pong.wav"));
        winSound = Gdx.audio.newSound(Gdx.files.internal("win.wav"));
        state = Constant.GAME_RUNNING;
        
    }
    
    private void update(){
        wd.step(1/60f,6,2);
        
        player.update();
        playerAI.update();
        ball.update();
        ui.update();
        this.cam.update();

        

        //controllo input
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            dispose();
            game.setScreen(new MenuScreen(cam,game));
        }
        
    }
    
    @Override
    public void render(float delta ){
        batch.setProjectionMatrix(cam.combined);
        update();
        
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
            presentGame();  
        batch.end();

        batch.setProjectionMatrix(ui.getCamera().combined);
        ui.act(delta);
        ui.draw();

        
        //testttt
        
        
        
        //System.out.println(Gdx.graphics.getFramesPerSecond());
        
        //this.bdRenderer.render(wd, cam.combined.scl(Constant.PPM));
    }
    //se il gioco è in RUNNING
    protected void presentGame(){
        player.render(batch);
        playerAI.render(batch);
        ball.render(batch);
        wallUp.render(batch);
        wallDown.render(batch);
    }
    //getter
    public World getWorld(){
        return wd;
    }
    
    public Ball getBall(){
        return ball;
    }
    
    public PlayerPaddle getPlayer(){
        return player;
    }
    
    public PlayerPaddle getPlayerAI(){
        return playerAI;
    }
    
    @Override
    public void resize(int width, int height) {
      
    }
    
    public static void playPog(){
        pogSound.play(0.5f);
    }
    
    public static void playWin(){
        winSound.play(0.5f);
    }
  
    @Override
  public void dispose(){
      pogSound.dispose();
      wd.dispose();
      ui.dispose();
      
  }
  
 
}
