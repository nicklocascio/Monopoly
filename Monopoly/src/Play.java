import java.util.*;
import java.io.*;

public class Play extends Edition
	{
	static Player player;
	static int sum;
	static ArrayList <Board> inventory = new ArrayList <Board>();
	static boolean bankrupt = false;
	
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
		player.setPosition(player.getPosition()+sum);
		System.out.println("You rolled a " + sum);
		if(player.getPosition()>40)
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
			if(spaces.get(player.getPosition()-1) instanceof Property || spaces.get(player.getPosition()-1) instanceof Utility || spaces.get(player.getPosition()-1) instanceof Railroad)
				{
				System.out.println();
				System.out.println("You are now on space " + player.getPosition() + ", which is: ");
				}
			else if(spaces.get(player.getPosition()-1) instanceof Chance || spaces.get(player.getPosition()-1) instanceof Chest)
				{
				if(spaces.get(player.getPosition()-1) instanceof Chance)
					{
					System.out.println();
					System.out.println("You are now on space " + player.getPosition() + ", which is a Chance card! Let's see what it is: ");
					delay();
					}
				else
					{
					System.out.println();
					System.out.println("You are now on space " + player.getPosition() + ", which is a Community Chest card! Let's see what it is: ");
					delay();
					}
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
			//Chance and Chest
			else if(spaces.get(player.getPosition()-1) instanceof Chance || spaces.get(player.getPosition()-1) instanceof Chest)
				{
				System.out.println(spaces.get(player.getPosition()-1).getDescription());
				if(spaces.get(player.getPosition()-1).getDeduction()>0)
					{
					player.setMoney(player.getMoney()-spaces.get(player.getPosition()-1).getDeduction());
					System.out.println("You have: $" + player.getMoney());
					}
				else if(spaces.get(player.getPosition()-1).getReward()>0)
					{
					player.setMoney(player.getMoney()+spaces.get(player.getPosition()-1).getReward());
					System.out.println("You have: $" + player.getMoney());
					}
				}
			//Tax
			else if(spaces.get(player.getPosition()-1) instanceof Tax)
				{
				System.out.println("You landed on: " + spaces.get(player.getPosition()-1).getName()+ " for $" + spaces.get(player.getPosition()-1).getDeduction());
				player.setMoney(player.getMoney()-spaces.get(player.getPosition()-1).getDeduction());
				System.out.println("You have: $" + player.getMoney());
				}
			//Other
			else if(spaces.get(player.getPosition()-1) instanceof Board)
				{
				if(spaces.get(player.getPosition()-1).getName().equals("Go To Jail"))
					{
					System.out.println(spaces.get(player.getPosition()-1).getName() + "! Lose $50 :(");
					player.setMoney(player.getMoney()-50);
					player.setPosition(11);
					System.out.println("You have: $" + player.getMoney() + " and you're in jail on space 11.");
					}
				else if(spaces.get(player.getPosition()-1).getName().equals("GO"))
					{
						
					}
				else
					{
					System.out.println(spaces.get(player.getPosition()-1).getName() + ". This doesn't help you or hurt you!");
					}
				}			
			System.out.println();
			}
		}
	}
