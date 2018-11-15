package First;

public class SungjukEquals {

	public static void main(String[] args) {

			Sungjuk obj1 = new Sungjuk();
			Sungjuk obj2 = new Sungjuk();

			obj1.input();
			obj2.input();
			
			if(obj1.equals(obj2))
				System.out.println("같음");
			else
			System.out.println("다름");
	}

}
