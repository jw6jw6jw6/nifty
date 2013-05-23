package jw6jw6jw6.CombatSimulator.main;

import jw6jw6jw6.CombatSimulator.objects.Ball;
import jw6jw6jw6.CombatSimulator.objects.Block;
import jw6jw6jw6.CombatSimulator.objects.Paddle;

public class Physics
{
	public static boolean collidesInBox(Paddle a, Ball b, float sideLength)
	{
		if(Math.abs(a.getX() - b.getX()) <= 32 && b.getY() - a.getY() <= 8 && b.getY() - a.getY() >0)
			return true;
		return false;
	}
	
	public static boolean collidesInBox1(GameObject object, Ball b)
	{
		if(Math.abs(object.getX() - b.getX()) <= 12 && Math.abs(object.getY() - b.getY()) <= 4)
			return true;
		return false;
	}
}