package com.lysky.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.lysky.ms.rpc.UserQueryServer;

@SpringBootApplication
public class PassportApplication {
	public static ApplicationContext ac;

	public static void main(String[] args) throws Exception{
		ac = SpringApplication.run(PassportApplication.class, args);
		final UserQueryServer server = new UserQueryServer();
		server.start();
		server.blockUntilShutdown();
	}
}
