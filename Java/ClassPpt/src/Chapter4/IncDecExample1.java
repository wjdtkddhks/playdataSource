package Chapter4;

public class IncDecExample1 {
	
		public static void main(String[] args) {
			
			int num1=0, num2=0, num3=0, num4 =0;
			
			int result1 = num1++;
			int result2 = ++num2;
			int result3 = num3--;
			int result4 = --num4;
			
			int result5 = result4 + num4--;
			
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
			System.out.println(result5);
			
			
			
			
		}

}
