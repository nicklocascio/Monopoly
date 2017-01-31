
public class Player
	{
	protected String name;
	protected int money;
	protected int position;
	
	public Player(String n, int m, int p)
		{
		name = n;
		money = m;
		position = p;
		}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}
	}
