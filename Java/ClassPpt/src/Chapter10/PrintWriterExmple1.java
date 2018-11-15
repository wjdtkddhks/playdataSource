package Chapter10;
import java.io.*;
import java.util.*;
public class PrintWriterExmple1 {

	public static void main(String[] args) {

			PrintWriter writer = null;
			
			try {
				writer = new PrintWriter("output.txt");
				writer.println("    ***성적표***    ");
				writer.printf("%3s : %3d %3d %3d %5.1f \n", "김지영", 92, 87, 95, 91.3f);
				writer.printf("%3s : %3d %3d %3d %5.1f \n", "김지영", 92, 87, 95, 91.3f);
				writer.printf("%3s : %3d %3d %3d %5.1f \n", "최민재", 75, 88, 95, 91.3f);
				writer.printf("작성일자 : %1$d %2$tY년 %2$tm월 %2$td일", 10, new GregorianCalendar());
				
			}
			catch(IOException ioe) {
				System.out.print("파일을 출력할 수 없습니다.");
			}
			finally {
				try {
					writer.close();
				}
				catch(Exception e) {
					
				}
			}

	}

}
