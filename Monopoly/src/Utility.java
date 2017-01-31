
public class Utility extends Board
	{
	protected int rent;
	protected int number;
	
	public Utility()
		{
		
		}
	
	public Utility(String n, int sp, int r, int num)
		{
		name = n;
		space = sp;
		rent = r;
		number = num;
		
		if(num==1)
			{
			rent = Play.diceRoll()*4;	
			}
		else if(num==2)
			{
			rent = Play.diceRoll()*10;	
			}
		}

	public int getRent()
	{
		return rent;
	}

	public void setRent(int rent)
	{
		this.rent = rent;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
	}
