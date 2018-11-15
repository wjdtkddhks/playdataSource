package Chapter10;
import java.io.*;
public class FileDump {

	public static void main(String[] args) {
		if(args.length< 1)
			System.out.println("Usage: java FileDump <filename>");
		
		FileInputStream in = null;
		
		try 
		{
			in = new FileInputStream(args[0]);
			byte arr[] = new byte[16];
			
			while(true) {
				int num = in.read(arr);
				if(num<0)
					break;
				for(int i=0; i<arr.length; i++)
					System.out.printf("%02X ", arr[i]);
				System.out.println();	
			}
		}
			catch(FileNotFoundException fnfe) {
				System.out.println("파일을 찾을 수 없습니다");
			}
			catch(IOException ioe) {
				System.out.println("파일을 읽을 수 없습니다.");
			}
		finally
		{
			try {
				in.close();
			}
			catch(Exception e) {
				
			}
		}
	}
}
