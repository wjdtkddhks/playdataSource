package Sangpum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SangpumEx {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		PreparedStatement ptmt = null;
		BufferedReader br = null;
		ResultSet rs = null;
		int menu;
		boolean out;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "SCOTT", "123456");

			ab: while (true) {
				menu();
				try {
					System.out.print("메뉴선택(1~6) =>");
					menu = Integer.parseInt(br.readLine().trim());
					System.out.println();
				} catch (Exception e) {
					System.out.println("1~6사이의 수를 입력해주세요");
					System.out.println();
					continue;
				}

				if (menu == 6) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}

				switch (menu) {
				case 1: {
					out = input(br, conn, ptmt);
					if (out) {
						System.out.println("프로그램을 종료합니다.");
						break ab;
					}
					break;
				}
				case 2:
					output(conn, ptmt, rs);
					break;
				case 3:
					check(br, conn, ptmt, rs);
					break;
				case 4:
					change(br, conn, ptmt);
					break;
				case 5:
					delete(br, conn, ptmt);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
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

	public static void menu() {
		System.out.println("\t*** 메뉴 ***");
		System.out.println("1. 상품코드 입력");
		System.out.println("2. 상품      출력");
		System.out.println("3. 상품      조회");
		System.out.println("4. 상품      수정");
		System.out.println("5. 상품      삭제");
		System.out.println("6. 종            료");
		System.out.println();
	}

	public static boolean input(BufferedReader br, Connection conn, PreparedStatement ptmt) {

		try {
			System.out.print("코드입력 >>");
			String code = br.readLine().trim();
			if (code.equalsIgnoreCase("exit"))
				return true;
			System.out.print("상품명입력 >>");
			String irum = br.readLine();
			System.out.print("수량입력 >>");
			int su = Integer.parseInt(br.readLine().trim());
			System.out.print("단가입력 >>");
			int dan = Integer.parseInt(br.readLine().trim());
			int price = su * dan;

			String sql = "insert into sangpum(code, irum, su, dan, price) values(?,?,?,?,?)";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, code);
			ptmt.setString(2, irum);
			ptmt.setInt(3, su);
			ptmt.setInt(4, dan);
			ptmt.setInt(5, price);
			ptmt.executeUpdate();
			System.out.println("상품코드 : " + code + " 입력완료!");
			System.out.println();

		} catch (Exception e) {
			System.out.println("입력작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (Exception ignored) {
			}
		}
		return false;
	}

	public static void output(Connection conn, PreparedStatement ptmt, ResultSet rs) {
		int tot=0;
		try {
			String sql = "select * from sangpum order by code";
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (!rs.next()) {
				System.out.println("입력된 데이터가 없습니다.");
				System.out.println();
				return;
			}

			System.out.println("\t\t  ***해당 상품 ***");
			System.out.println("=========================");
			System.out.println(" 상품코드     상품명      수량       단가        금액");
			System.out.println("=========================");
			do {
				System.out.println("  " + rs.getString("code") + "     " + rs.getString("irum") + "       "
						+ rs.getInt("su") + "      " + rs.getInt("dan") + "    " + rs.getInt("price"));
				tot += rs.getInt("price");
			} while (rs.next());
			System.out.println("=========================");
			System.out.println("\t\t\t\t    총 합계 : " + tot);
			System.out.println();
		} catch (Exception e) {
			System.out.println("출력작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void check(BufferedReader br, Connection conn, PreparedStatement ptmt, ResultSet rs) {
		try {
			System.out.print("조회할 상품코드 입력 >>");
			String code = br.readLine().trim();

			String sql = "select * from sangpum where code = ?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, code);
			rs = ptmt.executeQuery();

			if (!rs.next()) {
				System.out.println("해당학번이 없습니다.");
				System.out.println();
				return;
			}

			System.out.println("\t\t  ***해당 상품 ***");
			System.out.println("=========================");
			System.out.println(" 상품코드     상품명      수량       단가        금액");
			System.out.println("=========================");
			System.out.println("  " + rs.getString("code") + "     " + rs.getString("irum") + "       "
						+ rs.getInt("su") + "      " + rs.getInt("dan") + "    " + rs.getInt("price"));
		
			System.out.println();
		} catch (Exception e) {
			System.out.println("조회작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void change(BufferedReader br, Connection conn, PreparedStatement ptmt) {
		try {
			System.out.print("수정할 상품 코드 입력 >>");
			String code = br.readLine().trim();
			System.out.print("수량 수정 >>");
			int su = Integer.parseInt(br.readLine().trim());
			System.out.print("단가 수정 >>");
			int dan = Integer.parseInt(br.readLine().trim());
			int price = su * dan;
			int res;

			String sql = "update sangpum set su=?, dan=?, price=? where code =?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, su);
			ptmt.setInt(2, dan);
			ptmt.setInt(3, price);
			ptmt.setString(4, code);
			res = ptmt.executeUpdate();
			if (res > 0)
				System.out.println("수정되었습니다.");
			else
				System.out.println("수정실패하였습니다. 확인해주세요");
			System.out.println();
		} catch (Exception e) {
			System.out.println("수정작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void delete(BufferedReader br, Connection conn, PreparedStatement ptmt) {
		try {
			System.out.print("삭제할 상품코드 입력 >>>");
			String code = br.readLine().trim();
			int res;

			String sql = "delete sangpum where code = ?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, code);
			res = ptmt.executeUpdate();
			if (res > 0)
				System.out.println("삭제되었습니다.");
			else
				System.out.println("삭제실패하였습니다. 확인해주세요");
			System.out.println();
		} catch (Exception e) {
			System.out.println("삭제작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
			} catch (Exception ignored) {
			}
		}
	}
}
