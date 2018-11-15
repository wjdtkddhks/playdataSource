package Chapter9;
import java.util.*;
public class CalanerExmple2 {

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone("Europe/London");
		calendar.setTimeZone(timeZone);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		int amPm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		String sAmPm = amPm == Calendar.AM ? "오전" : "오후";
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초\n", year, month, date, sAmPm, hour, min, sec);
		
		calendar = new GregorianCalendar();
		timeZone = TimeZone.getTimeZone("Asia/Seoul");
		calendar.setTimeZone(timeZone);
		 year = calendar.get(Calendar.YEAR);
		 month = calendar.get(Calendar.MONTH)+1;
		 date = calendar.get(Calendar.DATE);
		 amPm = calendar.get(Calendar.AM_PM);
		 hour = calendar.get(Calendar.HOUR);
		 min = calendar.get(Calendar.MINUTE);
		 sec = calendar.get(Calendar.SECOND);
		 sAmPm = amPm == Calendar.AM ? "오전" : "오후";
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초\n", year, month, date, sAmPm, hour, min, sec);
	}

}
