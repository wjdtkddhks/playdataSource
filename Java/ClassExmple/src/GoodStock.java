
public class GoodStock 
{
	String goodCode;
	int stockNum;
	
	GoodStock()	{	}
	
	GoodStock(String code, int num)
	{
		goodCode = code;
		stockNum = num;
	}
	
	void addStock(int amount)
	{
		stockNum += amount;
	}
	
	int substractStock(int amount)
	{
		if(stockNum < amount)
			return 0;
		
		stockNum -= amount;
			return amount;
	}
		
}
