package Chapter2_2;


public class forExmple4 {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};
		int hap = 0;
		
		for(int i=0; i<arr.length; i++)
		    hap+= arr[i];
		
		
		System.out.println(hap);

	}

}
