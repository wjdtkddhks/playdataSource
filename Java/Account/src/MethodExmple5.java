
public class MethodExmple5 {

	public static void main(String[] args) {
		Account obj = new Account("111-22-33333333", "홍길동", 100000);
		
		try 
		{
			int amount = obj.withdraw(10000);
			System.out.println(amount);
		}
		catch(Exception e)
		{
			String msg = e.getMessage();
			System.out.println(msg);
			System.out.println(e.getMessage());
		}
		
	}

}
