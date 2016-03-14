package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	Car
 * Purpose: Manage the object known as car. It extends the class Moveable() and adds additional information needed to operate
 * 			the cars movement and control surfaces implemented by the interface ISteerable. 
 * 
 *****************************************************************************************************************************/

class Car extends Moveable //implements ISteerable
{

	//declare our class variables
	private float width, length, steeringDirection, maximumSpeed, fuelLevel, damageLevel;
	private boolean tractionFlag;
	
	
	//generic constructor
	public Car()
	{
		super();
		width = 0;
		length = 0;
		steeringDirection = 0;
		maximumSpeed = 50;
		fuelLevel = 100;
		damageLevel = 0;
		tractionFlag = true;
	}
	
	//these are our accessors and mutators for the object variables. it also inherits the superclass of Moveable and implemets the interface of ISteerable.
	public float getWidth() 
	{
		return width;
	}

	public void setWidth(float w) 
	{
		width = w;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float l) {
		length = l;
	}

	public float getSteeringDirection() {
		return steeringDirection;
	}

	public void setSteeringDirection(float sD) {
		steeringDirection = sD;
	}

	public float getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(float mS) {
		maximumSpeed = mS;
	}

	public float getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(float fL) {
		fuelLevel = fL;
	}

	public float getDamageLevel() {
		return damageLevel;
	}

	public void setDamageLevel(float dL) {
		damageLevel = dL;
	}
	
	public boolean getTractionFlag()
	{
		return tractionFlag;
	}
	
	public void setTractionFlag(boolean t)
	{
		tractionFlag = t;
	}
	
	
	//here are the methods from the steerable interface that manipulate out car variables based on the game world.
	
	//this increases the speed of the car by 5 units
	public void accelerate() 
	{
		this.setSpeed(this.getSpeed() + 5);
	}
	
	//this method turns the steeringDirection to the left, or (+)
	public void turnLeft() 
	{
			steeringDirection = steeringDirection + 5;
	}

	//this method turns the steeringDirection to the right, or (-)
	public void turnRight() 
	{
			steeringDirection = steeringDirection - 5;
	}

	//this method applies a brake by decreasing speed by 5 units
	public void applyBrake() 
	{
		this.setSpeed(this.getSpeed() - 5);
	}

	//this method applies a collision by adding the damage amount passed to it and then adjusts the maximum speed.
	public void collision(float d) 
	{
		damageLevel = damageLevel + d;
		maximumSpeed = (50*((100 - damageLevel)/100));
	}

	//override the Object Class's toString() method and utilized the parents toString method.
	public String toString()
	{
		return("Car:      "+ super.toString() + "heading=" + (int)this.getHeading() + " speed=" + this.getSpeed()
				+ " width=" + (int)width + " length=" + (int)length + "\n          maxSpeed=" + maximumSpeed + " steeringDirection=" 
				+ (int)steeringDirection + " fuelLevel=" + (int)fuelLevel + " damage=" + (int)damageLevel);
	}

}
