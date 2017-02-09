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
	
	public static void inJail()
		{
		if(spaces.get(player.getPosition()-1) instanceof Jail)
			{
			inJail = true;
			}
		
		}
	
	public static void advance()
		{
		diceRoll();
		player.setPosition(player.getPosition()+sum);
		System.out.println("You rolled a " + sum);
		if(player.getPosition()>40)
			{
			passGO();
			}	
		System.out.println();
		System.out.println("You are now on space " + player.getPosition() + ", which is: ");
		}
	
	public static void passGO()
		{		
		int lap = player.getPosition() - 40;
		player.setPosition(lap);
		System.out.println();
		System.out.println("You have passed GO! Collect $200");
		player.setMoney(player.getMoney()+200);
		System.out.println();
		System.out.println("You have: $" + player.getMoney());
		System.out.println();			
		}	
	
	public static void main(String [] args) throws IOException
		{
		System.out.println("Welcome to monopoly!");
		createPlayer();
		fillArray();
		delay();
		boolean hi = true;
		while(hi)
			{
			Scanner roll = new Scanner(System.in);
			System.out.println("Press enter to roll.");
			String go = roll.nextLine();
			System.out.println("Rolling...");
			System.out.println();
			delay();
			advance();
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
				if(spaces.get(player.getPosition()-1).getName().equals("Chance") || spaces.get(player.getPosition()-1).getName().equals("Community Chest"))
					{
					System.out.println(spaces.get(player.getPosition()-1).getName() + "! Coming soon!!");
					}
				else if(spaces.get(player.getPosition()-1).getName().equals("GO"))
					{
					System.out.println("GO!");	
					}
				//So now you need jail and free parking and visiting jail
				}			
			System.out.println();
			}
		}
	}
