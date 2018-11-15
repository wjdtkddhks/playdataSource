
public class Numbers {

	int num[];
	
	Numbers(int num[])
	{
		this.num = num;
	}
	
	int getTotal()
	{
		int total=0;		
		for(int i=0; i < num.length; i++)
			total += num[i];
				
		return total;
	}
	
	int getAverage()
	{
		int total = getTotal();
		int average = total / num.length;
		
		return average;
	}
		
		
}
	

