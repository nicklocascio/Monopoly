import java.util.*;

public class Play
	{
	public static int diceRoll()
		{
		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		int sum = dice1+dice2;
		return sum;
		}
	
	public static void createPlayer()
		{
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		Player player = new Player(name, 1500, 1);
		System.out.println("Here is your info: " + player.getName() + ", $" + player.getMoney() + ", on space " + player.getPosition());
		}
	
	//FIGURE OUT SOLUTION TO THE COLOR PROBLEM. Possibly an int for each group of color
	//http://www.math.yorku.ca/~zabrocki/math2042/Monopoly/prices.html
	
	public static void fillArray()
		{
		ArrayList <Board> spaces = new ArrayList <Board>();
		//GO Space
		spaces.add(new Property("Mediterranean Ave", 2, 60, 2, "Purple", 0, null));
		//Community Chest
		spaces.add(new Property("Baltic Avenue", 4, 60, 4, "Purple", 0, null));
		//Income tax
		//Reading Railroad
		spaces.add(new Property("Oriental Avenue", 7, 100, 6, "Light Blue", 0, null));
		//Chance
		spaces.add(new Property("Vermont Avenue", 9, 100, 6, "Light Blue", 0, null));
		spaces.add(new Property("Connecticut Avenue", 10, 120, 8, "Light Blue", 0, null));
		//Just visiting jail
		spaces.add(new Property("St. Charles Place", 12, 140, 10, "Pink", 0, null));
		spaces.add(new Utility("Electrical Company", 13, 150, 0, 0, null));	
		spaces.add(new Property("States Avenue", 14, 140, 10, "Pink", 0, null));
		spaces.add(new Property("Virginia Avenue", 15, 160, 12, "Pink", 0, null));
		//Pennsylvania Railroad
		spaces.add(new Utility("Water Works", 29, 150, 0, 0, null));
		}
	
	public static void main(String [] args)
		{
		//System.out.println("Welcome to monopoly!");
		//createPlayer();
		
		
		}
	}
