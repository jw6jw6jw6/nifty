package jw6jw6jw6.CombatSimulator.main;

import jw6jw6jw6.CombatSimulator.objects.Asteroids;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import java.util.Random;

public class Main
{
	public static Asteroids game = new Asteroids();
	public static boolean running = true;
	private static long lastSystemTime = System.currentTimeMillis();
	private static Random rand = new Random();
	private static int[][] stars = new int[80][2];
	
	public static void main(String args[])
	{
		initDisplay();
		initGL();
		init();
		while(!Display.isCloseRequested() && running)
		{
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			
			long currentTime = System.currentTimeMillis();
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
				running = false;
			//game calculate
			//game render
			game.runTick(currentTime-lastSystemTime);
			game.render();
			/*if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			{
			glColor3f(2f,0,0);
			glBegin(GL_QUADS);
			glVertex2f(15,47);
			glVertex2f(15,43);
			glVertex2f(19,43);
			glVertex2f(19,47);
			glEnd();
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_X))
			{
			glColor3f(0.5f,0.5f,1.0f);
			glBegin(GL_QUADS);
			glVertex2f(100,100);
			glVertex2f(100+200,100);
			glVertex2f(100+200,100+200);
			glVertex2f(100,100+200);
			glEnd();
			}*/
			
			lastSystemTime = currentTime;
			
			Display.update();
			Display.sync(game.getFrameRate());
		}
		exit();
	}
	
	private static void stars()
	{
		glPushMatrix();
		{
			glColor3f(1,1,1);
			glTranslatef(0,0,0);
			glBegin(GL_QUADS);
			{
//				glVertex3f(10,10,0);
//				glVertex3f(12,10,0);
//				glVertex3f(12,12,0);
//				glVertex3f(10,12,0);
//				for(int x=0;x<9;x++)
//				{
//					int x1 = rand.nextInt(800);
//					int y = rand.nextInt(600);
//					glVertex3f(x1,y,0);
//					glVertex3f(x1+2,y,0);
//					glVertex3f(x1+2,y+2,0);
//					glVertex3f(x1,y+2,0);	
//				}
				for(int q = 0; q<80; q++)
				{
					int x = stars[q][0];
					int y = stars[q][1];
					glVertex3f(x,y,0);
					glVertex3f(x+2,y,0);
					glVertex3f(x+2,y+2,0);
					glVertex3f(x,y+2,0);
				}
			}
			glEnd();
		}
		glPopMatrix();
	}

	private static void initDisplay() 
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(game.getSizeWidth(),game.getSizeHeight()));
			Display.create();
			Display.setVSyncEnabled(game.getVSync());
			Display.setTitle("Space Combat Simulator");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int x=0;x<80;x++)
		{
			int x1 = rand.nextInt(800);
			int y = rand.nextInt(600);
			stars[x][0] = x1;
			stars[x][1] = y;
		}
	}

	private static void initGL()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,Display.getWidth(),0,Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0,0,0,1);
		glDisable(GL_DEPTH_TEST);
	}

	private static void init()
	{
		//init game
		game.init();
	}

	private static void exit()
	{
		game.exit();
		Display.destroy();
	}

}
