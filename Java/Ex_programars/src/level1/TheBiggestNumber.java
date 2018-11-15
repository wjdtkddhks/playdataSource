package level1;
import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {
	
	public static void main(String[] args) {
		int[] a = {3, 30, 34, 5, 9};
		int[] b = {310, 31, 33, 9, 5};
		int[] c= {30, 32, 3, 33, 35, 31, 34, 5, 9};
		
		System.out.println(solution(a));
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        String[] array = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	array[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(array, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		if(a.charAt(0) == b.charAt(0)) {
        			int aa = Integer.parseInt(a+b);
        			int bb = Integer.parseInt(b+a);
        			return bb-aa;
        		}
        		return b.charAt(0) - a.charAt(0);
        	}
        });
        
        StringBuffer sb = new StringBuffer();
        for(String str : array) {
        	sb.append(str);
        }       
        
        System.out.println(Arrays.toString(array));
        return sb.charAt(0) == 0 ? "0" : sb.toString();
    }
}
