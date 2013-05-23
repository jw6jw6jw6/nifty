package jw6jw6jw6.CombatSimulator.objects;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;
import jw6jw6jw6.CombatSimulator.main.GameObject;

public class Block extends GameObject
{
	float damage;
	public Block(float x, float y, float damage)
	{
		super(x, y);
		this.damage = damage;
	}
	
	public void runTick(long time)
	{
		if(damage == 0)
			shouldBeUnloaded = true;
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glTranslatef(x,y,0);
			glColor3f(0,1,0);
			if(damage == 8)
				glColor3f(.8f,0,0);
			else
				if(damage == 7)
					glColor3f(1,0,0);
				else
					if(damage == 6)
						glColor3f(1,1,0);
					else
						if(damage == 5)
							glColor3f(.7f,1,0);
						else
							if(damage == 4)
								glColor3f(0,1,.4f);
							else
								if(damage == 3)
									glColor3f(0,1,.6f);
								else
									if(damage == 2)
										glColor3f(0,.5f,.8f);
									else
										if(damage == 1)
											glColor3f(0,0,1);
			glBegin(GL_QUADS);
			{
				glVertex3f(-7,-2,0);
				glVertex3f(-7,2,0);
				glVertex3f(7,2,0);
				glVertex3f(7,-2,0);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
}
