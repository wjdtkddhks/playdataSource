
public class EmailSender extends MessageSender {

		String sendAddr;
		String emailBody;
		
	EmailSender(String title, String senderName, String sendAddr, String emailBody){
			
			super(title, senderName);
			this.sendAddr = sendAddr;
			this.emailBody = emailBody;
		}
	
	void sendMessage(String recipient) {
		
		System.out.println("-------------------");
		System.out.println("제목 :  " + title);
		System.out.println("보내는 사람 : " + senderName + " " + sendAddr);
		System.out.println("받는 사람 : " + recipient);
		System.out.println("내용 : " + emailBody);
		
	}
	
}
