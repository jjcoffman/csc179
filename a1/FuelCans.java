package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	FuelCans
 * Purpose: Fuel Cans refuel our car by running into them. they have a size which determines how much fuel is in them.
 * 
 * 
 *****************************************************************************************************************************/
class FuelCans extends Fixed
{
	private float size; //corresponds to the amount of fuel this can contains
	
	//constructor
	public FuelCans(float x, float y)
	{
		super(x, y);
		size = 0;
	}
	
	//accessors and mutators
	public float getSize()
	{
		return size;
	}
	public void setSize(float r)
	{
		size = r;
	}
	
	//override the Object Class's toString() method and utilized the parents toString method.
	public String toString()
	{
		return("FuelCans: "+ super.toString() +"size=" + (int)size);
	}

}
