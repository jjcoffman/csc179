package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	Fixed
 * Purpose: an Abstract class that contains has all of the variables and methods needed by objects of type Fixed.
 * 
 *****************************************************************************************************************************/
import java.awt.Color;

abstract class Fixed 
{
	//declare our private variables
	private Location location; //has-a location
	private Color color;//has-a color
	
	//constructors.
	public Fixed()
	{
		location = new Location();
		color = Color.BLACK;
	}
	public Fixed(float x1, float y1)
	{
		location = new Location(x1,y1);
		color = Color.BLACK;
	}
	
	
	//accessors and mutators.
	public Location getLocation() 
	{
		return location;
	}
	public Color getColor()
	{
		return color;
	}
	public void setColor(float r, float g, float b)
	{
		color = new Color(r,g,b);
	}
	public String toString()
	{
		return(location.toString() + " color=[" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "] ");
	}
}
