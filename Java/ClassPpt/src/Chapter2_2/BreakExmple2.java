package Chapter2_2;


public class BreakExmple2 {

	public static void main(String[] args) {

		
			for(int i=0; i<3; i++)
				abc:{for(int j=0; j<5; j++)
				{
					System.out.println("(" + i + "," +  j + ")");
					if(i==1 && j==3)
						break abc;
					
				}
			}
	}

}
