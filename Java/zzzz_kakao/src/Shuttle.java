
import java.util.ArrayList;
import java.util.Collections;


public class Shuttle {
	
	public static void main(String[] args) {
		String[] arr1 = {"08:00", "08:01", "08:02", "08:03"};
		String[] arr2 = {"09:10", "09:09", "08:00"};
		String[] arr3 = {"09:00", "09:00", "09:00", "09:00"};
		String[] arr4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		String[] arr5 = {"23:59"};
		String[] arr6 = {"23:59","23:59", "23:59", "23:59", "23:59","23:59","23:59", "23:59", "23:59", "23:59","23:59","23:59", "23:59", "23:59", "23:59"};

		System.out.println("result1 : " + resultView(getTimes(1, 1), changeTime(arr1), 5));
		System.out.println("result2 : " + resultView(getTimes(2, 10), changeTime(arr2), 2));
		System.out.println("result3 : " + resultView(getTimes(2, 1), changeTime(arr3), 2));
		System.out.println("result4 : " + resultView(getTimes(1, 1), changeTime(arr4), 5));
		System.out.println("result5 : " + resultView(getTimes(1, 1), changeTime(arr5), 1));
		System.out.println("result6 : " + resultView(getTimes(10, 60), changeTime(arr6), 45));
		
	}
	public static String resultView(ArrayList<Integer> times, ArrayList<Integer> mans, int volum) {
		Integer timeMax = Collections.max(times);
		for(int k=0; k<mans.size(); k++) {
			if(timeMax.intValue() < mans.get(k).intValue()) {
				mans.remove(k);
				if(k>0) {k--;}
			}
		}

				
		if(mans.size() < volum) {
			return readTime(timeMax);
		}else{
			Integer manMax = Collections.max(mans);
			return readTime(manMax-1);
		}
		
	}
	
	public static String readTime(int a) {
		int h = a/60;
		int m = a%60;
		String hh = "";
		String mm = "";
		
		if(String.valueOf(h).length() == 1) {
			hh = "0"+ String.valueOf(h);
		}else {
			hh = String.valueOf(h);
		}
		
		if(String.valueOf(m).length() == 1) {
			mm = "0"+ String.valueOf(m);
		}else {
			mm = String.valueOf(m);
		}
		
		return hh + ":" + mm;
	}

	public static ArrayList<Integer> changeTime(String[] arr) {
		ArrayList<Integer> changeArr = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			String[] hmarr = arr[i].split(":");
			int check = ((Integer.parseInt(hmarr[0]))*60) + (Integer.parseInt(hmarr[1]));
			if(check != 1439)
			changeArr.add(check);
		}
		Collections.sort(changeArr);
		
		return changeArr;
	}
	
	public static ArrayList<Integer> getTimes(int n, int t) {
		int h= 9;
		int m=0;
		String[] times = new String[n] ;
		times[0] = "09:00";

		for(int i=0; i<n-1; i++) {
			String hh = "";
			String mm = "";
			
			m += t;
			
			h += m/60;
			m = m%60;
			
			if(String.valueOf(h).length() == 1) {
				hh = "0"+ String.valueOf(h);
			}else {
				hh = String.valueOf(h);
			}
			
			if(String.valueOf(m).length() == 1) {
				mm = "0"+ String.valueOf(m);
			}else {
				mm = String.valueOf(m);
			}
			
			times[i+1] = hh+":"+mm;
		}

		return changeTime(times);
	}
}
