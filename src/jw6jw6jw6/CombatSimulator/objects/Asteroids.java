package jw6jw6jw6.CombatSimulator.objects;

import java.util.ArrayList;
import java.util.Iterator;

import jw6jw6jw6.CombatSimulator.main.Game;
import jw6jw6jw6.CombatSimulator.main.GameObject;
import jw6jw6jw6.CombatSimulator.main.Main;
import jw6jw6jw6.CombatSimulator.main.Physics;
import jw6jw6jw6.CombatSimulator.main.Player;
import jw6jw6jw6.CombatSimulator.main.uni;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Asteroids extends Game
{
	private boolean pause = false;
	private Random rand = new Random();
	public static Player player1;
	public static Ball ball;
	private int lives = 3;
	public void init()
	{
		try 
		{
			Keyboard.create();
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
		}
//		f2 = new AIFollower(17,48,2);
//		ships.add(f2);
		player1 = new Player(Display.getWidth()/2, 50);
		ships.add(player1);
		ball = new Ball(Display.getWidth()/2, Display.getHeight()/2, rand.nextInt(5)+1, rand.nextInt(7)+5,12f);
		balls.add(ball);
		float tmpy = Display.getHeight() - 8;
		int count = 0;
		for(int q = 8; q>0; q--)
		{
			count++;
			for(float tmpx=14; tmpx <= 784; tmpx+=15)
				objects.add(new Block(tmpx, tmpy-(12*count), q));
		}
		System.out.println(objects.size());
	}

	private static long timer5 = 500;

	
	public void runTick(long time)
	{
		timer5+=time;
		if(Keyboard.isKeyDown(Keyboard.KEY_P) && timer5 >300)
		{
			if(pause)
				pause = false;
			else
				pause = true;
			timer5=0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R))
		{
			balls.add(new Ball(Display.getWidth()/2, Display.getHeight()/2, rand.nextInt(5)+1, rand.nextInt(7)+5,12f));
		}
		
		if(pause)
			return;
		for(Ball ball1: balls)
		if(Physics.collidesInBox(player1, ball1, 16f))
		{
			ball1.paddleFlipDirection();
		}
		for(Ball ball1: balls)
		for(Block object: objects)
			if(Physics.collidesInBox1(object,ball1))
			{
				ball1.flipDirection();
				object.damage -=1;
				System.out.println("Block Collision");
			}
		for(Ball ball1:balls)
			ball1.runTick(time);
		super.runTick(time);
		if(ball.shouldBeUnloaded && lives >=0)
		{
			lives--;
			ball = new Ball(Display.getWidth()/2, Display.getHeight()/2, rand.nextInt(5)+1, rand.nextInt(7)+5,12f);
			balls.add(ball);
			
		}
	}
	
	public void render()
	{
		super.render();
		
		for(GameObject object : ships)
			object.render();
	}
	
	public void exit()
	{
		Keyboard.destroy();
		super.exit();
	}
}
