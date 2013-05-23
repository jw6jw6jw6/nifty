package jw6jw6jw6.CombatSimulator.main;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import jw6jw6jw6.CombatSimulator.objects.*;
public class Player extends Paddle
{
	private float velX = 0,velY = 0, speedIncrement = 9f, maxSpeed = 10f;
	public float health=100;
	public boolean boost = false;
	private float timer = 0;
	public Player(float x, float y) 
	{
		super(x, y,100);
	}
	
	
	public void runTick(long time)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			x -= speedIncrement;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			x += speedIncrement;
		}
		
		if(timer == 0)
		{
		if(velX < -maxSpeed)
			velX = -maxSpeed;
		else if(velX > maxSpeed)
			velX = maxSpeed;
		
		if(velY < -maxSpeed)
			velY = -maxSpeed;
		else if(velY > maxSpeed)
			velY = maxSpeed;
		}
		else
		{
			boost = false;
			timer--;
		}
		
		x += velX;
		y += velY;
		
		if(x < 12)
			x = 12;
		else if(x > Display.getWidth()-12)
			x = Display.getWidth()-12;
	
		if(y < 12)
			y = 12;
		else if(y > Display.getHeight()-12)
			y = Display.getHeight()-12;
		if(health == 0)
			shouldBeUnloaded=true;
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glTranslatef(x,y,0);
			glColor3f(1,1,0);
			glBegin(GL_QUADS);
			{
				glVertex3f(-30,-5,0);
				glVertex3f(-30,5,0);
				glVertex3f(30,5,0);
				glVertex3f(30,-5,0);
			}
			glEnd();
		}
		glPopMatrix();
		
		
	}
}
