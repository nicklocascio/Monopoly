import java.util.*;

public class Play
	{
	static Player player;
	static int sum;
	static ArrayList <Board> spaces = new ArrayList <Board>();
	
	public static int diceRoll()
		{
		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		sum = dice1+dice2;
		return sum;
		}
	
	public static void createPlayer()
		{
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		player = new Player(name, 1500, 1);
		System.out.println("Here is your info: " + player.getName() + ", $" + player.getMoney() + ", on space " + player.getPosition());
		}
	
	//FIGURE OUT SOLUTION TO THE COLOR PROBLEM. Possibly an int for each group of color
	//http://www.math.yorku.ca/~zabrocki/math2042/Monopoly/prices.html
	
	public static void fillArray()
		{
		spaces.add(new Board("GO", 1));
		spaces.add(new Property("Mediterranean Ave", 2, 60, 2, "Purple", 0, null));
		spaces.add(new Board("Community Chest", 3));
		spaces.add(new Property("Baltic Avenue", 4, 60, 4, "Purple", 0, null));
		spaces.add(new Tax("Income Tax", 5, 200));
		spaces.add(new Railroad("Reading Railroad", 6, 200, 25, 0, null));
		spaces.add(new Property("Oriental Avenue", 7, 100, 6, "Light Blue", 0, null));
		spaces.add(new Board("Chance", 8));
		spaces.add(new Property("Vermont Avenue", 9, 100, 6, "Light Blue", 0, null));
		spaces.add(new Property("Connecticut Avenue", 10, 120, 8, "Light Blue", 0, null));
		spaces.add(new Board("Just Visiting Jail", 11));
		spaces.add(new Property("St. Charles Place", 12, 140, 10, "Pink", 0, null));
		spaces.add(new Utility("Electrical Company", 13, 150, 0, 0, null));	
		spaces.add(new Property("States Avenue", 14, 140, 10, "Pink", 0, null));
		spaces.add(new Property("Virginia Avenue", 15, 160, 12, "Pink", 0, null));
		spaces.add(new Railroad("Pennsylvania Railroad", 16, 200, 25, 0, null));		
		spaces.add(new Property("St. James Place", 17, 180, 14, "Orange", 0, null));
		spaces.add(new Board("Community Chest", 18));
		spaces.add(new Property("Tennessee Avenue", 19, 180, 14, "Orange", 0, null));
		spaces.add(new Property("New York Avenue", 20, 200, 16, "Orange", 0, null));
		spaces.add(new Board("Free Parking", 21));
		spaces.add(new Property("Kentucky Avenue", 22, 220, 18, "Red", 0, null));
		spaces.add(new Board("Chance", 23));
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
		spaces.add(new Board("Community Chest", 34));
		spaces.add(new Property("Pennsylvania Avenue", 35, 320, 28, "Orange", 0, null));
		spaces.add(new Railroad("Short Line Railroad", 36, 200, 25, 0, null));
		spaces.add(new Board("Chance", 37));
		spaces.add(new Property("Park Place", 38, 350, 35, "Dark Blue", 0, null));
		spaces.add(new Tax("Luxury Tax", 39, 75));
		spaces.add(new Property("Boardwalk", 40, 400, 50, "Orange", 0, null));
		}
	
	public static void main(String [] args)
		{
		//System.out.println("Welcome to monopoly!");
		createPlayer();
		fillArray();
		int i = 1;
		while(i <= 40){
		diceRoll();
		//Advancing positions
		System.out.println("Your roll: " + sum);
		player.setPosition(player.getPosition()+sum);
		System.out.println(player.getPosition());
		//
		if(spaces.get(player.getPosition()-1) instanceof Property)
			{
			System.out.println("Shizzzzzzz");	
			}
		}
		}
	}
