package com.ocs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.jsonpath.internal.Utils;
import com.ocs.ms.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = { "classpath:application.yml" })
@WebAppConfiguration
public class CoreTest {

	@Value("${TEST_VAL}")
	private String test;

	@Test
	public void test1(){
//		System.out.println(Utils./sayHello(test));
		System.out.println("test1");
	}
}
