package House_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HouseEx1 {

	public static void main(String[] args) {
		Connection con = null;
		BufferedReader br = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		int menu, menu_2;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName(driver);

			while (true) {
				con = DriverManager.getConnection(url, "SCOTT", "123456");
				menu();
				try {
					System.out.print("메뉴 입력 >>");
					menu = Integer.parseInt(br.readLine());
				} catch (Exception e) {
					System.out.println("위 해당하는 숫자를 입력해주세요");
					System.out.println();
					continue;
				}

				if (menu == 7) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}

				switch (menu) {
				case 1:
					make_member(con);
					break;
				case 2: {
					System.out.print("1)전체보기\n2)거주지역 우선 보기\n>> ");
					menu_2 = Integer.parseInt(br.readLine());
					if (menu_2 == 1)
						all_output_house(con);
					else
						output_house(con, br);
					break;
				}
				case 3:
					make_interest(con, br);
					break;
				case 4:
					change_interest(con, br);
					break;
				case 5:
					delete_interest(con, br);
					break;
				case 6:
					delete_member(con, br);
					break;
				case 8:
					output_member(con);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("main 오류입니다." + e.getMessage());
			System.out.println();
		} finally {
			try {
				if (con != null)
					con.close();
				if (br != null)
					br.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void menu() {
		System.out.println("  <<<다나와방>>>");
		System.out.println("    *** 메뉴 ***");
		System.out.println("  1.  회   원   등  록");
		System.out.println("  2.  매   물   확  인");
		System.out.println("  3.  관심상품  등록");
		System.out.println("  4.  관심상품  변경");
		System.out.println("  5.  관심상품  삭제");
		System.out.println("  6.  회   원   삭  제");
		System.out.println("  7.  종             료");
		System.out.println(" === 관 리 자 ===");
		System.out.println("  8.  회   원   출  력");
	}

	static boolean idCheck(Connection con, String id) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from club where id = ?";

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				System.out.println("해당아이디가 없습니다. 확인해주세요.");
				System.out.println();
				return true;
			}
		} catch (Exception e) {
			System.out.println("아이디중복체크 오류입니다.[idCheck()]" + e.getMessage());
			System.out.println();
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

	static void make_member(Connection con) {
		Member obj = new Member();
		PreparedStatement ptmt = null;
		String sql = "insert into club(id, age, addr, fam, inter) values(?, ?, ?, ?, 0)";

		if (obj.input())
			return;

		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, obj.id);
			ptmt.setInt(2, obj.age);
			ptmt.setString(3, obj.addr);
			ptmt.setInt(4, obj.fam);
			int res = ptmt.executeUpdate();

			if (res == 1)
				System.out.printf("해당 아이디 %s 등록완료!!!\n\n", obj.id);
			else
				System.out.printf("해당 아이디 %s 등록실패!!!\n\n", obj.id);

		} catch (Exception e) {
			System.out.println("회원등록 오류입니다.[make_member()]" + e.getMessage());
			System.out.println();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void all_output_house(Connection con) {
		House ho = new House();
		String sql = "select jip, progress, life, loc, deposit, price, grade, house.love from house, livegrade "
				+ "where love between low and high and jip <>0 order by jip";
		try {
			if (ho.input(con, sql))
				return;
		} catch (Exception e) {
			System.out.println("매물출력 오류입니다.[output_house()]" + e.getMessage());
			System.out.println();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void output_house(Connection con, BufferedReader br) {
		House ho = new House();
		String id;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(" 아이디 입력 >>");
			id = br.readLine();

			String sql1 = "select distinct jip, progress, life, loc, deposit, price, grade, house.love from house, livegrade, club "
					+ "where house.loc =  (select addr from club where id = '" + id
					+ "') and love between low and high and jip <>0 order by jip";
			String sql2 = "select distinct jip, progress, life, loc, deposit, price, grade, house.love from house, livegrade, club "
					+ "where house.loc !=  (select addr from club where id = '" + id
					+ "') and love between low and high and jip <>0 order by jip";
			if (ho.input2(con, sql1, sql2))
				return;

		} catch (Exception e) {
			System.out.println("매물출력 오류입니다.[output_house()]" + e.getMessage());
			System.out.println();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ignored) {
			}
		}
	}

	static void make_interest(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		String sql = "update club set inter = ? where id= ?";
		String id;
		int inter, res;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n *** 관심매물등록 ***");
			System.out.print(" 아이디 입력 >>");
			id = br.readLine();
			if (idCheck(con, id))
				return;
			System.out.print(" 관심 매물번호 >>");
			inter = Integer.parseInt(br.readLine());

			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, inter);
			ptmt.setString(2, id);
			res = ptmt.executeUpdate();

			if (res == 1)
				System.out.printf("해당 아이디 %s, 매물번호 %d 관심등록하였습니다.\n\n", id, inter);
			else
				System.out.printf("등록실패하였습니다, 다시 확인해주세요.\n\n", id, inter);

		} catch (Exception e) {
			System.out.println("관심등록 오류입니다.[make_interest()]" + e.getMessage());
			System.out.println();
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

	static void change_interest(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		String sql = "update club set inter = ? where id = ?";
		String id;
		int inter, res;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n *** 관심매물변경 ***");
			System.out.print("아이디 입력 >>");
			id = br.readLine();
			if (idCheck(con, id))
				return;
			System.out.print("변경하고 싶은 매물 번호 입력 >>");
			inter = Integer.parseInt(br.readLine());

			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, 0);
			ptmt.setString(2, id);
			res = ptmt.executeUpdate();
			if (res == 0) {
				System.out.println("변경실패하였습니다.");
				return;
			}

			ptmt.setInt(1, inter);
			ptmt.setString(2, id);
			res = ptmt.executeUpdate();
			if (res == 1)
				System.out.printf("해당 아이디 %s, 매물번호 %d로 관심변경하였습니다.\n\n", id, inter);
			else
				System.out.println("등록실패하였습니다, 다시 확인해주세요.\n");

		} catch (Exception e) {
			System.out.println("관심매물변경 오류입니다.[change_interest()]" + e.getMessage());
			System.out.println();
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

	static void delete_interest(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		String sql = "update club set inter = 0 where id = ?";
		String id;
		int res;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" *** 관심매물삭제 ***");
			System.out.print("아이디 입력 >>");
			id = br.readLine();
			if (idCheck(con, id))
				return;

			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			res = ptmt.executeUpdate();
			if (res == 1)
				System.out.printf("해당 아이디 %s, 관심매물 삭제하였습니다.\n\n", id);
			else
				System.out.println("등록실패하였습니다, 다시 확인해주세요.\n");

		} catch (Exception e) {
			System.out.println("관심매물삭제 오류입니다.[delete_interest()]" + e.getMessage());
			System.out.println();
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

	static void delete_member(Connection con, BufferedReader br) {
		PreparedStatement ptmt = null;
		String sql = "delete club where id = ?";
		String id;
		int res;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n *** 회원삭제 ***");
			System.out.print("아이디 입력 >>");
			id = br.readLine();

			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			res = ptmt.executeUpdate();
			if (res == 1)
				System.out.printf("해당 아이디 %s, 삭제하였습니다.\n\n", id);
			else
				System.out.println("삭제실패하였습니다, 다시 확인해주세요.\n");

		} catch (Exception e) {
			System.out.println("회원삭제 오류입니다.[delete_member()]" + e.getMessage());
			System.out.println();
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

	static void output_member(Connection con) {
		Member mem = new Member();
		House ho = new House();
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select id, age, addr, fam, inter, progress, life, loc, deposit, price "
				+ "from club, house where club.inter = house.jip order by id";
		int cnt = 0;
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (!rs.next()) {
				System.out.println("등록된 회원이 없습니다.");
				return;
			}

			System.out.println("\t\t\t *** 매물 현황 ***");
			System.out.println("==================================================");
			System.out.println("  아이디      나이       주소     가족형태      관심매물     집세형태    방종류     지역      보증금     월세");
			System.out.println("==================================================");
			do {
				cnt++;
				mem.id = rs.getString("id");
				mem.age = rs.getInt("age");
				mem.addr = rs.getString("addr");
				mem.fam = rs.getInt("fam");
				mem.inter = rs.getInt("inter");
				mem.output();
				if (mem.inter == 0) {
					System.out.println();
					continue;
				} else {
					ho.progress = rs.getString("progress");
					ho.life = rs.getString("life");
					ho.loc = rs.getString("loc");
					ho.deposit = rs.getInt("deposit");
					ho.price = rs.getInt("price");
					ho.output_mem();
				}
			} while (rs.next());
			System.out.println("==================================================");
			System.out.printf(
					"                                                                                            총 회원 수 : %d\n",
					cnt);

		} catch (Exception e) {
			System.out.println("회원출력 오류입니다.[output_member()]" + e.getMessage());
			System.out.println();
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
}
