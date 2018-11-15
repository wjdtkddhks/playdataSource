
public class ConstrExmple2 {

	public static void main(String[] args) 
	{
		
		SubscriberInfo obj1, obj2;
		obj1 = new SubscriberInfo("연흥부", "poorman", "zebi");
		obj2 = new SubscriberInfo("연놀부", "richman", "money", "02-000-0000", "타워팰리스");
		
		printSubscriberInfo(obj1);
		printSubscriberInfo(obj2);
		
		obj1.setadress("은평구");
		System.out.printf("%s\n", obj1.address);
		
		printSubscriberInfo(obj1);
		
	}	
	static void printSubscriberInfo(SubscriberInfo obj)
	{
		System.out.println("name : " + obj.name);
		System.out.println("id : " + obj.id);
		System.out.println("password : " + obj.password);
		System.out.println("phoneNo : " + obj.phoneNo);
		System.out.println("address : " + obj.address);
		System.out.println();
			
	}
}
