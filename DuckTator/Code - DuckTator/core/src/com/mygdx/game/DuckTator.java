package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Screens.MenuScreen;


//*******************************************************************
//DuckTator
//
//URL: https://moorhengames.wordpress.com/play-game/
//*******************************************************************


//Extending Game - so we can access the setScreen class.
public class DuckTator extends Game {
	//SpriteBatch is a CONTAINER that contains all our images
	//When rendering the spritebatch spills them and renders all. Just need one for the entire game.
	//This is because they're memory intensive.
	public SpriteBatch batch;

	//These are our virtual width and virtual height.
	public static final int V_WIDTH = 1024;
	public static final int V_HEIGHT = 512;
	
	//PPM = Pixels per meter. Box2d is simulating physics using meters, kilograms and seconds. If we created an
	//object of size 5, this would be 5m in the physics world. We scale everything so 1 meter is 100 pixels.
	public static final float PPM = 100;
	
	
	
	
	//*****FILTER BITS*****
	//Using powers of 2, as libgdx requires. These filter bits are used to detect collisions. The Box2D representation of
	//Morgan (the duck) has a category bit of 2. This just means we can always tell when morgan is colliding with something,
	//also allows us to define WHAT morgan and other fixtures can collide with.
	public static final short GROUND_BIT = 1;
	public static final short DUCK_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short FEATHER_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short ENEMY_BIT = 32;
	public static final short ENEMY_HEAD = 64;
	public static final short GROUND_OBJECT = 128;
	public static final short SPIKE_BIT = 256;
	public static final short BOMB_BIT = 512;
	public static final short CAGE_BIT = 1024;
	public static final short STOPPER_BIT = 2048;
	public static final short WATER_BIT = 4096;
	
	//Our super powers. Initially regeneration is false, once James college is completed this boolean can be set to 
	//true allowing for the key press of r to regenerate health.
	public static boolean REGENERATION = false;
	
	//These booleans determine what levels are going to be unlocked on the world map.
	public static boolean JAMES_UNLOCKED = true;
	public static boolean SPORTVILLAGE_UNLOCKED = false;
	public static boolean LIBRARY_UNLOCKED = false;
	public static boolean MARKET_UNLOCKED = false;
	public static boolean RONCOOK_UNLOCKED = false;
	public static boolean CENTRAL_UNLOCKED = false;
	public static boolean DERWENT_UNLOCKED = false;
	public static boolean HALIFAX_UNLOCKED = false;

	
	@Override
	public void create () {
		//We create our sprite batch which is going to be passed to all the other classes
		batch = new SpriteBatch();
		
		//Setting the screen to the MenuScreen
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		//This delegates the render method to whatever screen is active at the time.
		//We will initally delegate to the menu screen.
		super.render();
	}
	
	public void dispose(){
		getScreen().dispose();
		
	}
}
