import java.util.ArrayList;
import java.util.Collections;

public class traffic {
	
	public static void main(String[] args) {
		String[] str1 = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}; 
		String[] str2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}; 
		String[] str3 = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", 
		  "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", 
		  "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		String[] str4 = {"2016-09-15 23:59:59.999 0.001s"};
		System.out.println("answer1 : " +compareTime(changeTimes(str1)));
		System.out.println("answer2 : " +compareTime(changeTimes(str2)));
		System.out.println("answer3 : " +compareTime(changeTimes(str3)));
		System.out.println("answer4 : " +compareTime(changeTimes(str4)));
	}
	
	public static ArrayList<Time> changeTimes(String[] strArr) {
		if(strArr == null || strArr.length == 0) {
			System.out.println("확인해주세요.");
			return null;
		}
		ArrayList<Time> timeArr = new ArrayList<Time>();
		
		for(String str : strArr) {
			String hour = str.substring(11,13);
			String minute = str.substring(14,16);
			String second =str.substring(17,23);
			String differ = str.substring(24, str.length()-1);
			Time time = new Time();
			time.lastTime = (int)((Integer.parseInt(hour)*60*60 
					+ Integer.parseInt(minute)*60
					+ Double.parseDouble(second))*1000);
			if((Double.parseDouble(differ)*1000) == 1) {
				time.startTime = (int)(time.lastTime - (Double.parseDouble(differ)*1000));
			}else {
				time.startTime = (int)(time.lastTime - (Double.parseDouble(differ)*1000)+1);
			}
			
			System.out.println("stratTime :" + time.startTime);
			System.out.println("lastTime :" + time.lastTime);
			timeArr.add(time);
		}
			
		return timeArr;
	}
	
	public static int compareTime(ArrayList<Time> timeArr) {
		int startCheck1=0;
		int lastCheck1 =0;
		int startCheck2=0;
		int lastCheck2 =0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<timeArr.size(); i++) {
			startCheck1 = 0;
			lastCheck1 = 0;
			startCheck2 = 0;
			lastCheck2 = 0;
			for(int j=0; j<timeArr.size(); j++) {
				if(timeArr.get(i).startTime<=timeArr.get(j).lastTime && (timeArr.get(i).startTime+999)>=timeArr.get(j).startTime) {
					startCheck1++;
				}
			}
			for(int j=0; j<timeArr.size(); j++) {
				if((timeArr.get(i).lastTime-999)<=timeArr.get(j).lastTime && (timeArr.get(i).lastTime)>=timeArr.get(j).startTime) {
					lastCheck1++;
				}
			}
			for(int j=0; j<timeArr.size(); j++) {
				if((timeArr.get(i).startTime-999)<=timeArr.get(j).lastTime && timeArr.get(i).startTime>=timeArr.get(j).startTime) {
					startCheck2++;
				}
			}
			for(int j=0; j<timeArr.size(); j++) {
				if(timeArr.get(i).lastTime<=timeArr.get(j).lastTime && (timeArr.get(i).lastTime+999)>=timeArr.get(j).startTime) {
					lastCheck2++;
				}
			}
			result.add(startCheck1);
			result.add(lastCheck1);
			result.add(startCheck2);
			result.add(lastCheck2);
		}
		
		return Collections.max(result);
	}
}
class Time{
	public int startTime;
	public int lastTime;
}
