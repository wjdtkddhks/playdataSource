package Chapter2_2;


public class BreakExmple1 {

	public static void main(String[] args) {


			for(int i=0; i<10; i++)
			{
				System.out.println(i);
				if(i == 5) 
					break;
			}
			System.out.println("done");
	}
}
