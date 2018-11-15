package Chapter11;

public class GoodStock {
	
		String goodsCode;
		int stockNum;
		
		GoodStock(String goodsCode, int stockNum){
			this.goodsCode = goodsCode;
			this.stockNum = stockNum;
		}
		
		public String toString() {
				
			String str = "상품코드 : " + goodsCode + " " + "재고수량 : " + stockNum;
			return str;
		}
				

}
