/**
 * 
 */
package com.ocs.ms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ocs.ms.entity.UserLoginInfo;
import com.ocs.ms.entity.UserName;

/**
 * @author jin 2016-12-7
 */
@Mapper
public interface UserLoginInfoMapper {

	@Select("SELECT * FROM t_user WHERE username = #{username} and passwd = #{passwd} limit 1 ")
	UserLoginInfo findBy_username_passwd(@Param("username") String username, @Param("passwd") String passwd);

	@Insert("INSERT INTO t_user(id , username , passwd , displayname) VALUES(#{id} , #{username} , #{passwd} , #{displayname} )")
	int insert_UserLoginInfo(UserLoginInfo entity);


}
