package config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import spring.ChangePasswordService;
import spring.MemberDao;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	
	@Bean(destroyMethod= "close")
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdb.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		ds.setJdbcUrl("dbc:mysql://localhost:3306/spring4fs?characterEncoding=utf8");
		ds.setUser("spring4");
		ds.setPassword("spring4");
		
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		
		return tm;
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService(memberDao());
	}

}
