
public interface MyInterface {
	public void method1();
	
	public default void method2() {
		
		System.out.println("MyInterface-Method2 실행");
	}
	
	public static void method3() {
		
		System.out.println("MyInterface-Method3 실행");
	}
	
}
