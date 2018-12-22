package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client2;

@Configuration
public class JavaConfig2 {
	
	@Bean(initMethod="connect", destroyMethod="close")
	@Scope("prototype")
	public Client2 client() {
		Client2 cl = new Client2();
		cl.setHost("protoTest");
		return cl;
	}
}
