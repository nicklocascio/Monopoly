
public class Utility extends Board
	{
	public Utility(String n, int sp, int p, int r, int num, String o)
		{
		name = n;
		space = sp;
		price = p;
		rent = r;
		number = num;
		owner = o;
		
		if(num==1)
			{
			rent = Play.diceRoll()*4;	
			}
		else if(num==2)
			{
			rent = Play.diceRoll()*10;	
			}
		}
	}
