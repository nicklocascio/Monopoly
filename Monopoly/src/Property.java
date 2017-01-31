
public class Property extends Board
	{
	protected int price;
	protected String color;
	//protected int rent;
	protected int house;
	protected String owner;
	
	public Property()
		{
			
		}
	
	public Property(String n, int sp, int p, String c, int h, String o)
		{
		name = n;
		space = sp;
		price = p;
		color = c;
		house = h;
		owner = o;
		}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public int getHouse()
	{
		return house;
	}

	public void setHouse(int house)
	{
		this.house = house;
	}
	}
