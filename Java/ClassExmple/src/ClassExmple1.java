
public class ClassExmple1 {

	public static void main(String[] args) 
	{

			GoodStock obj;
			obj = new GoodStock("52135", 2000);
						
			//obj.goodCode = "52135";
			//obj.stockNum = 2000;
			
			System.out.println("상품코드 : " + obj.goodCode);
			System.out.println("재고량 : " + obj.stockNum);
			
			obj.addStock(10000);
			
			System.out.println("변경재고 : " + obj.stockNum);
			
			
			

	}

}
