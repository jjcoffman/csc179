package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	Moveable
 * Purpose: an Abstract class that contains has all of the variables and methods needed by objects of type moveable.
 * 
 *****************************************************************************************************************************/
import java.awt.Color;

abstract class Moveable
{
	//declare private variables
	private float heading;
	private float speed;
	private Location location;
	private Color color;
	private static double pi = 3.141592654; //declare a constant for pi.
	
	//constructors.
	public Moveable()
	{
		heading = 0;
		speed = 0;
		location = new Location();
		color = Color.BLACK;
	}
	public Moveable(float h, float s)
	{
		heading = h;
		speed = s;
		location = new Location();
		color = Color.BLACK;
	}
	
	//move() moves the object in the direction  of the heading and applies speed to it then assigns that value to the new location. we must covert to radians first however.
	public void move()
	{
		//this keeps the heading withi 0 and 360
		if(heading > 360)
			heading = heading -360;
		if(heading < 0)
			heading = 360 + heading; 
		
		//here we update the location after using cosine and sine after converting to radians due to the built in Math methods requirements
		//for radians. we then multiply be the speed and adjust x. We also pass the moveable pbject with this information to "unlock" the method
		//in location. This keeps the locations from changing in Fixed object types.
		location.setX((float)(location.getX() + (Math.cos((90 - heading)*(pi/180)) * speed)), this);
		location.setY((float)(location.getY() + (Math.sin((90 - heading)*(pi/180)) * speed)), this);
	}
	
	//accessors and mutators that are common to the moveable type objects
	public void setHeading(float h)
	{
		heading = h;
	}
	public float getHeading()
	{
		return heading;
	}
	public void setSpeed(float s)
	{
		speed = s;
	}
	public float getSpeed()
	{
		return speed;
	}
	public void setLocation(float x, float y)
	{
		location.setX(x, this);
		location.setY(y, this);
	}
	public Location getLocation()
	{
		return location;
	}
	public void setColor(float r, float g, float b)
	{
		color = new Color(r,g,b);
	}
	public Color getColor()
	{
		return color;
	}
	
	//override the object class's toString method.
	public String toString()
	{
		return(location.toString() + " color=[" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "] ");
	}
	
}
