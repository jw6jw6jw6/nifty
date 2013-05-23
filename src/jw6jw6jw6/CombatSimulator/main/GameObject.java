package jw6jw6jw6.CombatSimulator.main;

public abstract class GameObject extends Game
{
	protected float x, y;
	public boolean shouldBeUnloaded = false;
	
	public GameObject(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void render()
	{
	}
	
	public void runTick(long time)
	{
		super.runTick(time);
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public void setUnload(boolean unload)
	{
		shouldBeUnloaded = unload;
	}
	
	public boolean getUnload()
	{
		return shouldBeUnloaded;
	}
}
