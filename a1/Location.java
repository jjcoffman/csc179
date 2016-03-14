package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	Location
 * Purpose: To create a cartesian coordinate that corresponds to the objects that have a location(). it allows the ability to
 * 			get and set the locations.
 * 
 *****************************************************************************************************************************/
class Location 
{
	private float x;
	private float y;
	//this is the center of the object.
	
	//Constructors for Location
	public Location()
	{
		x = 0;
		y = 0;
	}
	public Location(float x1, float y1)
	{
		x = x1;
		y = y1;
	}
	
	//accessors and mutators
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
	
	public void setX(float i, Object o)
	{
		if(o instanceof Moveable)
			x = i;
	}
	public void setY(float i, Object o)
	{
		if(o instanceof Moveable)
			y = i;
	}
	//override the object class's toString method.
	public String toString()
	{
		return("loc=" + (int) x + "," + (int) y);
	}
}
