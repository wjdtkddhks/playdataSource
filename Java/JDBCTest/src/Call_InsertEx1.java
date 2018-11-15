import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Call_InsertEx1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		CallableStatement ctmt = null;
		BufferedReader br = null;
		String hakbun, name, addr, phone;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("테이블 삽입하기,,,");
			System.out.print("학번 입력>>");
			hakbun = br.readLine();
			System.out.print("이름 입력>>");
			name = br.readLine();
			System.out.print("주소 입력>>");
			addr = br.readLine();
			System.out.print("전화번호 입력>>");
			phone = br.readLine();

			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			System.out.println("데이터 베이스 연결 성공!");
			ctmt = conn.prepareCall("{call call_insert(?,?,?,?)}");
			ctmt.setString(1, hakbun);
			ctmt.setString(2, name);
			ctmt.setString(3, addr);
			ctmt.setString(4, phone);
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
			} catch (Exception e2) {
			}
		}
	}
}
