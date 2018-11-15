package Chapter9;
import java.util.*;

public class StringTokenizerExmple3 {

	public static void main(String[] args) {

			StringTokenizer stok = new StringTokenizer("사과=10|초콜릿=3|샴페인=1", "=|",  true);
			
			while(stok.hasMoreTokens()) {
				String token = stok.nextToken();
			
				if(token.equals("="))
					System.out.print("\t");
				else if(token.equals("|"))
					System.out.print("\n");
				else
					System.out.print(token);
			}
	}

}
