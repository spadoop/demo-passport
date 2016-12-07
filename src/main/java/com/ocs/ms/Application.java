package com.ocs.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ocs.ms.rpc.UserQueryServer;

@SpringBootApplication
public class Application {
	public static ApplicationContext ac;

	public static void main(String[] args) throws Exception{
		ac = SpringApplication.run(Application.class, args);
		final UserQueryServer server = new UserQueryServer();
		server.start();
		server.blockUntilShutdown();
	}
}
