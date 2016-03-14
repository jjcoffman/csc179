package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	Bird
 * Purpose: Class that handles the Bird objects and its variables and fields. it extends the Moveable class and adds a size
 * 			variable. Accessors and mutators are the first methods followed by the toString method last.
 * 
 *****************************************************************************************************************************/


class Bird extends Moveable
{
	private float size;
	
	//constructor
	Bird()
	{
		super(); //call the Moveable constructor.
		size = 0;
	}
	
	//accessors and mutators.
	public void setSize(float s)
	{
		size = s;
	}
	public float getSize()
	{
		return size;
	}
	
	//override the Object Class's toString() method and utilized the parents toString method.
	public String toString()
	{
		return("Bird:     " + super.toString() + "heading=" + (int)this.getHeading() + " speed=" + (int)this.getSpeed() + " size=" + size);
	}
	
}
