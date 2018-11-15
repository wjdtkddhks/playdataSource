import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Call_UpdateEx1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		CallableStatement ctmt = null;
		BufferedReader br = null;
		String hakbun, addr, phone;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("테이블 수정하기,,,");
			System.out.print("수정할 학번 입력>>>");
			hakbun = br.readLine();
			System.out.print("주소 수정 >>>");
			addr = br.readLine();
			System.out.print("번호 수정 >>>");
			phone = br.readLine();

			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			System.out.println("데이터 베이스 연결 성공!");
			ctmt = conn.prepareCall("{call call_update(?,?,?)}");
			ctmt.setString(1, hakbun);
			ctmt.setString(2, addr);
			ctmt.setString(3, phone);
			ctmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!" + e.getMessage());
		} finally {
			try {
				if (ctmt != null)
					ctmt.close();
				if (conn != null)
					conn.close();
				if (br != null)
					br.close();
			} catch (Exception ignored) {
			}
		}
	}
}
