package Chapter9;

public class ClassExmple3 {

	public static void main(String[] args) {
		String str = "뇌를 자극하는 자바";
		System.out.println(str.substring(3));
		System.out.println(str.substring(3, 7));
		
		String str1 = "   Let it be   ";
		String str2 = str1.trim();
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str2.concat(" Speaking words of wisdom "));
		System.out.println(str2.toUpperCase());
		System.out.println(str2.toLowerCase());
		System.out.println(str2.replace('e', 'a'));
		System.out.println(str1);
		System.out.println(str2);
		
	}

}
