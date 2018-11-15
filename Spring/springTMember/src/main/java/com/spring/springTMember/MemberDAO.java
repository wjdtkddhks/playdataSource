package com.spring.springTMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertMember(MemberVO memberVO) throws Exception
	{ 
		int result = 0;

		try
		{
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setInt(4, memberVO.getAge());
			pstmt.setString(5, memberVO.getGender());
			pstmt.setString(6, memberVO.getEmail());
			result = pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println("insertMember()" + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(pstmt, conn);
		}
		
		return result;
	}

	public int userCheck(MemberVO memberVO) throws Exception
	{
		String dbpasswd = "";

		int x = 1;

		try
		{
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, memberVO.getId());
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				dbpasswd = rs.getString("password");
				if(dbpasswd.equals(memberVO.getPassword()))
					x = 1;
				else
					x = 0;
			}
			else
				x = -1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(rs, pstmt, conn);
		}

		return x;
	}
	
	public ArrayList<MemberVO> getMemberlist() throws Exception
	{
		MemberVO memberdata = null;
		ArrayList<MemberVO> member_list = null;

		try
		{
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement("select * from member order by id");
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				member_list = new ArrayList<MemberVO>();
				do
				{
					memberdata = new MemberVO();
					memberdata.setId(rs.getString("id"));
					memberdata.setPassword(rs.getString("password"));
					memberdata.setName(rs.getString("name"));
					memberdata.setAge(rs.getInt("age"));
					memberdata.setGender(rs.getString("gender"));
					memberdata.setEmail(rs.getString("email"));
					
					member_list.add(memberdata);
				}while(rs.next());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(rs, pstmt, conn);
		}

		return member_list;
	}
	
	public MemberVO selectMember(MemberVO memberVO) throws Exception
	{ 
		MemberVO memberdata = null;

		try
		{
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, memberVO.getId());
			rs = pstmt.executeQuery();
			rs.next();
			
			memberdata = new MemberVO();
			memberdata.setId(rs.getString("id"));
			memberdata.setPassword(rs.getString("password"));
			memberdata.setName(rs.getString("name"));
			memberdata.setAge(rs.getInt("age"));
			memberdata.setGender(rs.getString("gender"));
			memberdata.setEmail(rs.getString("email"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		
		return memberdata;
	}

	public int deleteMember(MemberVO memberVO) throws Exception
	{ 
		int result = 0;

		try
		{
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement("delete from member where id = ?");
			pstmt.setString(1, memberVO.getId());
			result = pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(pstmt, conn);
		}
		
		return result;
	}

	public int updateMember(MemberVO memberVO) throws Exception
	{ 
		int result = 0;

		try
		{
			conn = JDBCUtil.getConnection();

			String sql = "update member set password=?, name=?, age=?, gender=?, email=? where id=?";
	  		pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPassword());
			pstmt.setString(2, memberVO.getName());
			pstmt.setInt(3, memberVO.getAge());
			pstmt.setString(4, memberVO.getGender());
			pstmt.setString(5, memberVO.getEmail());
			pstmt.setString(6, memberVO.getId());
			result = pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println("수정 오류" + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(pstmt, conn);
		}
		
		return result;
	}
}
