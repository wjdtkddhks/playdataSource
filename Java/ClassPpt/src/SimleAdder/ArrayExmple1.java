package SimleAdder;

public class ArrayExmple1 {

	public static void main(String[] args) {
		int arr[];
		arr = new int [10];
		arr[0] = 10;
		arr[1] = 12;
		arr[2] = arr[0] + arr[1];
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
