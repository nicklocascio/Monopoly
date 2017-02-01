
public class Board
	{
	protected String name;
	protected int space;
	protected int price;
	protected int rent;
	protected String color;
	protected int house;
	protected int number;
	protected String owner;
	protected int deduction;
	
	public Board()
		{
			
		}
	
	public Board(String n, int sp)
		{
		name = n;
		space = sp;
		}
	
	public String getName()
		{
		return name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public int getSpace()
		{
		return space;
		}

	public void setSpace(int space)
		{
		this.space = space;
		}
	
	public int getPrice()
		{
		return price;
		}

	public void setPrice(int price)
		{
		this.price = price;
		}
	
	public int getRent()
		{
		return rent;
		}

	public void setRent(int rent)
		{
		this.rent = rent;
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
	
	public int getNumber()
		{
		return number;
		}

	public void setNumber(int number)
		{
		this.number = number;
		}
	
	public String getOwner()
		{
		return owner;
		}

	public void setOwner(String owner)
		{
		this.owner = owner;
		}
	
	public int getDeduction()
		{
		return deduction;
		}

	public void setDeduction(int deduction)
		{
		this.deduction = deduction;
		}

	}
