import java.util.*;
import java.io.*;

public class Play extends Edition
	{
	static Player player;
	static int sum;
	static ArrayList <Board> inventory = new ArrayList <Board>();
	static boolean bankrupt = false;
	static boolean inJail = false;
	
	public static void delay()
		{
		try
			{
			Thread.sleep(1500);
			} 
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}
	
	public static int diceRoll()
		{
		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		sum = dice1+dice2;
		return sum;
		}
	
	public static void createPlayer()
		{
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = userInput.nextLine();
		player = new Player(name, 1500, 1);
		System.out.println("Here is your info: " + player.getName() + ", $" + player.getMoney() + ", on space " + player.getPosition());
		}
	
	public static void advance()
		{
		diceRoll();
		if(inJail == false)
			{
			player.setPosition(player.getPosition()+sum);
			System.out.println("You rolled a " + sum);
			if(player.getPosition()>40)
				{
				passGO();
				}	
			}
		else
			{
			player.setPosition(player.getPosition()-sum);
			System.out.println("You rolled a " + sum);
			if(player.getPosition()<1)
				{
				passGO();
				}	
			}
		System.out.println();
		System.out.println("You are now on space " + player.getPosition() + ", which is: ");
		}
	
	public static void passGO()
		{	
		if(inJail == false)
			{
			int lap = player.getPosition() - 40;
			player.setPosition(lap);
			System.out.println();
			System.out.println("You have passed " + spaces.get(0).getName() + ". Collect $200");	
			player.setMoney(player.getMoney()+200);
			}
		else
			{
			int lap = 40 - (player.getPosition()*-1);
			player.setPosition(lap);
			System.out.println();
			System.out.println("You have passed " + spaces.get(0).getName() + ", but since you're a bad guy, you lose $200");
			player.setMoney(player.getMoney()-200);
			}
		System.out.println();
		System.out.println("You have: $" + player.getMoney());
		System.out.println();			
		}	
	
	public static void main(String [] args) throws IOException
		{
		System.out.println("Welcome to monopoly!");
		createPlayer();
		fillArray();
		boolean hi = true;
		while(hi)
			{
//			System.out.println(inJail);
			Scanner roll = new Scanner(System.in);
			System.out.println("Press enter to roll.");
			String go = roll.nextLine();
			if(go.equals("jail"))
				{
				player.setPosition(31);
				}
			else if(go.equals("freedom"))
				{
				player.setPosition(21);
				}
			else
				{
				System.out.println("Rolling...");
				System.out.println();
				delay();
				advance();
				}
			//Property
			if(spaces.get(player.getPosition()-1) instanceof Property)
				{
				Purchase.propertyPurchase();
				}		
			//Utility
			else if(spaces.get(player.getPosition()-1) instanceof Utility)
				{
				Purchase.utilityPurchase();
				}
			//Railroad
			else if(spaces.get(player.getPosition()-1) instanceof Railroad)
				{
				Purchase.railroadPurchase();
				}
			//Tax
			else if(spaces.get(player.getPosition()-1) instanceof Tax)
				{
				System.out.println(spaces.get(player.getPosition()-1).getName() + " for $" + spaces.get(player.getPosition()-1).getDeduction());
				player.setMoney(player.getMoney()-spaces.get(player.getPosition()-1).getDeduction());
				System.out.println("You have: $" + player.getMoney());
				}
			//Board
			else if(spaces.get(player.getPosition()-1) instanceof Board)
				{
				if(spaces.get(player.getPosition()-1).getName().equals("Chance") || spaces.get(player.getPosition()-1).getName().equals("Community Chest") || spaces.get(player.getPosition()-1).getName().equals("Trail Fortune") || spaces.get(player.getPosition()-1).getName().equals("Go for an Adventure"))
					{
					System.out.println(spaces.get(player.getPosition()-1).getName() + "! Coming soon!!");
					}
				else if(spaces.get(player.getPosition()-1).getName().equals("GO") || spaces.get(player.getPosition()-1).getName().equals("Trailhead"))
					{
					System.out.println(spaces.get(player.getPosition()-1).getName());	
					}
				else if(player.getPosition() == 11)
					{
					System.out.println(spaces.get(player.getPosition()-1).getName() + ". Continue on you're not in trouble!");
					}
				else if(spaces.get(player.getPosition()-1).getName().equals("Go To Jail") || spaces.get(player.getPosition()-1).getName().equals("Go to Basecamp"))
					{
					System.out.println(spaces.get(player.getPosition()-1).getName());
					player.setPosition(11);
					inJail = true;
					System.out.println("You are now in jail on space 11 and you will now move in the reverse direction.");
					}
				else if(spaces.get(player.getPosition()-1).getName().equals("Free Parking (Probation Center)") || spaces.get(player.getPosition()-1).getName().equals("Scenic Viewpoint (Probation Center)"))
					{
					if(inJail == true)
						{
						inJail = false;
						System.out.println(spaces.get(player.getPosition()-1).getName() + " on space 21. Your probation officer believes that you have learned your lesson. You may resume normal play. Stay out of trouble.");
						}	
					else if(inJail == false)
						{
						System.out.println(spaces.get(player.getPosition()-1).getName() + " Don't worry about a thing!");
						}						
					}
				}		
			System.out.println();
			}
		}
	}
