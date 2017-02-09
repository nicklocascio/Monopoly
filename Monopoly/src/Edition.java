import java.io.*;
import java.util.*;

//OK DUDE ITS CRUNCH TIME. YOU NEED TO CREATE 12 CHEST/CHANCE CARDS THAT RANDOMLY SELECT. THEN YOU NEED TO REVERSE DIRECTION. ALSO GET ALBERTS DONE DUDE CMON!!!!!!

public class Edition 
	{
	static ArrayList <Board> spaces = new ArrayList <Board>();
	
	public static void fillArray() throws IOException
		{
		Scanner input = new Scanner(System.in);
		System.out.println("What edition would you like to play?");
		System.out.println("1) Traditional");
		System.out.println("2) Colorado 14ers");
		int edition = input.nextInt();
		String chice = "";
		Scanner file = null;
		if(edition == 1)
			{
			file = new Scanner(new File("Traditional.txt"));
			}
		else if(edition == 2)
			{
			file = new Scanner(new File("Colorado14ers.txt")); 
			}
		int times = file.nextInt();
		file.nextLine();
		for(int i = 0; i < times; i++)
			{
			String line = file.nextLine();
			String[] text = line.split(", ");
			if(text[text.length-1].equals("Property"))
				{
				String name = text[0];
				int space = Integer.parseInt(text[1]);
				int price = Integer.parseInt(text[2]);
				int rent = Integer.parseInt(text[3]);
				String color = text[4];
				int house = Integer.parseInt(text[5]);
				String owner = text[6];
				spaces.add(new Property(name, space, price, rent, color, house, owner));
				}
			else if(text[text.length-1].equals("Utility"))
				{
				String name = text[0];
				int space = Integer.parseInt(text[1]);
				int price = Integer.parseInt(text[2]);
				int rent = Integer.parseInt(text[3]);
				int number = Integer.parseInt(text[4]);
				String owner = text[5];
				spaces.add(new Utility(name, space, price, rent, number, owner));
				}
			else if(text[text.length-1].equals("Railroad"))
				{
				String name = text[0];
				int space = Integer.parseInt(text[1]);
				int price = Integer.parseInt(text[2]);
				int rent = Integer.parseInt(text[3]);
				int number = Integer.parseInt(text[4]);
				String owner = text[5];
				spaces.add(new Railroad(name, space, price, rent, number, owner));
				}
			else if(text[text.length-1].equals("Chest") || text[text.length-1].equals("Chance"))
				{
				String name = text[0];
				int space = Integer.parseInt(text[1]);
				spaces.add(new Board(name, space));
				}
			else if(text[text.length-1].equals("Board"))
				{
				String name = text[0];
				int space = Integer.parseInt(text[1]);
				spaces.add(new Board(name, space));
				}
//			else if(text[text.length-1].equals("Jail"))
//				{
//				String name = text[0];
//				int space = Integer.parseInt(text[1]);
//				spaces.add(new Jail(name, space));
//				}
//			else if(text[text.length-1].equals("Freedom"))
//				{
//				String name = text[0];
//				int space = Integer.parseInt(text[1]);
//				spaces.add(new Freedom(name, space));
//				}
			else if(text[text.length-1].equals("Tax"))
				{
				String name = text[0];
				int space = Integer.parseInt(text[1]);
				int deduction = Integer.parseInt(text[2]);
				spaces.add(new Tax(name, space, deduction));
				}
			}
//		for(Board hi : spaces)
//			{
//			System.out.println(hi.getName());
//			}
		}
	}
