import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCExample3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		Statement stmt = null;
		BufferedReader br = null;
		String hakbun, addr, phone, sql;
		int res;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("테이블 수정하기,,, ");
			System.out.print("수정할 학번 입력 >>");
			hakbun = br.readLine();
			System.out.print("주소 수정 >>");
			addr = br.readLine();
			System.out.print("번호 수정 >>");
			phone = br.readLine();

			sql = "update member set addr = '" + addr + "', phone = '" + phone + "' where hakbun = '" + hakbun + "'";

			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			System.out.println("데이터 베이스 연결 성공!");
			System.out.println(sql);
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
			if (res == 1)
				System.out.println("수정성공");
			else
				System.out.println("수정실패");
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
				if (br != null)
					br.close();
			} catch (Exception ignored) {
			}
		}
	}
}
