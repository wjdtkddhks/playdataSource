import java.util.Arrays;

public class Squaremap {

	public static void main(String[] args) {
			
		int n = 5;
		int[] arr1 = {9 ,20 ,28 ,18 ,11};
		int[] arr2 = {30,1,21,17,28};
		
		String[] result = arrayBinary(n, arr1, arr2);
		System.out.println(Arrays.toString(result));
		
	}
	public static String[] arrayBinary(int x, int[] arr1, int[] arr2) {
		int[] sumArr = new int[x];
		String[] stringArr = new String[x];
		
		for(int z=0; z<x; z++) {
			sumArr[z] = (arr1[z] | arr2[z]);
		}
		
		for(int z=0; z<x; z++) {
			stringArr[z] = intToBinary(sumArr[z], x);
			
		}
		
		return stringArr;
	}
	
	public static String intToBinary(int x, int y) {
		
		StringBuffer array = new StringBuffer();
		
		while(true) {
			if(x%2 == 1) {
				array.append("#");
			}else {
				array.append("_");
			}
			x = x/2;
			
			if(x == 1) {
				array.append("#");
				break;
			}
		}
		
		int num = y-array.length();
		if(array.length() != y) { 
			for(int z=0; z<num; z++) {
				array.insert(0, "_");

			}
		}

		return array.toString();
	}

}
