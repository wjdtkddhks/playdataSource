package Chapter9;
import java.util.StringTokenizer;

public class StringTokenizerExmple {

	public static void main(String[] args) {

			StringTokenizer stok = new StringTokenizer("사과 배 복숭아");
			
			while(stok.hasMoreTokens()) {
				
				System.out.println(stok.nextToken());
			
			}
	}

}
