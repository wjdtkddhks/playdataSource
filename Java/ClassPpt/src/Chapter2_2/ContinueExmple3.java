package Chapter2_2;


public class ContinueExmple3 {

	public static void main(String[] args) {
	
	for(int i=0; i<3; i++)
		for(int j=0; j<5; j++)
			{
			 if(i==1 && j ==3)
				continue ;
			 System.out.printf("(%d, %d)\n", i, j);
			}
	
	
	}
}