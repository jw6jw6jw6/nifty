package jw6jw6jw6.CombatSimulator.main;

import java.util.ArrayList;
import java.util.Iterator;
import jw6jw6jw6.CombatSimulator.objects.*;

public abstract class Game
{
	public static ArrayList<Block> objects = new ArrayList<Block>();
	public ArrayList<GameObject> ships = new ArrayList<GameObject>();
	
	public void runTick(long time)
	{
		Iterator<Block> iterator = objects.iterator();
		while(iterator.hasNext())
		{
			Block object = iterator.next();
			if(object.shouldBeUnloaded)
			{
				iterator.remove();
				continue;
			}
			
			object.runTick(time);
		}
		
		Iterator<GameObject> iterator2 = ships.iterator();
		while(iterator2.hasNext())
		{
			GameObject object = iterator2.next();
			if(object.shouldBeUnloaded)
			{
				iterator2.remove();
				continue;
			}
			
			object.runTick(time);
		}
		
		
	}
	
	public void render()
	{
		for(GameObject object : objects)
			object.render();
		
		for(GameObject object : ships)
			object.render();
	}
	
	public void init()
	{
	}
	
	public void exit()
	{
	}
	
	public int getFrameRate()
	{
		return 60;
	}
	
	public int getSizeWidth()
	{
		return 800;
	}
	
	public int getSizeHeight()
	{
		return 600;
	}
	
	public boolean getVSync()
	{
		return true;
	}
}
