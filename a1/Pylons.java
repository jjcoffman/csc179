package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	Pylons
 * Purpose: Pylons are our games waypoints. They have attributes radius and sequenceNumber. Each pylon object makes up a 
 * 			waypoint on the track. 
 * 
 *****************************************************************************************************************************/
class Pylons extends Fixed
{
	//declare our private variables
	private float radius;
	private float sequenceNumber;
	
	//constructors
	public Pylons(float x, float y)
	{
		super(x, y);
		radius = 0;
		sequenceNumber = 0;
	}
	
	//Accessors and Mutators
	public float getRadius()
	{
		return radius;
	}
	public void setRadius(float r)
	{
		radius = r;
	}
	
	public float getSequenceNumber()
	{
		return sequenceNumber;
	}
	public void setSequenceNumber(float r)
	{
		sequenceNumber = r;
	}
	
	//override the Object Class's toString() method and utilized the parents toString method.
	public String toString()
	{
		return("Pylon:    " + super.toString() + "radius=" + (int)radius + " seqNum=" + (int)sequenceNumber);
	}
	
}
