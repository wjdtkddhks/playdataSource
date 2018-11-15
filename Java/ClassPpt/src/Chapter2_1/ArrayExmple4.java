package Chapter2_1;

public class ArrayExmple4 {

	public static void main(String[] args) {
		int arr[][] = {{1,2,3,4}, {5,6,7}, {9,10}};
		
		System.out.println(arr[0][0]);
		System.out.println(arr[1][1]);
		System.out.println(arr[2][1]);

		
		System.out.println("arr.length = " + arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[1].length);
		System.out.println(arr[2].length);
	}

}
