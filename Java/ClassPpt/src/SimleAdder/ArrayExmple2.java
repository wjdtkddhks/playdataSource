package SimleAdder;

public class ArrayExmple2 {

	public static void main(String[] args) {
		int arr[][] = new int[6][8];
		
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[2][3] = arr[0][0] + arr[0][1];
		
		System.out.println(arr[0][1]);
		System.out.println(arr[2][3]);
		System.out.println(arr.length);
		System.out.println(arr[3].length);
		System.out.println(arr[1][2]);
		
		int table[] = new int[10];
		System.out.println(table.length);
		
		for(int i=0; i<table.length; i++)
			System.out.println(table[i]);
	}

}
