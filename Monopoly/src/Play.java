import java.util.*;

public class Play
	{
	static Player player;
	static int sum;
	static ArrayList <Board> spaces = new ArrayList <Board>();
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
	
	//FIGURE OUT SOLUTION TO THE COLOR PROBLEM. Possibly an int for each group of color
	
	public static void fillArray()
		{
		spaces.add(new Board("GO", 1)); //
		spaces.add(new Property("Mediterranean Ave", 2, 60, 2, "Purple", 0, null));
		spaces.add(new Chest("Community Chest", "There was a bank error in your favor! Collect $200!", 3, 0, 200));
		spaces.add(new Property("Baltic Avenue", 4, 60, 4, "Purple", 0, null));
		spaces.add(new Tax("Income Tax", 5, 200)); //
		spaces.add(new Railroad("Reading Railroad", 6, 200, 25, 0, null));
		spaces.add(new Property("Oriental Avenue", 7, 100, 6, "Light Blue", 0, null));
		spaces.add(new Chance("Chance", "Pay a poor tax of $15.", 8, 15, 0));
		spaces.add(new Property("Vermont Avenue", 9, 100, 6, "Light Blue", 0, null));
		spaces.add(new Property("Connecticut Avenue", 10, 120, 8, "Light Blue", 0, null));
		spaces.add(new Board("Just Visiting Jail", 11)); // 
		spaces.add(new Property("St. Charles Place", 12, 140, 10, "Pink", 0, null));
		spaces.add(new Utility("Electrical Company", 13, 150, 0, 0, null));	
		spaces.add(new Property("States Avenue", 14, 140, 10, "Pink", 0, null));
		spaces.add(new Property("Virginia Avenue", 15, 160, 12, "Pink", 0, null));
		spaces.add(new Railroad("Pennsylvania Railroad", 16, 200, 25, 0, null));		
		spaces.add(new Property("St. James Place", 17, 180, 14, "Orange", 0, null));
		spaces.add(new Chest("Community Chest", "Pay hospital $100", 18, 100, 0));
		spaces.add(new Property("Tennessee Avenue", 19, 180, 14, "Orange", 0, null));
		spaces.add(new Property("New York Avenue", 20, 200, 16, "Orange", 0, null));
		spaces.add(new Board("Free Parking", 21));
		spaces.add(new Property("Kentucky Avenue", 22, 220, 18, "Red", 0, null));
		spaces.add(new Chance("Chance", "Your building loan matures. Collect $150.", 23, 0, 150));
		spaces.add(new Property("Indiana Avenue", 24, 220, 18, "Red", 0, null));
		spaces.add(new Property("Illinois Avenue", 25, 240, 20, "Red", 0, null));
		spaces.add(new Railroad("B&O Railroad", 26, 200, 25, 0, null));		
		spaces.add(new Property("Atlantic Avenue", 27, 260, 22, "Yellow", 0, null));
		spaces.add(new Property("Ventnor Avenue", 28, 260, 22, "Yellow", 0, null));
		spaces.add(new Utility("Water Works", 29, 150, 0, 0, null));
		spaces.add(new Property("Marvin Gardens", 30, 280, 24, "Yellow", 0, null));
		spaces.add(new Board("Go To Jail", 31));
		spaces.add(new Property("Pacific Avenue", 32, 300, 26, "Green", 0, null));
		spaces.add(new Property("North Carolina Avenue", 33, 300, 26, "Green", 0, null));
		spaces.add(new Chest("Community Chest", "You have won second prize in a beauty contest! collect $10", 34, 0, 10));
		spaces.add(new Property("Pennsylvania Avenue", 35, 320, 28, "Orange", 0, null));
		spaces.add(new Railroad("Short Line Railroad", 36, 200, 25, 0, null));
		spaces.add(new Chance("Chance", "Bank pays you a dividend of $50", 37, 0, 50));
		spaces.add(new Property("Park Place", 38, 350, 35, "Dark Blue", 0, null));
		spaces.add(new Tax("Luxury Tax", 39, 75));
		spaces.add(new Property("Boardwalk", 40, 400, 50, "Orange", 0, null));
		}
		
	//FIGURE OUT BOARDWALK
	public static void main(String [] args)
		{
		System.out.println("Welcome to monopoly!");
		createPlayer();
		fillArray();
		delay();
		boolean hi = true;
		while(hi = true)
			{
			Scanner roll = new Scanner(System.in);
			System.out.println("Press any key to roll.");
			String go = roll.nextLine();
			System.out.println("Rolling...");
			System.out.println();
			delay();
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
				}
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
			//delay();
			//Property
			if(spaces.get(player.getPosition()-1) instanceof Property)
				{
				Purchase.propertyPurchase();
				System.out.println("You have: $" + player.getMoney());
				System.out.println("Here is your inventory: ");
				for(Board hello : inventory)
					{
					System.out.println(hello.getName());
					}
				}		
			//Utility
			else if(spaces.get(player.getPosition()-1) instanceof Utility)
				{
				Purchase.utilityPurchase();
				System.out.println("You have: $" + player.getMoney());
				System.out.println("Here is your inventory: ");
				for(Board hello : inventory)
					{
					System.out.println(hello.getName());
					}
				}
			//Railroad
			else if(spaces.get(player.getPosition()-1) instanceof Railroad)
				{
				Purchase.railroadPurchase();
				System.out.println("You have: $" + player.getMoney());
				System.out.println("Here is your inventory: ");
				for(Board hello : inventory)
					{
					System.out.println(hello.getName());
					}
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
			System.out.println();
			}
		}
	}
