package Chapter10;
import java.io.*;
import java.util.GregorianCalendar;
public class FileExmple1 {

	public static void main(String[] args) {

			File file = new File(".");
			File arr[] = file.listFiles();
			for(int i=0; i<arr.length; i++)
			{
				String name = arr[i].getName();
				if(arr[i].isFile())
					System.out.printf("%-25s   %7d ", name, arr[i].length());
				else
					System.out.printf("%-25s     <DIR> ", name);
				
				long time = arr[i].lastModified();
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTimeInMillis(time);
				System.out.printf("%1$tF %1$tT \n", calendar);
			}
	}
}
