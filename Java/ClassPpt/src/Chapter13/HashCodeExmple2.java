package Chapter13;

public class HashCodeExmple2 {

	public static void main(String[] args) {

			Name obj1 = new Name("헤르미온느", "그레인져");
			Name obj3 = new Name("헤르미온느", "그레인져");
			
			int hash1 = obj1.hashCode();
			int hash2 = obj3.hashCode();
			
			System.out.println(obj1.equals(obj3));
			
			System.out.println(hash1);
			System.out.println(hash2);
			
			Name obj6 = new Name("헤르미온느", "그레인져"); 
			Name obj7 = new Name("헤르미온느", "그레인져");
			
			int hash3 = obj6.hashCode();
			int hash4 = obj7.hashCode();
			
			System.out.println(hash3);
			System.out.println(hash4);
	}

}
