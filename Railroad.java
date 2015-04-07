package monopoly;

public class Railroad
{
	private int numOwned;  //number of railroads owned by a player
	//rent, given number of railroads owned by a player
	private final int ONE = 25;
	private final int TWO = 50;
	private final int THREE = 100;
	private final int FOUR = 200;
	private final int COST = 200;

    private Player.PlayerType ownerType;
    private Player owner;
    private boolean owned;  //is property owned?
    private boolean mortgaged;
	
	//constructor
	public Railroad()
	{
		numOwned = 1;
	}
    
    //update status of property to owned
    public void purchase(Player player)
    {
        owned = true;
        owner = player;
        ownerType = player.getPlayer();
    }
	
	//update total number of railroads owned by a player
	public void owned(int owned)
	{
		if (owned < 0)
			throw new IllegalArgumentException("Cannot own negative "
			                                                + "properties!");
		if (owned > 4)
			throw new IllegalArgumentException("Cannot own more than "
			                                             + "four railroads!");
		numOwned = owned;
	}
	
	//return rent owed
	public int rent()
	{
		switch(numOwned)
		{
			case 1:	return ONE;
			case 2: return TWO;
			case 3: return THREE;
			case 4: return FOUR;
			default: return 0;
		}
	}
    
    public boolean isOwned()
    {
        return owned;
    }
    
    public Player.PlayerType ownerType()
    {
        return ownerType;
    }
    
    public Player owner()
    {
        return owner;
    }

    public int cost()
    {
        return COST;
    }

    //mortgage or unmortgage property
    public int mortgage()
    {
        if (mortgaged)
        {
            mortgaged = false;
            return (int) Math.round((COST / 2) * 1.1);
        }
        else
        {
            mortgaged = true;
            return COST / 2;
        }
    }
    
    public boolean isMortgaged()
    {
        return mortgaged;
    }
    
    public int mortgageCost()
    {
        return COST / 2;
    }
}