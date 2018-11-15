package Chapter2_2;


public class SmartExmple {

	public static void main(String[] args) 
	{
		int a=3, b=0;
		int result;
		
		try 
		{
			result = a/b;
			System.out.println(result);
		}
		catch(java.lang.ArithmeticException e) 
		{// java.lang.ArithmeticException << 자바가 만든 패키지와 클래스
			System.out.println("잘못된 연산입니다 : " + e.getMessage());
		}
		finally
		{
			System.out.println("Done");
		}

	}

}
