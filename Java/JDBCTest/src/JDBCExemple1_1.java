import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExemple1_1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("테이블 조회하기,,, ");
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("-------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("addr") + "\t");
				System.out.print(rs.getString("phone") + "\n");
			}
		} catch (Exception e) {
			System.out.println("데이터 연결 실패 !" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ignored) {
			}
		}
	}
}
