package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	OilSlicks
 * Purpose: The OilSlicks object has attributes of width and length. it impacts the cars ability to turn.
 * 
 *****************************************************************************************************************************/
class OilSlicks extends Fixed
{
	//declare our local varibles
	private float width;
	private float length;
	
	//constructors
	OilSlicks(float x, float y)
	{
		super(x,y); 
		width = 0;
		length = 0;
	}
	
	//accessors and mutators
	public float getWidth()
	{
		return width;
	}
	
	public void setWidth(float w)
	{
		width = w;
	}
	
	public float getLength()
	{
		return length;
	}
	
	public void setLength(float l)
	{
		length = l;
	}

	//override the Object Class's toString() method and utilized the parents toString method.
	public String toString()
	{
		return("OilSlick: "+ super.toString() +"width=" + (int)width + " length=" + (int)length);
	}

}
