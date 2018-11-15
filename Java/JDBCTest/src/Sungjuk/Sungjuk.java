package Sungjuk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sungjuk {

	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;

	boolean input() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		BufferedReader br = null;
		String sql = "select count(*) from sungjuk where hakbun =?";

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("학번입력 => ");
			this.hakbun = br.readLine().trim();

			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, hakbun);
			rs = ptmt.executeQuery();

			rs.next();
			if (rs.getInt(1) == 1) {
				System.out.println("해당학번은 존재합니다. 다시입력해주세요.");
				return true;
			}

			System.out.print("이름입력 => ");
			this.irum = br.readLine().trim();
			System.out.print("국어점수입력 => ");
			this.kor = Integer.parseInt(br.readLine());
			System.out.print("영어점수입력 => ");
			this.eng = Integer.parseInt(br.readLine());
			System.out.print("수학점수입력 => ");
			this.math = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("성적 입력 오류" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
		return false;
	}

	void process() {
		this.tot = kor + eng + math;
		this.avg = tot / 3.;

		switch ((int) avg / 10) {
		case 10:
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			break;
		}
	}

	void output() {
		System.out.printf("%4s   %3s    %3d     %3d      %3d     %3d    %6.2f    %2s\n", hakbun, irum, kor, eng, math,
				tot, avg, grade);
	}
}
