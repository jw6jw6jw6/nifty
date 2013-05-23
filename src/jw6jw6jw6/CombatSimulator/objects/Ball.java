package jw6jw6jw6.CombatSimulator.objects;
import static org.lwjgl.opengl.GL11.*;
import jw6jw6jw6.CombatSimulator.main.GameObject;

import org.lwjgl.opengl.Display;

public class Ball extends GameObject
{
	protected float maxSpeed;
	public Paddle launchedBy;
	float velX=0,velY=0;
	
//	public Bullet(Ship ship)
	public Ball(float x, float y, float velX, float velY, float maxSpeed)
	{
		super(x, y);	
		this.velX = velX;
		this.velY = velY;
		this.maxSpeed = maxSpeed +8;
		this.launchedBy = launchedBy;
//		maxSpeed = .3f;
	}
	
	public void runTick(long time)
	{
//		x += maxSpeed*Math.cos(Math.toRadians(direction));
//		y += maxSpeed*Math.sin(Math.toRadians(direction));
		
		x += velX;
		y += velY;
		
		if(velX < -maxSpeed)
			velX = -maxSpeed;
		else if(velX > maxSpeed)
			velX = maxSpeed;
		
		if(velY < -maxSpeed)
			velY = -maxSpeed;
		else if(velY > maxSpeed)
			velY = maxSpeed;
		
		if(x < 0 || x > Display.getWidth())
			velX*=-1;
		if(y > Display.getHeight())
			velY*=-1;
		if(y < 0)
			shouldBeUnloaded = true;
	}
	
	public void flipDirection()
	{
		velY*=-1;
	}
	
	public void paddleFlipDirection()
	{
		velY=Math.abs(velY);
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glColor3f(1,0,0);
			glTranslatef(x,y,0);
			glBegin(GL_QUADS);
			{
				glVertex3f(-2,2,0);
				glVertex3f(-2,-2,0);
				glVertex3f(2,-2,0);
				glVertex3f(2,2,0);
				
			}
			glEnd();
		}
		glPopMatrix();
	}
}
