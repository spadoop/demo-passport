package com.ocs.ms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ocs.ms.entity.UserName;

@Mapper
public interface NameMapper {

	@Select("SELECT username FROM t_user where id=#{id} limit 1")
	UserName getNameById(@Param("id") String id);
}
