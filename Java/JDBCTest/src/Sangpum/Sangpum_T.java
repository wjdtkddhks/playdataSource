package Sangpum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sangpum_T {
	String code, irum;
	int su, dan, price;

	Sangpum_T() {
	}

	boolean input() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");

			System.out.print("상품코드 입력 =>");
			this.code = in.readLine();

			String sql = "select count(*) from sangpum where code = ?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, code);
			rs = ptmt.executeQuery();

			rs.next();
			if (rs.getInt(1) != 0) {
				System.out.println("\n상품코드 중복오류!!!\n");
				return true;}
				
			System.out.print("상품명 입력 =>");
			this.irum = in.readLine();
			System.out.print("수량 입력 =>");
			this.su = Integer.parseInt(in.readLine());
			System.out.print("단가 입력 =>");
			this.dan = Integer.parseInt(in.readLine());
		} catch (IOException ie) {
			System.out.println("input : 입력 오류!! :" +  ie.getMessage());
		}catch(Exception e) {
			System.out.println("데이터 베이스 연결 실패!! :" +  e.getMessage());
		}
		
		return false;
	}
	void process() {
		price = su* dan;
	}
	void output() {
		System.out.printf("%6s    %6s       %4d    %7d   %8d\n", code, irum, su, dan, price);
	}
}
