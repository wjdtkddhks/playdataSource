package main;

import java.io.IOException;
import data.Message;

public class Process {

	private AccountManage account;
	private boolean mode;
	// ������ ��� �Ǻ� ����
	
	public Process() {
		account = new AccountManage();
		this.mode = false;
	}
	
	public boolean run() {
		
		String menuSelet = null;
		
		if (!mode) { // �Ϲ� ����� ���
			System.out.println(Message.mainManu);
			// ���� �޴� ���
			try {
				menuSelet = File_IO.keyRead();
				// Ű���� �Է� �Լ��� ����Ͽ� menuSelet�� �Է� �����͸� ����
			} catch (IOException e) {
				// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
				System.out.println(Message.error);
				return true;
			}

			switch (menuSelet.toLowerCase()) { // ��ҹ��ڷ� ���� ���ܸ� �����ϱ� ���� toLowerCase ���
				case "1":
					account.deposit();
					break;
				case "2":
					account.withdraw();
					break;
				case "3":
					account.transfer();
					break;
				case "4":
					account.lookup();
					break;
				case "admin":
					// admin ��ɾ� �Է½� ������ ��� ����
					admin(true);
					break;
				default:
					System.out.println(Message.error);
					break;
			}
			
		} else { // ������ ���
			System.out.println(Message.adminManu);
			// ������ �޴� ���
			try {
				menuSelet = File_IO.keyRead();
				// Ű���� �Է� �Լ��� ����Ͽ� menuSelet�� �Է� �����͸� ����
			} catch (IOException e) {
				// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
				System.out.println(Message.error);
				return true;
			}

			switch (menuSelet.toLowerCase()) {
				case "1":
					account.insert();
					break;
				case "2":
					account.delete();
					break;
				case "3":
					account.readAll();
					break;
				case "4":
					// ������ ��� ����
					admin(false);
					break;
				case "5":
					// ���α׷� ����
					System.out.println(Message.exit);
					return false;
				default:
					System.out.println(Message.error);
					break;
			}
		}
	
		return true;
	}


	private void admin(boolean mode) {
		this.mode = mode;
	}
}
