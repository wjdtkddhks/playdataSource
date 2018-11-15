
public class SubscriberInfo {
	
	String name;
	String id;
	String password;
	String phoneNo;
	String address;
	
	SubscriberInfo(String name, String id, String password)
	{
		this.name = name;
		this.id = id;
		this.password = password;
	}
	
	SubscriberInfo(String name, String id, String password, String phoneNo, String address)
	{
		
		this(name, id, password);
		/*this.name = name;
		this.id = id;
		this.password = password;*/
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	void changePassword(String password)
	{
		this.password = password;
	}
	void setphoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	void setadress(String address)
	{
		this.address = address;
	}
	
		
		
}
