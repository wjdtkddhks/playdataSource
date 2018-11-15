
public class Accumulator {
	
	int total;
	static int grandtotal;
	
	void accumulate(int amount)
	{
		total += amount;
		grandtotal += amount;		
	}
	
	static int getgradtotal()
	{
		return grandtotal;
	}

}
