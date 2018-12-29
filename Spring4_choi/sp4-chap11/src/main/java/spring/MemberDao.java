package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL=?", 
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
						Member member = new Member(rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						return member;
					}
				}, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values(?,?,?,?)", 
						new String[] {"ID"}); // 자동으로 생성하는 키목록 지정
				
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getPassword());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return pstmt;
			}
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
		
		
//		jdbcTemplate.update(
//				"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values(?,?,?,?)",
//				member.getName(), member.getPassword(), member.getEmail(),
//				new Timestamp(member.getRegisterDate().getTime()));
	}
	
	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME=?, PASSWORD=? where EMAIL=?",
				member.getName(), member.getPassword(), member.getEmail());

	}
	
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
						Member member = new Member(rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						
						return member;
					}
				});
		
		return results;
	}
	
	public int count() { //queryForObject 반드시 결과가 한행이어야 한다. 3번째 인자부터는 쿼리 ? 로 대입 가능한 인자
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		
		return count;
	}

}
//public Collection<Member> selectAll(){
//	List<Member> results = jdbcTemplate.query("select * from MEMEBER", 
//			new MemberRowMapper());
//	
//	return results;
//}

//class MemberRowMapper implements RowMapper<Member>{
//	@Override
//	public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
//		Member member = new Member(rs.getString("EMAIL"),
//				rs.getString("PASSWORD"),
//				rs.getString("NAME"),
//				rs.getTimestamp("REGDATE"));
//		member.setId(rs.getLong("ID"));
//		
//		return member;
//	}
//}
