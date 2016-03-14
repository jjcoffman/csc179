package a1;
/*****************************************************************************************************************************
 * Program: Assignment 1 - Class Associations
 * Author: 	Jonathan Coffman
 * Due: 	2/26/2015
 * 
 * Class: 	game
 * Purpose: This is our control class. It handles user interaction then communicates with the GameWorld() so it may perform
 * 			the requested task by the user.
 * 
 *****************************************************************************************************************************/
import java.util.Scanner;
class Game //controller
{
	private Scanner scan;
	private GameWorld world;
	private String s;
	
	//constructor
	Game() 
	{
		scan = new Scanner(System.in);
		world = new GameWorld();
		world.initLayout();
		play();
	}
	
	private void play()
	{
		//code to accept and execute commands based on players input while they have lives remaining. 
		while(world.getLives() > 0)
		{
			s = getCommand();

			if(s.equals("a"))
			{
				world.accelerate();
			}
			else if(s.equals("b"))
			{
				world.brake();
			}
			else if(s.equals("l"))
			{
				world.steerLeft();
			}
			else if(s.equals("r"))
			{
				world.steerRight();
			}
			else if(s.equals("o"))
			{
				world.addOil();
			}
			else if(s.equals("c"))
			{
				world.carCollision();
			}
			else if(s.matches("[p][0123456789][0123456789]?"))
			{
				world.pylonCollision(s.substring(1));
			}
			else if(s.equals("f"))
			{
				world.fuelCollision();
			}
			else if(s.equals("g"))
			{
				world.birdCollision();
			}
			else if(s.equals("e"))
			{
				world.enteredOil();
			}
			else if(s.equals("x"))
			{
				world.exitOil();
			}
			else if(s.equals("n"))
			{
				world.newColors();
			}
			else if(s.equals("t"))
			{
				world.clockTick();
			}
			else if(s.equals("d"))
			{
				world.display();
			}
			else if(s.equals("m"))
			{
				world.map();
			}
			else if(s.equals("q"))
			{
				System.out.println("Are you sure you want to quit? (y/n)");
				s = scan.nextLine();
				if(s.matches("y"))
					System.exit(0);
			}
			else
			{
				System.out.println("Incorrect input!");
			}
		}
		System.out.println("Out of Lives!");
		System.exit(0);
	}

	//here we ask the user for a command
	private String getCommand() 
	{
		System.out.println("Please enter a command");
		return scan.nextLine();
		
	}
	
}
