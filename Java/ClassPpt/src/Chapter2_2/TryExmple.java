package Chapter2_2;


public class TryExmple {

	public static void main(String[] args) {
		int did[] = {5,4,3,2,1,0};
		
		for(int i=0; i<10; i++) 
		{
			try 
			{
				int share = 100/did[i];
				System.out.println(share);
			}
			catch(java.lang.ArithmeticException e)
			{
				System.out.println("잘못된 연산입니다. " + e.getMessage() );
			}
			catch(java.lang.ArrayIndexOutOfBoundsException e)
			{
				System.out.println("잘못된 인덱스입니다. " + e.getMessage() );
			}
			
		}
		System.out.println("Done");
	}

}
