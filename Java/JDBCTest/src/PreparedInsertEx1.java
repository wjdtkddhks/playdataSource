import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedInsertEx1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		PreparedStatement ptmt = null;
		BufferedReader br = null;
		String hakbun, name, addr, phone, sql;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("MEMBER 테이블 입력하기,,,");
			System.out.print("학번 입력 >>>");
			hakbun = br.readLine();
			System.out.print("이름 입력 >>>");
			name = br.readLine();
			System.out.print("주소 입력 >>>");
			addr = br.readLine();
			System.out.print("전화번호 입력 >>>");
			phone = br.readLine();

			sql = "insert into member(hakbun, name, addr, phone) values(?,?,?,?)";

			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			System.out.println("데이터 베이스 연결 성공!");
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, hakbun);
			ptmt.setString(2, name);
			ptmt.setString(3, addr);
			ptmt.setString(4, phone);
			ptmt.executeUpdate();
			System.out.println("삽입 성공");
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (conn != null)
					conn.close();
				if (br != null)
					br.close();
			} catch (Exception ignored) {
			}
		}
	}
}
