package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client2;

@Configuration
public class JavaConfig {
	
//	@Bean(initMethod="connect", destroyMethod="close")
	@Bean(destroyMethod="close")
	public Client2 client() throws Exception{
		Client2 cl = new Client2();
		cl.setHost("Java 서버");
		cl.connect();
		return cl;
	}
}
