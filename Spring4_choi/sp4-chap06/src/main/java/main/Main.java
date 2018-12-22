package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfig2;
import spring.Client2;

public class Main {
	
	public static void main(String[] args) {
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:springcof2.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
		Client2 client  = ctx.getBean("client", Client2.class);
		Client2 client2  = ctx.getBean("client", Client2.class);
		System.out.println("client == client2 >> " + (client == client2));
		System.out.println("client : " + client);
		System.out.println("client2 : " + client2);
		ctx.close();
		
	}
}
