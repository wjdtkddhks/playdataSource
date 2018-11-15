package Sungjuk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SungjukJDBC2 {

	public static void main(String[] args) {
		Connection con = null;
		BufferedReader br = null;
		int menu = 0;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "SCOTT", "123456");
				menu_sungjuk();
				try {
					System.out.print("메뉴입력(1~6) : ");
					menu = Integer.parseInt(br.readLine().trim());
					//br.skip('\n');
					System.out.println();
				} catch (Exception e) {
					System.out.println("1~6사이의 수를 입력해주세요.");
					System.out.println();
					//br.skip('\n');
					continue;
				}
				if (menu == 6) {
					System.out.println("프로그램이 종료됩니다.");
					break;
				}
				switch (menu) {
				case 1:
					input_sungjuk(con);
					break;
				case 2:
					output_sungjuk(con);
					break;
				case 3:
					search_sungjuk(con, br);
					break;
				case 4:
					change_sungjuk(con, br);
					break;
				case 5:
					delete_sungjuk(con, br);
					break;
				default:
					System.out.println("1~6사이의 수를 입력해주세요.");
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("main 오류입니다." + e.getMessage());
		}finally {
			try {
				if (con != null)
					con.close();
				if (br != null)
					br.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void menu_sungjuk() {
		System.out.println("  *** 메 뉴 ***");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 성적 조회");
		System.out.println("4. 성적 수정");
		System.out.println("5. 성적 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	static void input_sungjuk(Connection con) {
		PreparedStatement ptmt = null;
		Sungjuk obj = new Sungjuk();
		String sql = "insert into sungjuk values(?,?,?,?,?,?,?,?)";

		if (obj.input()) {
			System.out.println("해당학번은 존재합니다. 다시 입력해주세요.\n");
			return;
		}
		obj.process();

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, obj.hakbun);
			ptmt.setString(2, obj.irum);
			ptmt.setInt(3, obj.kor);
			ptmt.setInt(4, obj.eng);
			ptmt.setInt(5, obj.math);
			ptmt.setInt(6, obj.tot);
			ptmt.setDouble(7, obj.avg);
			ptmt.setString(8, obj.grade);
			ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("성적 입력 오류입니다." + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void output_sungjuk(Connection con) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int cnt = 0;
		double total_avg = 0;
		String sql = "select * from sungjuk order by hakbun";
		Sungjuk obj = new Sungjuk();
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (!rs.next()) {
				System.out.println("해당데이터가 없습니다.");
				return;
			}
			System.out.println("\n\t\t *** 성적표 ***");
			System.out.println("====================================");
			System.out.println("  학번       이름      국어      영어      수학      총점        평균      등급");
			System.out.println("====================================");
			do {
				obj.hakbun = rs.getString("hakbun");
				obj.irum = rs.getString("irum");
				obj.kor = rs.getInt("kor");
				obj.eng = rs.getInt("eng");
				obj.math = rs.getInt("math");
				obj.tot = rs.getInt("tot");
				obj.avg = rs.getDouble("avg");
				obj.grade = rs.getString("grade");

				obj.output();
				cnt++;
				total_avg += obj.avg;
			} while (rs.next());
			System.out.println("====================================");
			System.out.printf("\t\t\t학생수  : %d, 전체평균 : %5.2f\n", cnt, total_avg / cnt);
		} catch (Exception e) {
			System.out.println("성적 출력 오류입니다." + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}

	static void search_sungjuk(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		Sungjuk obj = new Sungjuk();
		String sql = "select * from sungjuk where hakbun =?";
		
		try {
			System.out.print("조회할 학번입력 => ");
			String hakbun = br.readLine();

			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, hakbun);
			rs = ptmt.executeQuery();

			if (rs.next()) {
				System.out.println("\n\t\t *** 해당 학생 성적표 ***");
				System.out.println("====================================");
				System.out.println("  학번     이름      국어      영어      수학      총점        평균      등급");
				System.out.println("====================================");
				obj.hakbun = rs.getString("hakbun");
				obj.irum = rs.getString("irum");
				obj.kor = rs.getInt("kor");
				obj.eng = rs.getInt("eng");
				obj.math = rs.getInt("math");
				obj.tot = rs.getInt("tot");
				obj.avg = rs.getDouble("avg");
				obj.grade = rs.getString("grade");
				obj.output();
				System.out.println("====================================");
				System.out.println();
			} else {
				System.out.println("해당 학번은 없습니다. 다시 확인해주세요.");
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("성적 조회 오류입니다." + e.getMessage());
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
	}

	static void change_sungjuk(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		Sungjuk obj = new Sungjuk();
		String sql = "update sungjuk set kor = ?, eng = ?, math = ?, tot=?, avg=?, grade=? where hakbun =?";

		try {
			System.out.print("수정할 학번입력 => ");
			obj.hakbun = br.readLine().trim();
			System.out.print("국어점수입력 => ");
			obj.kor = Integer.parseInt(br.readLine());
			System.out.print("영어점수입력 => ");
			obj.eng = Integer.parseInt(br.readLine());
			System.out.print("수학점수입력 => ");
			obj.math = Integer.parseInt(br.readLine());
			obj.process();

			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, obj.kor);
			ptmt.setInt(2, obj.eng);
			ptmt.setInt(3, obj.math);
			ptmt.setInt(4, obj.tot);
			ptmt.setDouble(5, obj.avg);
			ptmt.setString(6, obj.grade);
			ptmt.setString(7, obj.hakbun);
			int res = ptmt.executeUpdate();

			if (res == 1)
				System.out.printf("학번 %s 수정완료하였습니다.", obj.hakbun);
			else
				System.out.println("해당 학번은 없습니다.");
			System.out.println();
		} catch (Exception e) {
			System.out.println("성적 수정 오류입니다." + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void delete_sungjuk(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		String sql = "delete sungjuk where hakbun = ?";

		try {
			System.out.print("삭제할 학번입력 => ");
			String hakbun = br.readLine().trim();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, hakbun);
			int res = ptmt.executeUpdate();

			if (res == 1)
				System.out.printf("학번 %s 삭제완료하였습니다.", hakbun);
			else
				System.out.println("해당 학번은 없습니다.");
			System.out.println();
		} catch (Exception e) {
			System.out.println("성적 삭제 오류입니다." + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}
}
