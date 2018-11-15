import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedUpdateEx1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		PreparedStatement ptmt = null;
		BufferedReader br = null;
		String hakbun, addr, phone, sql;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("MEMBER 테이블 수정하기,,,");
			System.out.print("수정할 학번 입력 >>>");
			hakbun = br.readLine();
			System.out.print("주소 입력 >>>");
			addr = br.readLine();
			System.out.print("전화번호 입력 >>>");
			phone = br.readLine();

			sql = "update member set addr = ?, phone = ? where hakbun = ?";

			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			System.out.println("데이터 베이스 연결 성공!");
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, phone);
			ptmt.setString(3, hakbun);
			ptmt.executeUpdate();
			System.out.println("수정 성공");
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
