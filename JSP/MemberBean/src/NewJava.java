class Document{
	static int count=0;
	String name;
	
	Document(){
		this("제목없음" + ++count);
	}
	
	Document(String subject){
		this.name = subject;
		System.out.println("문서" + this.name + "생성되었습니다.");
	}
	
	
}

public class NewJava {

	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document("java");
		Document d3 = new Document();
		
	}

}
