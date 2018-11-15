package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import data.*;

public class AccountManage {
	// ���� ���� Ŭ����
	
	private ArrayList<Credit> account;
	// ���� ���� ����Ʈ
	private int num;
	// �Է� ������ ���� ����
	
	@SuppressWarnings("unchecked")
	public AccountManage() {

		this.num = 0;
		
		try {
			this.account = (ArrayList<Credit>) File_IO.read(Message.file);
			// ���� ����Ʈ�� ������ ���Ͽ��� �о��
		} catch (ClassNotFoundException | IOException e) {
			this.account = new ArrayList<Credit>();
			// ������ ���ų� �б� ������ ��� ���ο� ��ü�� ����
		}
	}

	public void deposit() {
		// �Ա� �޼���
		
		Credit credit = this.check();
		
		if (credit != null) {
			// ���� ������ ���������� �޾ƿ��� ��쿡�� �Ա�
			try {
				System.out.print(Message.deposit);
				// �Ա� �ݾ� �Է� �޼��� ���
				num = Integer.parseInt(File_IO.keyRead());
				// Ű���� �Է� �Լ��� ����Ͽ� num�� �ݾ��� ����
				credit.setBalance(credit.getBalance() + num);
				// �Ա� �Ϸ� �� �ܾ��� �����ش�.
				System.out.println(credit.getName() + Message.complete + credit.getBalance());
				// ���ŵ� ������ �����Ѵ�.
				File_IO.save(Message.file, this.account);
			} catch (IOException e) {
				// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
				System.out.println(Message.error);
			}
		}
	}
	
	
	public void withdraw() {
		// ��� �޼���

		Credit credit = this.check();
		
		if (credit != null) {
			// ���� ������ ���������� �޾ƿ��� ��쿡�� ���
			try {
				System.out.print(Message.withdraw);
				// ��� �ݾ� �Է� �޼��� ���
				num = Integer.parseInt(File_IO.keyRead());
				// Ű���� �Է� �Լ��� ����Ͽ� num�� �ݾ��� ����
				if (credit.getBalance() < num) {
					// ����Ϸ��� �ݾ��� ������ �ܾ׺��� ���� ��� ��� �Ұ���
					System.out.println(Message.balance_fault);
					return;
				}
				credit.setBalance(credit.getBalance() - num);
				// ��� �Ϸ� �� �ܾ��� �����ش�.
				System.out.println(credit.getName() + Message.complete + credit.getBalance());
				// ���ŵ� ������ �����Ѵ�.
				File_IO.save(Message.file, this.account);
			} catch (IOException e) {
				// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
				System.out.println(Message.error);
			}
		}
	}


	public void transfer() {
		// ��ü, �۱� �޼���

		Credit credit = this.check();
		
		if (credit != null) {
			// ���� ������ ���������� �޾ƿ��� ��쿡�� ��ü
			try {
				System.out.print(Message.transfer_account);
				// ���¹�ȣ �Է� �޼��� ���
				num = Integer.parseInt(File_IO.keyRead());
				// Ű���� �Է� �Լ��� ����Ͽ� num�� ���¹�ȣ�� ����
				for (Credit destination: this.account) {
					// ����Ʈ���� ��ġ�ϴ� ���¹�ȣ�� Ž��
					if (destination.getAccount() == num) {
						// ������ ���¹�ȣ�� ���� ������ ����Ʈ�� ���� ���
						System.out.print(Message.transfer_balance);
						// ��ü �ݾ� �Է� �޼��� ���
						num = Integer.parseInt(File_IO.keyRead());
						// Ű���� �Է� �Լ��� ����Ͽ� num�� �ݾ��� ����
						if (credit.getBalance() < num) {
							// ��ü�Ϸ��� �ݾ��� ������ �ܾ׺��� ���� ��� ��� �Ұ���
							System.out.println(Message.balance_fault);
							return;
						}
						credit.setBalance(credit.getBalance() - num);
						destination.setBalance(destination.getBalance() + num);
						// ��ü �Ϸ� �� �ܾ��� �����ش�.
						System.out.println(credit.getName() + Message.complete + credit.getBalance());
						// ���ŵ� ������ �����Ѵ�.
						File_IO.save(Message.file, this.account);
						return;
					}
				}
				// ���¹�ȣ�� ������ ���� ���� �޼��� ���
				System.out.println(Message.account_fault);
			} catch (IOException e) {
				// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
				System.out.println(Message.error);
			}
		}
	}
	
	
	public void lookup() {
		// ���� ��ȸ �޼���
		
		Credit credit = this.check();
		
		if (credit != null) {
			// ���� ������ ���������� �޾ƿ��� ��쿡�� ��ȸ
			System.out.println(credit.getName() + Message.complete + credit.getBalance());
		}
	}
	
	
	public void insert() {
		// ���� ��� �޼���
		Credit credit;
		StringTokenizer token;
		
		try {
			System.out.println(Message.insert);
			// ���� ��� �޼��� ���
			token = new StringTokenizer(File_IO.keyRead());
			// StringTokenizer ��ü�� �̿�, �Է¹��� ���ڿ��� ���� �������� �и�
			if (token.countTokens() != 3) {
				// �Է��� ������ 3���� ���ڿ��� �������� �ʴ� ��� �۾��� ����Ѵ�.
				System.out.println(Message.error);
				return;
			}
			credit = new Credit(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), token.nextToken());
			// ���� ��ü ����
			for (Credit compare: this.account) {
				// ����Ʈ���� �ߺ��� ���¹�ȣ�� Ž��
				if (credit.getAccount() == compare.getAccount()) {
					// ������ ���¹�ȣ�� ���� ������ ����Ʈ�� ���� ���
					System.out.print(Message.overlap);
					// �ߺ� ���� ���� �޼��� ��� �� ����
					return;
				}
			}
			this.account.add(credit);
			// ���ŵ� ������ �����Ѵ�.
			File_IO.save(Message.file, this.account);
		} catch (IOException e) {
			// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
			System.out.println(Message.error);
		}
	}

	
	public void delete() {
		// ���� ���� �޼���

		try {
			System.out.print(Message.accountcheck);
			// ���¹�ȣ �Է� �޼��� ���
			num = Integer.parseInt(File_IO.keyRead());
			// Ű���� �Է� �Լ��� ����Ͽ� num�� ���¹�ȣ�� ����
			for (Credit credit: this.account) {
				// ����Ʈ���� ��ġ�ϴ� ���¹�ȣ�� Ž��
				if (credit.getAccount() == num) {
					// ������ ���¹�ȣ�� ���� ������ ����Ʈ�� ���� ��� �ش� ���� ����
					this.account.remove(credit);
					// ���ŵ� ������ �����Ѵ�.
					File_IO.save(Message.file, this.account);
					// �ݺ����� �Ű������� account�� ����ϰ� �����Ƿ� ���� ������ �� �ݵ�� �ݺ����� ���������� ���־�� �Ѵ�.
					return;
				}
			}
			// ���¹�ȣ�� ���� ��� ���� ���� �޼��� ���
			System.out.println(Message.account_fault);
		} catch (IOException e) {
			// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
			System.out.println(Message.error);
		}
	}

	
	public void readAll() {
		// ��ü ���� ��ȸ �޼���
		
		for (Credit credit: this.account) {
			System.out.println(credit.getAccount()
					+ " �� " + credit.getPassword()
					+ " �� " + credit.getName()
					+ " �� " + credit.getBalance());
		}
		System.out.println();
	}
	

	public Credit check() {
		// ���� ���� �޼���

		try {
			System.out.print(Message.accountcheck);
			// ���¹�ȣ �Է� �޼��� ���
			num = Integer.parseInt(File_IO.keyRead());
			// Ű���� �Է� �Լ��� ����Ͽ� num�� ���¹�ȣ�� ����
			for (Credit credit: this.account) {
				// ����Ʈ���� ��ġ�ϴ� ���¹�ȣ�� Ž��
				if (credit.getAccount() == num) {
					// ������ ���¹�ȣ�� ���� ������ ����Ʈ�� ���� ���
					System.out.print(Message.passcheck);
					// ��й�ȣ �Է� �޼��� ���
					num = Integer.parseInt(File_IO.keyRead());
					// Ű���� �Է� �Լ��� ����Ͽ� num�� ��й�ȣ�� ����
					if (credit.getPassword() == num) {
						// �ش� ���� ������ ��й�ȣ ���� ��ġ�� ��� �ش� ���� ������ ���
						return credit;	
					}
				}
			}
			// ���¹�ȣ�� ���ų� ��й�ȣ�� Ʋ�� ��� ���� ���� �޼��� ���
			System.out.println(Message.account_fault);
		} catch (IOException e) {
			// IOException �߻��� �����޼��� ��� �� ó������ ���ư���.
			System.out.println(Message.error);
		}
		
		return null;
	}
}
