package spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.spring1.HelloService;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx 
			= new ClassPathXmlApplicationContext("META-INF/beans.xml");
//		HelloService helloSvc = ctx.getBean(HelloService.class);
//		System.out.println(helloSvc.getGreetings());
		
		System.out.println(ctx.getBean(HelloService.class).getGreetings());
		System.out.println(ctx.getBean(HelloService.class).getGreetings());
		System.out.println(ctx.getBean(HelloService.class).getGreetings());
		System.out.println(ctx.getBean(HelloService.class).getGreetings());
		ctx.registerShutdownHook();
		
	}

}
