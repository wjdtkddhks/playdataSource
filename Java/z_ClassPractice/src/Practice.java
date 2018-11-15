

public class Practice {
	

	public static void main(String[] args)
	{
		int [] arr = new int[9];
		
		for(int i=0; i<9; i++)
		{
			arr[i] = (int)(Math.random()*9);
			System.out.print(arr[i]);
			
		}
		System.out.println();
		for(int tmp : arr)
			System.out.print(tmp);
		
		
	}
}
