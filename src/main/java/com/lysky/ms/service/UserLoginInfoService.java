/**
 * 
 */
package com.lysky.ms.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lysky.ms.entity.UserLoginInfo;
import com.lysky.ms.mapper.UserLoginInfoMapper;

/**
 * 
 * @author jin
 * 2016-12-7
 */

@Service
public class UserLoginInfoService {

	@Resource
	UserLoginInfoMapper mapper;

	public UserLoginInfo findBy_username_passwd(String username , String passwd){
		try {
			return mapper.findBy_username_passwd(username, passwd);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("findBy_username_passwd 异常");
			return null;
		}
	}
	
	@Transactional
	public UserLoginInfo insert_UserLoginInfo(UserLoginInfo entity){
		if(entity==null)return null;
		try {
			String uuid = UUID.randomUUID().toString();
			entity.setId(uuid);
			int retulstInt=mapper.insert_UserLoginInfo(entity);
			if(retulstInt>0)
				return entity;
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert_UserLoginInfo 异常");
			return null;
		}
	}
}
