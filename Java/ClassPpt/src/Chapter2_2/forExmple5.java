package Chapter2_2;


public class forExmple5 {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};
		int hap =0;
		
		for(int num : arr)
			{
			System.out.println(num);
			hap += num;
			}
		System.out.println(hap);
		
	}

}
