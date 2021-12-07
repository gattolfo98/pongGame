/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author gattolfo
 */
public class BodyHelper {
    
    public static Body createBody(float x, float y, float width,float height, boolean isStatic,float density, World world ,ContactType typeC,int shapeType){
        BodyDef bd = new BodyDef();
        bd.type = isStatic == false ? BodyDef.BodyType.DynamicBody : BodyDef.BodyType.StaticBody;
        bd.position.set(x/ Constant.PPM,y / Constant.PPM);
        bd.fixedRotation= true;
        Body body = world.createBody(bd);
        

        FixtureDef fxDef = new FixtureDef();
        fxDef.shape = returnShape(shapeType,width,height);
        fxDef.density = density;
        body.createFixture(fxDef).setUserData(typeC);
        
        
        return body;
    }
    
    private static  Shape returnShape(int type,float width,float height){
        if(type == 0){
            CircleShape shape = new CircleShape();
            shape.setRadius(width/2/Constant.PPM);
                    return shape;
        }else if(type == 1){
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(width/2 /Constant.PPM, height / 2 /Constant.PPM );
                    return shape;
        }
        return null;
    }
}
