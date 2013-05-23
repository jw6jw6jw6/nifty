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
	private int count = 0;
//	public static ArrayList<Block> addObjectNextTick = new ArrayList<GameObject>();
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
		ships.add(ball);
		float tmpy = Display.getHeight() - 2;
		int count = 0;
		for(int q = 8; q>0; q--)
		{
			count++;
			for(float tmpx=14; tmpx <= 784; tmpx+=16)
				objects.add(new Block(tmpx, tmpy-(8*count), q));
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
		if(pause)
			return;
		
		if(Physics.collidesInBox(player1, ball, 16f))
		{
			ball.paddleFlipDirection();
		}
		
		for(Block object: objects)
			if(Physics.collidesInBox1(object,ball))
			{
				ball.flipDirection();
				object.damage -=1;
			}
		
		super.runTick(time);
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
