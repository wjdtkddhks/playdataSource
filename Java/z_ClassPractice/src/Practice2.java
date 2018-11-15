

public class Practice2 {
	
	//final static int MAX = 9;
	
	public static void main(String[] args) {

		int [] chr = new int [10];
		int tmp= 0;
		
		for(int i=0; i<chr.length; i++)
		{
			chr[i] = (int)(Math.random() * (10));
			System.out.print(chr[i]);
			
		}
		System.out.println();
		
		for(int i=0; i <chr.length-1; i++)
		{
			boolean changed = false;
			
			for(int j=0; j<chr.length-1-i; j++)
			{ 
			if(chr[j] > chr[j+1])
			{
				tmp = chr[j];
				chr[j] = chr[j+1];
				chr[j+1] = tmp;
				changed = true;
			}
			
			}
			if (! changed) break;
			for(int k=0; k<chr.length; k++)
			 System.out.print(chr[k]);
			
			System.out.println();
		}
		
	}
}
