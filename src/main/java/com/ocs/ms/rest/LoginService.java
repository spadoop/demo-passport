package com.ocs.ms.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.ms.json.JsonResult;
import com.ocs.ms.json.ResultCode;

@RestController
@RequestMapping("/login")
public class LoginService {

	private String userName = "admin";
    private String pw = "pword";
    
    @RequestMapping
    public @ResponseBody JsonResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map) {  
        if(userName.equals(map.get("userName")) && pw.equals(map.get("password"))){  
            return new JsonResult(ResultCode.SUCCESS, "登录成功！", null);  
        }else {  
            return new JsonResult(ResultCode.NOT_LOGIN, "登录失败！", null);  
        }  
    }
}
