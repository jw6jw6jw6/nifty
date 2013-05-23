package jw6jw6jw6.CombatSimulator.main;
import javax.swing.JOptionPane;
public class uni
{

	public static String ask(String string)
	{
		String temp=JOptionPane.showInputDialog(string);
		return temp;
	}

	public static void notify(String string)
	{
		JOptionPane.showMessageDialog(null,string);
	}

	public static int parse(String string)
	{
		return Integer.parseInt(string);
	}

	public static double parseo(Object num) 
	{
		return Double.parseDouble(num.toString());
	}

	public static String dialog(String[] possibilities, String message, String title)
	{
		Object s = JOptionPane.showInputDialog(null,message,title,JOptionPane.ERROR_MESSAGE, null, possibilities, null);
		return s.toString();

	}
}