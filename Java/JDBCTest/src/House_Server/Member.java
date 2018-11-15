package House_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Member {
	String id, addr;
	int age, fam, inter = 0;
	BufferedReader br = null;
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String sql = "select count(*) from club where id = ?";

	Member() {
	}

	boolean input() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("아이디 입력 =>");
			id = br.readLine();
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			rs.next();

			if (rs.getInt(1) == 1) {
				System.out.println("해당 아이디는 존재합니다. 다시 입력해주세요.");
				System.out.println();
				return true;
			}

			System.out.print("나이 입력 =>");
			age = Integer.parseInt(br.readLine());
			System.out.print("주소 입력('동'만 입력) =>");
			addr = br.readLine();
			System.out.print("몇인가족이신가요?(숫자만 입력) =>");
			fam = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			System.out.println("회원등록 오류입니다.[member.input()]" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
		return false;
	}
	void output() {
		System.out.printf(" %5s     %3d    %4s    %d인가족      %4d", id, age, addr, fam, inter);
	}
}
