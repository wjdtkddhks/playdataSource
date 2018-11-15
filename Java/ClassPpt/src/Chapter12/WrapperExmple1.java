package Chapter12;

public class WrapperExmple1 {

	public static void main(String[] args) {
			
		
			Byte obj = new Byte((byte)12);
			int num = obj.byteValue();
			System.out.println(num);
			
			Integer obj1 = new Integer(123);
			Integer obj2 = new Integer(456);
			
			int sum = obj1.intValue() + obj2.intValue();
			System.out.println(sum);
			System.out.println(obj2.intValue()-obj1.intValue());
			

			int tot=0;
			
			for(int i =0; i<args.length; i++)
				{Integer obj4 = new Integer(args[i]);
					tot += obj4.intValue();
				}
			System.out.println(tot);
			
			for(int i=0; i<args.length; i++)
			{
				tot += Integer.parseInt(args[i]);
			}
			System.out.println(tot);
	}

}
