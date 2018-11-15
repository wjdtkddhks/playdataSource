package main;

import java.io.*;

public class File_IO {
	// ���� ����� �� Ű���� �Է� ��� Ŭ����

	static public String keyRead() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		// Ű���� �Է� System.in ������ �̿��� InputStreamReader ��ü�� ����
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		// InputStreamReader ��ü�� ����Ʈ ������ ������ ó���ϹǷ� BufferedReader ��ü�� �̿��� ���� ������ ������ ó���� �� �ְ� ����
		return bufferedReader.readLine();
		// Ű����� �Է��� �� �� ������ �����͸� ��Ʈ������ ���
	}

	static public Object read(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		// FileInputStream ��ü�� �����Ͽ� ���� �̸��� �����Ͽ� ���� (���� -> ���α׷�)
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		// ����ȭ�� ���� BufferedInputStream ��ü�� ����
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		// ������ ������ �̸� �� �� �����Ƿ� Object ������ �޾ƿ��� ���� ObjectInputStream ��ü ���
		Object object = objectInputStream.readObject();
		// ������ ������ �����͸� Object�� ��ü�� �Űܿ´�. ���� ����ȯ�� �䱸��
		objectInputStream.close();
		// InputStream�� �ݾ��ش�
		return object;
	}
	
	static public void save(String fileName, Object object) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		// FileInputStream ��ü�� �����Ͽ� ���� �̸��� �����Ͽ� ���� (���α׷� -> ����)
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// ����ȭ�� ���� BufferedOutputStream ��ü�� ����
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
		// ����Ǵ� ������ ������ �ʿ䰡 ������ ObjectOutputStream ��ü ���
		objectOutputStream.writeObject(object);
		// �Ű������� Ŭ������ ������ �����ͷ� �Է��Ѵ�.
		objectOutputStream.close();
		// OutputStream�� �ݾ��ش�
	}
	
}
