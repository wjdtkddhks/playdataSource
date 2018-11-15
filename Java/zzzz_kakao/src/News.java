import java.util.ArrayList;

public class News {

	public static void main(String[] args) {
		ArrayList<String> gyoArr = new ArrayList<String>();
		ArrayList<String> hapArr = new ArrayList<String>();
		String str = "FRANCE";
		String str2 = "french";
		gyoArr = setCommon(setArray(str), setArray(str2));
		hapArr = setPlus(setArray(str), setArray(str2));
		for(String a : gyoArr) {
			hapArr.add(a);
		}
		
		System.out.print("hapArr : ");
		for(String ab : hapArr) {
			System.out.print(ab+" ");
		}
		System.out.print("\ngyoArr : ");
		for(String ab : gyoArr) {
			System.out.print(ab+" ");
		}
		
		double j =0;
		if(gyoArr.size() != 0 && hapArr.size() != 0) {
			j = (double)gyoArr.size()/hapArr.size()*65536;
		}else {
			j=1;
		}
		
		System.out.println("\nJ : " + (int)j);
		
	}
	
	public static ArrayList<String> setArray(String str){
		ArrayList<String> resArray = new ArrayList<String>();
		str = str.toLowerCase();
		char[] charArr = new char[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		for(int i=0; i<charArr.length; i++) {
			if(i == charArr.length-1) {
				break;
			}
			if(charArr[i] >= 'a' && charArr[i] <='z' && charArr[i+1] >= 'a' && charArr[i+1] <='z') {
				resArray.add(String.valueOf(charArr[i])+String.valueOf(charArr[i+1]));
			}
			
		}
		
		return resArray;
	}
	
	public static ArrayList<String> setCommon(ArrayList<String> arr, ArrayList<String> arr2){
		ArrayList<String> resArr = new ArrayList<String>();
		
		ab:
		for(int i=0; i<arr.size(); i++) {
			for(int j=0; j<arr2.size(); j++) {
				if(arr.get(i).equals(arr2.get(j))) {
					resArr.add(arr.get(i));
					arr.remove(arr.get(i));
					arr2.remove(arr2.get(j));
					i--;
					j--;
					continue ab;
				}
			}
		}
		
		return resArr;
	}
	
	public static ArrayList<String> setPlus(ArrayList<String> arr, ArrayList<String> arr2){
		ArrayList<String> gyoArr = new ArrayList<String>();
		ArrayList<String> resArr = new ArrayList<String>();

		gyoArr  = setCommon(arr, arr2);
	
		for(int i=0; i<arr.size(); i++) {
			for(int j=0; j<gyoArr.size(); j++) {
				if(arr.get(i).equals(gyoArr.get(j))) {
					arr.remove(arr.get(i));
					gyoArr.remove(gyoArr.get(j));
					i--;
					j--;
					break;
				}
			}
		}
	
		for(String str : arr) {
			resArr.add(str);
		}
		for(String str : arr2) {
			resArr.add(str);
		}
		
		return resArr;
	}
	
}
