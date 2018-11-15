package Chapter14;

public class SystemExmple9 {

	public static void main(String[] args) {
		char chr1[] = {'가', '나', '다', '라', '마', '바', '사', '아', '자', '차', '카', '타', '파', '하'};
		char chr2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		System.arraycopy(chr1, 10, chr2, 2, 3);
		
		for(char chr : chr2)
			System.out.println(chr);

	}

}
