package Chapter14;
import java.io.*;

public class SystemExmple2 {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String str = reader.readLine();
			System.out.println(str);			
		}
		catch(IOException e) {
			System.out.println("키보드 입력 에러");
		}

	}

}
