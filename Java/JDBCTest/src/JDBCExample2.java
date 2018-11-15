import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCExample2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		Statement stmt = null;
		BufferedReader br = null;

		String hakbun, name, add, phone;
		String sql = "Insert into member(hakbun, name, addr, phone) values ";
		int res;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("member 테이블 추가하기,,,");

			System.out.print("학번입력 >> ");
			hakbun = br.readLine();
			System.out.print("이름입력 >> ");
			name = br.readLine();
			System.out.print("주소입력 >> ");
			add = br.readLine();
			System.out.print("전화번호입력 >> ");
			phone = br.readLine();

			sql += "('" + hakbun + "', '" + name + "', '" + add + "', '" + phone + "')";
			System.out.println(sql);

			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);

			if (res == 1)
				System.out.println("삽입성공");
			else
				System.out.println("삽입실패");
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 !" + e.getMessage());
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
