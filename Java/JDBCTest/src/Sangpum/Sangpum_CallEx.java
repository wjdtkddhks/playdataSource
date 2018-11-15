package Sangpum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Sangpum_CallEx {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection conn = null;
		CallableStatement ctmt = null;
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
					out = input(br, conn, ctmt);
					if (out) {
						System.out.println("프로그램을 종료합니다.");
						break ab;
					}
					break;
				}
				case 2:
					output(conn, ctmt, rs);
					break;
				case 3:
					check(br, conn, ctmt, rs);
					break;
				case 4:
					change(br, conn, ctmt);
					break;
				case 5:
					delete(br, conn, ctmt);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
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

	public static boolean input(BufferedReader br, Connection conn, CallableStatement ctmt) {

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

			ctmt = conn.prepareCall("{call sangpum_input(?,?,?,?,?)}");
			ctmt.setString(1, code);
			ctmt.setString(2, irum);
			ctmt.setInt(3, su);
			ctmt.setInt(4, dan);
			ctmt.setInt(5, price);
			ctmt.executeUpdate();
			System.out.println("상품코드 : " + code + " 입력완료!");
			System.out.println();

		} catch (Exception e) {
			System.out.println("입력작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ctmt != null)
					ctmt.close();
			} catch (Exception ignored) {
			}
		}
		return false;
	}

	public static void output(Connection conn, CallableStatement ctmt, ResultSet rs) {
		int tot=0;
		try {
			ctmt = conn.prepareCall("{call sangpum_output(?)}");
			ctmt.registerOutParameter(1, OracleTypes.CURSOR);
			ctmt.executeQuery();
			rs = (ResultSet) ctmt.getObject(1);

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
				if (ctmt != null)
					ctmt.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void check(BufferedReader br, Connection conn, CallableStatement ctmt, ResultSet rs) {
		try {
			System.out.print("조회할 상품코드 입력 >>");
			String code = br.readLine().trim();

			ctmt = conn.prepareCall("{call sangpum_check(?,?)}");
			ctmt.registerOutParameter(1, OracleTypes.CURSOR);
			ctmt.setString(2, code);
			ctmt.executeQuery();
			rs = (ResultSet) ctmt.getObject(1);

			if (!rs.next()) {
				System.out.println("해당데이터가 없습니다. 확인해주세요.");
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
				if (ctmt != null)
					ctmt.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void change(BufferedReader br, Connection conn, CallableStatement ctmt) {
		try {
			System.out.print("수정할 상품 코드 입력 >");
			String code = br.readLine().trim();
			System.out.print("수량 수정 >>");
			int su = Integer.parseInt(br.readLine().trim());
			System.out.print("단가 수정 >>");
			int dan = Integer.parseInt(br.readLine().trim());
			int price = su * dan;
			int res;

			ctmt = conn.prepareCall("{call sangpum_change(?,?,?,?)}");
			ctmt.setInt(1, su);
			ctmt.setInt(2, dan);
			ctmt.setInt(3, price);
			ctmt.setString(4, code);
			res = ctmt.executeUpdate();
			if (res > 0)
				System.out.println("수정되었습니다.");
			else
				System.out.println("수정실패하였습니다. 확인해주세요");
			System.out.println();
		} catch (Exception e) {
			System.out.println("수정작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ctmt != null)
					ctmt.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void delete(BufferedReader br, Connection conn, CallableStatement ctmt) {
		try {
			System.out.print("삭제할 상품코드 입력 >>>");
			String code = br.readLine().trim();
			int res;

			ctmt = conn.prepareCall("{call sangpum_delete(?)");
			ctmt.setString(1, code);
			res = ctmt.executeUpdate();
			if (res > 0)
				System.out.println("삭제되었습니다.");
			else
				System.out.println("삭제실패하였습니다. 확인해주세요");
			System.out.println();
		} catch (Exception e) {
			System.out.println("삭제작업 시 에러발생!" + e.getMessage());
		} finally {
			try {
				if (ctmt != null)
					ctmt.close();
			} catch (Exception ignored) {
			}
		}
	}
}
