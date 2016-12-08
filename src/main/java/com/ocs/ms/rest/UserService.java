package com.ocs.ms.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.ms.entity.UserLoginInfo;
import com.ocs.ms.json.JsonResult;
import com.ocs.ms.json.ResultCode;
import com.ocs.ms.mapper.UserLoginInfoMapper;
import com.ocs.ms.security.LoginManager;
import com.ocs.ms.security.UserSession;
import com.ocs.ms.utils.Assert;

@RestController
public class UserService {
	
	@Resource
	private UserLoginInfoMapper mapper;
	
	@RequestMapping(value = "/getuser" , produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult getUser(HttpServletRequest req){
		JsonResult jr = new JsonResult();
		UserSession user= LoginManager.getUserSession(req);
		if(!Assert.isBlank(user)){
			UserLoginInfo u = mapper.getUserById(user.getUserId());
			jr.setCode(ResultCode.SUCCESS);
			jr.setData(u);
		} else {
			jr.setCode(ResultCode.NOT_LOGIN);
			jr.setMessage("用户未登录");
		}
		return jr;
	}
}
