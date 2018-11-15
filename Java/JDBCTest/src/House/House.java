package House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class House {
	int jip, deposit, price, love;
	String progress, life, loc, grade;
	Connection con = null;
	PreparedStatement ptmt = null;
	PreparedStatement ptmt2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;

	House() {
	}

	boolean input(Connection con, String sql) {
		int cnt = 0;
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if (!rs.next()) {
				System.out.println("입력된 매물이 없습니다.");
				return true;
			}
			System.out.println("\t\t\t *** 매물 현황 ***");
			System.out.println("=======================================");
			System.out.println(" 매물번호    집세형태    방종류     지역      보증금     월세     관심등급(등록수)");
			System.out.println("=======================================");
			do {
				jip = rs.getInt("JIP");
				progress = rs.getString("PROGRESS");
				life = rs.getString("LIFE");
				loc = rs.getString("LOC");
				deposit = rs.getInt("DEPOSIT");
				price = rs.getInt("PRICE");
				grade = rs.getString("GRADE").trim();
				love = rs.getInt("LOVE");
				cnt++;
				output();
			} while (rs.next());
			System.out.println("=======================================");
			System.out.printf("                                                            총 매물 갯수 : %d\n", cnt);
		} catch (Exception e) {
			System.out.println("매물출력 오류입니다.[House.input()]" + e.getMessage());
			System.out.println();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
			} catch (Exception ignored) {
			}
		}
		return false;
	}
	boolean input2(Connection con, String sql1, String sql2) {
		int cnt = 0;
		try {
			ptmt = con.prepareStatement(sql1);
			rs = ptmt.executeQuery();
			ptmt2 = con.prepareStatement(sql2);
			rs2 = ptmt2.executeQuery();

			if (!rs.next()) {
				System.out.println("입력된 매물이 없습니다.");
				return true;
			}
			System.out.println("\t\t\t *** 매물 현황 ***");
			System.out.println("=======================================");
			System.out.println(" 매물번호    집세형태    방종류     지역      보증금     월세     관심등급(등록수)");
			System.out.println("=======================================");
			do {
				jip = rs.getInt("JIP");
				progress = rs.getString("PROGRESS");
				life = rs.getString("LIFE");
				loc = rs.getString("LOC");
				deposit = rs.getInt("DEPOSIT");
				price = rs.getInt("PRICE");
				grade = rs.getString("GRADE").trim();
				love = rs.getInt("LOVE");
				cnt++;
				output();
			} while (rs.next());
			System.out.println("=======================================");
			rs2.next();
			do {
				jip = rs2.getInt("JIP");
				progress = rs2.getString("PROGRESS");
				life = rs2.getString("LIFE");
				loc = rs2.getString("LOC");
				deposit = rs2.getInt("DEPOSIT");
				price = rs2.getInt("PRICE");
				grade = rs2.getString("GRADE").trim();
				love = rs2.getInt("LOVE");
				cnt++;
				output();
			} while (rs2.next());
			System.out.println("=======================================");
			System.out.printf("                                                            총 매물 갯수 : %d\n", cnt);
		} catch (Exception e) {
			System.out.println("매물출력 오류입니다.[House.input()]" + e.getMessage());
			System.out.println();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (rs2 != null)
					rs2.close();
				if (ptmt2 != null)
					ptmt2.close();
			} catch (Exception ignored) {
			}
		}
		return false;
	}

	void output() {
		System.out.printf("  %4d      %3s       %3s     %3s   %6d    %4d          %s(%d)", jip, progress, life, loc,
				deposit, price, grade, love);
		System.out.println();
	}
	void output_mem() {
		System.out.printf("      %3s        %3s     %3s   %5d    %4d", progress, life, loc, deposit, price);
		System.out.println();
	}
}