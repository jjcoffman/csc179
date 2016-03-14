package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	ISteerable
 * Purpose: To create an interface for steerable objects such as a car. This is purely to tell the objects that implement 
 * 			this interface what methods are required in that class.
 * 
 * 
 *****************************************************************************************************************************/
public interface ISteerable 
{
	void accelerate();
	void turnLeft();
	void turnRight();
	void applyBrake();
	void collision(float d);
	void enterOil();
	void exitOil();
}
