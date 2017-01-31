
public class Board
	{
	protected String name;
	protected int space;

	
	public Board()
		{
			
		}
	
	public Board(String n, int sp)
		{
		name = n;
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
	}
