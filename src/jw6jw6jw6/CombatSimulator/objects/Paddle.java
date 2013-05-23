package jw6jw6jw6.CombatSimulator.objects;

import static org.lwjgl.opengl.GL11.*;
import jw6jw6jw6.CombatSimulator.main.GameObject;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Paddle extends GameObject
{
	public Paddle(float x, float y,int id)
	{
		super(x, y);
	}
	
	public float getmaxSpeed()
	{
		return maxSpeed;
	}
	
	protected float velX = 0, velY = 0;
	protected float direction = 0;
	protected float speedIncrement = .3f;
	protected float maxSpeed = 4f;
	protected int health = 100;
	protected int id;
	
	public void runTick(long time)
	{
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glTranslatef(x, y, 0);
			glColor3f(1,0,1);
			glRotatef(direction, 0, 0, 1);
			glBegin(GL_TRIANGLES);
			{
				glColor3f(1,0,0);
				glVertex3f(-10,10,0);
				glVertex3f(10,0,0);
				glVertex3f(-5,0,0);
				
				glColor3f(1,0,0);
				glVertex3f(-10,-10,0);
				glVertex3f(10,0,0);
				glVertex3f(-5,0,0);	
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public float getDirection()
	{
		return direction;
	}
}
