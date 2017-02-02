import java.util.Scanner;

public class Purchase extends Play
	{
	public static void updateInventory()
		{
		inventory.add(spaces.get(player.getPosition()-1));
		}

	public static boolean checkBalance()
		{	
		if((player.getMoney()-spaces.get(player.getPosition()-1).getPrice()) <0)
			{
			bankrupt = true;	
			}
		else
			{
			bankrupt = false;
			}
		return bankrupt;
		}
	
	public static void propertyPurchase()
		{
		System.out.println(spaces.get(player.getPosition()-1).getName() + " for $" + spaces.get(player.getPosition()-1).getPrice() + " and a rent of $" + spaces.get(player.getPosition()-1).getRent());
		System.out.println();
		Scanner userInput = new Scanner(System.in);	
		System.out.println("Would you like to purchase this property?");
		String answer = userInput.nextLine();
		checkBalance();
		if(answer.toLowerCase().equals("yes") && bankrupt == false)
			{
			if(inventory.contains(spaces.get(player.getPosition()-1)))
				{
				System.out.println();
				System.out.println("You already own this property, you can't buy it again.");
				}		
			else
				{
				updateInventory();	
				player.setMoney(player.getMoney() - spaces.get(player.getPosition()-1).getPrice());
				}			
			}
		else if(answer.toLowerCase().equals("yes") && bankrupt == true)
			{
			if(inventory.contains(spaces.get(player.getPosition()-1)))
				{
				System.out.println();
				System.out.println("You already own this property, you can't buy it again.");
				}
			else
				{
				System.out.println();
				System.out.println("Not so fast! You don't have enough to purchase that!");
				}
			}
		}
	
	public static void utilityPurchase()
		{
		System.out.println(spaces.get(player.getPosition()-1).getName() + " for $" + spaces.get(player.getPosition()-1).getPrice());
		System.out.println();
		Scanner userInput = new Scanner(System.in);	
		System.out.println("Would you like to purchase this utility?");
		String answer = userInput.nextLine();
		checkBalance();
		if(answer.toLowerCase().equals("yes") && bankrupt == false)
			{
			if(inventory.contains(spaces.get(player.getPosition()-1)))
				{
				System.out.println();
				System.out.println("You already own this utility, you can't buy it again.");
				}		
			else
				{
				updateInventory();	
				player.setMoney(player.getMoney() - spaces.get(player.getPosition()-1).getPrice());
				}			
			}
		else if(answer.toLowerCase().equals("yes") && bankrupt == true)
			{
			if(inventory.contains(spaces.get(player.getPosition()-1)))
				{
				System.out.println();
				System.out.println("You already own this utility, you can't buy it again.");
				}
			else
				{
				System.out.println();
				System.out.println("Not so fast! You don't have enough to purchase that!");
				}
			}	
		}
	
	public static void railroadPurchase()
		{
		System.out.println(spaces.get(player.getPosition()-1).getName() + " for $" + spaces.get(player.getPosition()-1).getPrice());
		System.out.println();
		Scanner userInput = new Scanner(System.in);	
		System.out.println("Would you like to purchase this railroad?");
		String answer = userInput.nextLine();
		checkBalance();
		if(answer.toLowerCase().equals("yes") && bankrupt == false)
			{
			if(inventory.contains(spaces.get(player.getPosition()-1)))
				{
				System.out.println();
				System.out.println("You already own this railroad, you can't buy it again.");
				}		
			else
				{
				updateInventory();	
				player.setMoney(player.getMoney() - spaces.get(player.getPosition()-1).getPrice());
				}			
			}
		else if(answer.toLowerCase().equals("yes") && bankrupt == true)
			{
			if(inventory.contains(spaces.get(player.getPosition()-1)))
				{
				System.out.println();
				System.out.println("You already own this railroad, you can't buy it again.");
				}
			else
				{
				System.out.println();
				System.out.println("Not so fast! You don't have enough to purchase that!");
				}
			}
		}
	}
