package com.ocs.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ocs.ms.PassportApplication;
import com.ocs.ms.rest.UserLofinInfoController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PassportApplication.class)
@TestPropertySource(locations = { "classpath:application.yml" })
@WebAppConfiguration
public class CoreTest {
	@Resource
	private UserLofinInfoController loginController;
	
	
	
	@Value("${TEST_VAL}")
	private String test;

	@Test
	public void test1(){
//		System.out.println(Utils./sayHello(test));
		System.out.println("test1");
	}
	
	@Test  
    public void testLogin() throws Exception {  
		System.out.println("testLogin run");
        MockHttpServletRequest request = new MockHttpServletRequest();  
        MockHttpServletResponse response = new MockHttpServletResponse();  
        request.setMethod("POST");  
        String username="jin";
        String passwd="123";
        request.addParameter("username", username);  
        request.addParameter("passwd", passwd);  
        loginController.findBy_username_passwd(username, passwd, request, response);  
    }  
	
	@Test  
    public void testLogOut() throws Exception { 
		System.out.println("testLogOut run");
        MockHttpServletRequest request = new MockHttpServletRequest();  
        request.setMethod("POST");  
        String username="jin";
        request.addParameter("username", username);  
        loginController.logout(request);  
	}
	
	
	
	
	
}
