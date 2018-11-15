package Chapter10;
import java.io.*;

public class WriterExmple1 {

	public static void main(String[] args) {

			FileWriter writer = null;
			
			try {	
				writer = new FileWriter("kk.txt");
				char chr[] = {'뇌','를', ' ', '자','극','하','는', ' ', '자','바'};
				for(int i=0; i<chr.length; i++)
					writer.write(chr[i]);
			}
			catch(IOException ioe) {
				System.out.println("파일을 출력할 수 없습니다");
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
