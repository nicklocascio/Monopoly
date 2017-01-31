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
	
	public static void main(String [] args)
		{
		System.out.println("Welcome to monopoly!");
		createPlayer();
		ArrayList <Board> spaces = new ArrayList <Board>();
		spaces.add(new Board("GO", 1));
		spaces.add(new Property("Mediterranean Ave", 2, 60, "Purple", 0, null));
		spaces.add(new Utility("Water Works", 29, 150, 0));
		spaces.add(new Utility("Electrical Company", 13, 150, 0));
		diceRoll();
		}
	}
