import java.io.*;
import java.util.*;

public class Edition 
	{
	static ArrayList <Board> spaces = new ArrayList <Board>();

	public static void textFile()
		{
			
		}
	
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
			file = new Scanner(new File("TraditionalMonopoly.txt"));
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
//			for(String hi : space)
//				{
//				System.out.println(hi);
//				}
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
//			for(int j = 0; j < space.length; j++)
//				{
//				System.out.println(space[j]);
//				}
			for(Board hi : spaces)
				{
				System.out.println(hi.getName());
				System.out.println(hi.getPrice());
				}
			}
		}
	}
