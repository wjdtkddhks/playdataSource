package Sangpum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SangpumJDBC_T {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int menu = 0;

		try {
			while (true) {
				System.out.println("\t*** 메뉴 ***");
				System.out.println("1. 상품코드 입력");
				System.out.println("2. 상품      출력");
				System.out.println("3. 상품      조회");
				System.out.println("4. 상품      수정");
				System.out.println("5. 상품      삭제");
				System.out.println("6. 종            료");
				System.out.println();
				
					System.out.print("메뉴선택(1~6) =>");
					menu = Integer.parseInt(in.readLine().trim());
					System.out.println();
				

				if (menu == 6) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}

				switch (menu) {
				case 1:
					input_sangpum();
					break;
				case 2:
					output_sangpum();
					break;
				case 3:
					search_sangpum();
					break;
				case 4:
					update_sangpum();
					break;
				case 5:
					delete_sangpum();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("main 입력오류 ");
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception ignored) {
			}
		}
	}

	static Connection getconnectDB() {
		Connection con = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}

	static void input_sangpum() {
		Sangpum_T obj = new Sangpum_T();
		System.out.println();
		if (obj.input())
			return;

		obj.process();

		Connection con = getconnectDB();
		PreparedStatement pstmt = null;
		String sql = "insert into sangpum values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.code);
			pstmt.setString(2, obj.irum);
			pstmt.setInt(3, obj.su);
			pstmt.setInt(4, obj.dan);
			pstmt.setInt(5, obj.price);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n상품 입력 성공!!!\n");

		} catch (Exception e) {
			System.out.println("\n상품 입력 실패!!!" + e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void output_sangpum() {
		Connection con = null;
		PreparedStatement ptmt1 = null;
		PreparedStatement ptmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String sql1 = "select count(*) from sangpum";
		String sql2 = "select * from sangpum order by code";

		con = getconnectDB();
		try {
			Sangpum_T obj = new Sangpum_T();
			ptmt1 = con.prepareStatement(sql1);
			rs1 = ptmt1.executeQuery();
			rs1.next();
			if (rs1.getInt(1) == 0)
				System.out.println("\n출력할 데이터가 없습니다.\n");
			else {
				ptmt2 = con.prepareStatement(sql2);
				rs2 = ptmt2.executeQuery();

				System.out.println();
				System.out.println("                         *** 판매현황 ***");
				System.out.println("===============================");
				System.out.println("상품코드        상품명         수량         단가          금액");
				System.out.println("===============================");
				while (rs2.next()) {
					obj.code = rs2.getString("code");
					obj.irum = rs2.getString("irum");
					obj.su = rs2.getInt("su");
					obj.dan = rs2.getInt("dan");
					obj.price = rs2.getInt("price");

					obj.output();
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("상품출력 실패!!!" + e.getMessage());
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (rs2 != null)
					rs2.close();
				if (ptmt1 != null)
					ptmt1.close();
				if (ptmt2 != null)
					ptmt2.close();
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void search_sangpum() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from sangpum where code =?";
		BufferedReader in = null;
		try {
			Sangpum_T obj = new Sangpum_T();
			in = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("\n조회할 상품코드입력 =>");
			String code = in.readLine();

			con = getconnectDB();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, code);
			rs = ptmt.executeQuery();

			if (rs.next()) {
				System.out.println("상품코드        상품명         수량         단가          금액");
				System.out.println("===============================");
				obj.code = rs.getString("code");
				obj.irum = rs.getString("irum");
				obj.su = rs.getInt("su");
				obj.dan = rs.getInt("dan");
				obj.price = rs.getInt("price");

				obj.output();
				System.out.println("===============================");
			} else {
				System.out.printf("\n%s는 존재하지 않는 상품입니다.", code);
			}
		} catch (Exception e) {
			System.out.println("search_sangpum 실패!!!" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	static void update_sangpum() {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "update sangpum set su=?, dan=?, price=? where code=?";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			Sangpum_T obj = new Sangpum_T();
			System.out.print("\n수정할 상품코드 입력 =>");
			obj.code = in.readLine();
			System.out.print("수량 입력 =>");
			obj.su = Integer.parseInt(in.readLine());
			System.out.print("단가 입력 =>");
			obj.dan = Integer.parseInt(in.readLine());
			obj.process();

			con = getconnectDB();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, obj.su);
			ptmt.setInt(2, obj.dan);
			ptmt.setInt(3, obj.price);
			ptmt.setString(4, obj.code);
			int res = ptmt.executeUpdate();
			if (res == 1)
				System.out.println("\n상품코드 " + obj.code + " 수정완료!");
			else
				System.out.printf("\n%s는 존재하지 않는 코드입니다.\n", obj.code);
		} catch (Exception e) {
			System.out.println("update_sangpum 실패!!!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
				System.out.println("닫기오류입니다.");
			}
		}
	}

	static void delete_sangpum() {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete sangpum where code=?";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			Sangpum_T obj = new Sangpum_T();
			System.out.print("\n수정할 상품코드 입력 =>");
			obj.code = in.readLine();

			con = getconnectDB();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, obj.code);
			int res = ptmt.executeUpdate();
			if (res == 1)
				System.out.println("\n상품코드 " + obj.code + " 삭제완료!");
			else
				System.out.printf("\n%s는 존재하지 않는 코드입니다.", obj.code);
		} catch (Exception e) {
			System.out.println("delete_sangpum 실패!!!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
				if (in != null)
					in.close();
			} catch (Exception ignored) {
			}
		}
	}
}
