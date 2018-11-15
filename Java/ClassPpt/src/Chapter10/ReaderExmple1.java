package Chapter10;
import java.io.*;

public class ReaderExmple1 {

	public static void main(String[] args) {

			FileReader reader=null;
			try {
				reader = new FileReader("jjj.txt");
				
				while(true) 
				{
					int data = reader.read();
					if(data == -1)
						break;
					char chr = (char)data;
					System.out.print(chr);
				}
			}
			catch(FileNotFoundException fnfe) {
				System.out.println("파일이 존재하지 않습니다.");
			}
			catch(IOException ioe) {
				System.out.println("파일을 읽을 수 없습니다.");
			}
			finally{
				try {
					reader.close();
				}
				catch(Exception e) {
					
				}
			}
	}

}
