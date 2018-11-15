
public class MethodExmple2 {

	public static void main(String[] args) 
	{
		int arr[] = new int[0];
		
		//for(int i=1; i<=10; i++)
		//	arr[i-1] = i*10;
		
		Numbers obj = new Numbers(arr);
		
		try 
		{
		System.out.println(obj.getTotal());
		System.out.println(obj.getAverage());
		}
		catch(java.lang.ArithmeticException e)
		{
		System.out.println("잘못입력하였습니다." + e.getMessage());	
		}

	}

}
