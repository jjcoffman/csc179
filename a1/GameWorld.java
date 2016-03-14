package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	GameWorld
 * Purpose: To act as the model that contains all the objects needed to run the program. this includes Cars, Pylons, 
 * 			FuelCans, OilSlicks, and Birds. These objects are manipulated using this class via the Game() class. 
 * 
 *****************************************************************************************************************************/
import java.util.ArrayList;
import java.util.Random;

class GameWorld //model
{
	//games objects and state variables
	private float clockTime, livesRemaining, lastPylon, turnLimit;
	private Car car;

	//Object array
	private ArrayList<Object> objects;


	public void initLayout()
	{
		//here I initialize our variables.
		livesRemaining = 3;
		lastPylon = 1;
		clockTime = 0;
		turnLimit = 40;


		//here I create out pylons with specific values and add them to the arraylist
		objects = new ArrayList<Object>(0);
		objects.add(new Pylons(100, 300));
		objects.add(new Pylons(200, 500));
		objects.add(new Pylons(555, 777));
		objects.add(new Pylons(555, 222));

		//create my car and set it to the first pylon and default values.
		car = new Car();
		resetCar();

		//here I set the sequence variable based on its arraylist position, then randomly assign a radius and a color.
		for(int i = 0; i < objects.size(); i++)
		{
			if(objects.get(i) instanceof Pylons)
			{
				Pylons p = (Pylons) objects.get(i);
				p.setSequenceNumber(i+1);
				p.setRadius((int)(Math.random() * 100)); //note: i use the random class a lot in order to find random numbers
				p.setColor(randGen(), randGen(), randGen()); //see randGen() method below
			}
		}

		//here we loop twice and make birds, oilslicks, and fuelcans with random variables, this assignment requires 2 of each so i use a for loop
		//in the future i might implement methods for each of these or a more detailed constructor in order to simplify the process for larger
		//quantities or variations in the quantities.
		for(int i = 0; i < 2; i++)
		{
			/* for Each of the below objects i make the object then add it to the arrayList after giving the object its attributes
			 * as outlined in the assignment guide. I use a method randGen() to elimiate some of the clutter and then use the Math
			 * class for random integers where needed that meet the max value requirement for each field (ie 360 for degrees)
			 */

			Bird bird = new Bird(); 
			bird.setColor(randGen(), randGen(), randGen());
			bird.setLocation((int)(Math.random() * 1000), (int)(Math.random() * 1000));
			bird.setHeading((int)(Math.random() * 360));
			bird.setSpeed((int)(Math.random() * 10));
			bird.setSize((int)(Math.random() * 10));
			objects.add(bird);


			OilSlicks oilSlicks = new OilSlicks((int)(Math.random() * 1000), (int)(Math.random()*1000));
			oilSlicks.setLength((int)(Math.random() * 100));
			oilSlicks.setWidth((int)(Math.random() * 100));
			oilSlicks.setColor(randGen(), randGen(), randGen());
			objects.add(oilSlicks);

			FuelCans fuelCans = new FuelCans((int)(Math.random() * 1000), (int)(Math.random() * 1000));
			fuelCans.setSize((int)(Math.random()*100));
			fuelCans.setColor(randGen(), randGen(), randGen());	
			fuelCans.setSize((int)(Math.random() * 50));
			objects.add(fuelCans);

		}	

	}

	//here I create our car object and assign it to the last pylon's location which is in the first position of the object array
	//then I set a color (random) and heading a speed to 0. For this assignment there is only one car so I do not add it to the ArrayList
	//I use a method so that i can reset the car if a life is lost.
	private void resetCar()
	{
		car.setLocation(((Pylons) objects.get((int)lastPylon-1)).getLocation().getX(), ((Pylons) objects.get((int)lastPylon-1)).getLocation().getY());
		car.setColor(randGen(), randGen(), randGen());
		car.setDamageLevel(0);
		car.setFuelLevel(100);
		car.setLength(100);
		car.setHeading(0);
		car.setSpeed(0);
		car.setWidth(50);
		car.setSteeringDirection(0);
		
	}

	//Here I check to see if the speed is less than 5 from the max, if so i add 5. if not, i make it the max
	public void accelerate()
	{
		if(car.getSpeed() <= (car.getMaximumSpeed() - 5))
			car.setSpeed(car.getSpeed() + 5);
		else
			car.setSpeed(car.getMaximumSpeed());
	}

	//here I check to see if the speed is greater than 5 away from 0 or "stopped" and if so, i slow by 5, if not i stop the car.
	public void brake() 
	{
		if(car.getSpeed() >= 5)
			car.setSpeed(car.getSpeed()-5);
		else
			car.setSpeed(0);
	}

	//this attempts to turn left depending on the 40 degree limitation in either direction after checking if the car has traction
	public void steerLeft()
	{
		if(car.getTractionFlag())
			if(turnLimit >= 0)
			{
				turnLimit = turnLimit - 5;
				car.turnLeft();
			}
	}

	//this attempts to turn right depending on the 40 degree limitation in either direction after checking if the car has traction.
	public void steerRight()
	{
		if(car.getTractionFlag())
			if(turnLimit <= 80)
			{
				turnLimit = turnLimit + 5;
				car.turnRight();
			}
	}

	//here I create a new oilSlick object and add it to the arrayList
	public void addOil()
	{
		OilSlicks oilSlicks = new OilSlicks((int)(Math.random() * 1000), (int)(Math.random()*1000));
		oilSlicks.setLength((int)(Math.random() * 100));
		oilSlicks.setWidth((int)(Math.random() * 100));
		oilSlicks.setColor(randGen(), randGen(), randGen());
		objects.add(oilSlicks);
	}

	//here I check if the car can withstand the collision. if it can i add damage via the Cars collision method. if it is totalled i alert the user.
	public void carCollision()
	{
		if(car.getDamageLevel() < 90) //car can withstand damage
		{
			car.collision(10);
			if(car.getSpeed() > car.getMaximumSpeed())  //adjust the max speed if needed
				car.setSpeed(car.getMaximumSpeed());
		}
		else
		{
			car.collision(10); //car cannot withstand damage
			livesRemaining--;
			resetCar(); //reset the car to the first pylon.
			System.out.println("Totalled! Lives Remaining: " +  (int)livesRemaining);	
		}	
	}

	public void pylonCollision(String pylonNumber)
	{
		if((lastPylon+1) == Float.parseFloat(pylonNumber)) 	//here i check if the pylon coliding with is greater than the last highest pylon
			for(int i = 0; i < objects.size();i++)  //for all the objects
			{
				if(objects.get(i) instanceof Pylons) //if they are pylons
				{
					if(((Pylons) objects.get(i)).getSequenceNumber() == Float.parseFloat(pylonNumber)) //if the pylon the car is colliding with exists.
					{
						lastPylon = Float.parseFloat(pylonNumber); //update the last pylon
					}
				}
			}
	}

	//per the assignment Specs. I am to remove a fuel can from the game that the car collided with. I assumed for this purpose that would be the first fuel can.
	public void fuelCollision()
	{
		boolean no = true; //for loop escape variable

		for(int i = 0; i < objects.size() && no == true; i++) 
		{
			if(objects.get(i) instanceof FuelCans)
			{
				car.setFuelLevel(car.getFuelLevel() + ((FuelCans) objects.get(i)).getSize()); //here i add the fuell
				if(car.getFuelLevel() >100) //here i make sure it is only at the max of 100
					car.setFuelLevel(100);

				objects.remove(i); //remove the fuelcan from the arraylist

				//here I create a new fuel can and add it to the arraylist.
				FuelCans n = new FuelCans((int)(Math.random() * 1000), (int)(Math.random()*1000));
				n.setSize((int)(Math.random()*100));
				n.setColor(randGen(), randGen(), randGen());	
				n.setSize((int)(Math.random() * 50));
				objects.add(n);
				no = false; //escape
			}
		}
	}

	//here I handle a bird collision. I test if the car can withstand the collision, if so i add the damage, if not i remove a life.
	public void birdCollision()
	{
		if(car.getDamageLevel() < 95)
		{
			car.collision(5); //update the max speed and the damage level
			if(car.getSpeed() > car.getMaximumSpeed())
				car.setSpeed(car.getMaximumSpeed());
		}
		else
		{
			car.collision(5);
			livesRemaining--;
			resetCar();
			System.out.println("Totalled! Lives Remaining: " +  (int)livesRemaining);
		}
	}
	public void enteredOil()
	{
		car.setTractionFlag(false); //changes traction to false for no traction
	}
	public void exitOil()
	{
		car.setTractionFlag(true); //returns traction to true for having traction.
	}

	//Here i use loops to step through the Arraylist of objects, test to see if they can have their color changed, then change it.
	public void newColors()
	{

		car.setColor(randGen(),randGen(),randGen()); //assign car new color
		for(int i = 0; i < objects.size(); i++)
		{
			if(objects.get(i) instanceof OilSlicks)
				((OilSlicks) objects.get(i)).setColor(randGen(),randGen(),randGen()); //assign each other object a new color except pylons
			else if(objects.get(i) instanceof Bird)
				((Bird) objects.get(i)).setColor(randGen(),randGen(),randGen());
			else if(objects.get(i) instanceof FuelCans)
				((FuelCans) objects.get(i)).setColor(randGen(),randGen(),randGen());	
		}

	}

	//clockTick() is the progression of time. it moves the car and birds, and causes time to increase.
	public void clockTick()
	{
		if(car.getTractionFlag()) //make sure the car has traction
		{
			car.setHeading(car.getHeading() + car.getSteeringDirection()); //update the heading if so
		}
		car.setSteeringDirection(0); //reset the steering direction
		car.move(); //move the car

		for(int i = 0; i < objects.size(); i++) //move all birds.
		{
			if(objects.get(i) instanceof Bird)
				((Bird) objects.get(i)).move();
		}
		car.setFuelLevel(car.getFuelLevel() - 5); //remove fuel
		clockTime++; //progress the clock

		if(car.getFuelLevel() <= 0) //check for fuel level and reset the car if empty.
		{
			livesRemaining--;
			resetCar();
			System.out.println("Out of Gas! Lives Remaining: " +  (int)livesRemaining);
		}

	}

	//here we display the number of lives, elapsed time, highest pylon number reached so far, the current fuel, and damage.
	public void display()
	{
		System.out.println("Number of Lives Left: " + (int)livesRemaining + 
				"\nElapsed Time: " + (int)clockTime + "\nHighest Pylon Reached: " + (int)lastPylon +
				"\nCurrent Fuel: " + (int)car.getFuelLevel() + "\nCurrent Damage: " + (int)car.getDamageLevel() + "\n\n");

	}

	//Map displays all the objects that are created in the game world
	public void map()
	{
		System.out.println(car.toString());
		for(int i = 0; i < objects.size(); i++)
		{
			System.out.println(objects.get(i).toString());
		}

		System.out.println("\n\n");
	}

	//return the number of lives remaining. used by Game for looping.
	public float getLives()
	{
		return livesRemaining;
	}

	//this is used to create random floats for colors. makes it easier to write color generating code.
	private float randGen()
	{
		Random rand = new Random();
		return rand.nextFloat();
	}
}
