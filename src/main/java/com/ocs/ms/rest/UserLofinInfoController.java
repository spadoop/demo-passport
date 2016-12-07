/**
 * 
 */
package com.ocs.ms.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.ms.entity.UserLoginInfo;
import com.ocs.ms.json.JsonResult;
import com.ocs.ms.json.ResultCode;
import com.ocs.ms.security.LoginManager;
import com.ocs.ms.service.UserLoginInfoService;

/**
 * 订单处理
 * 
 * @author jin
 * 2016-12-7
 */
@RestController
public class UserLofinInfoController {

	@Resource
	private UserLoginInfoService service;

	//http://localhost:9090/login/findBy_username_passwd?username=jin&passwd=123
	@RequestMapping(value = "login/findBy_username_passwd" , produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult findBy_username_passwd( String username , String passwd ,HttpServletRequest req,HttpServletResponse rep) {
		System.out.println("username="+username +"    passwd="+passwd);
		if(username == null || passwd == null)
			return new JsonResult(ResultCode.PARAMS_ERROR, "参数错误", null);  
		if(username.equals("") || passwd.equals("")) 
			return new JsonResult(ResultCode.PARAMS_ERROR, "参数错误", null);  
		
		UserLoginInfo user=(UserLoginInfo) LoginManager.getUserSession(req);
		
		if(user!=null)
			return new JsonResult(ResultCode.SUCCESS, "登录成功！", null);  
		
		UserLoginInfo resultEntity = service.findBy_username_passwd(username, passwd);
		if(resultEntity !=null){
			try {
				LoginManager.login(req, rep, resultEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new JsonResult(ResultCode.SUCCESS, "登录成功！", null);  
		}else{
			return new JsonResult(ResultCode.NOT_LOGIN, "登录失败！", null);  
		}
	}

	//http://localhost:9090/login/insert_UserLoginInfo?username=jin&passwd=123&displayname=aaaa
	@RequestMapping(value = "login/insert_UserLoginInfo", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult insert_UserLoginInfo(UserLoginInfo entity) {
		if(entity ==null)
			return new JsonResult(ResultCode.PARAMS_ERROR, "参数错误", null); 
		System.out.println("getUsername="+entity.getUsername());
		
		UserLoginInfo resultEntity =service.insert_UserLoginInfo(entity);
		
		if(resultEntity !=null)
			return new JsonResult(ResultCode.SUCCESS, "insert success", resultEntity);  
        return new JsonResult(ResultCode.EXCEPTION, "insert error", null);  
	}
	
	
	
	//http://localhost:9090/logout?username=jin
	@RequestMapping(value = "logout", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult logout(String username,HttpServletRequest req) {
		System.out.println("username="+username);
		if(username ==null)
			return new JsonResult(ResultCode.PARAMS_ERROR, "参数错误", null); 
		
		try {
			LoginManager.logout(req);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, "LoginManager.logout异常", null); 
		}
		return new JsonResult(ResultCode.SUCCESS, "登出成功", null); 
	}
	
	
	
	
	
	
	
	
}
