package com.lysky.ms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lysky.ms.entity.UserName;

@Mapper
public interface NameMapper {

	@Select("SELECT username FROM t_user where id=#{id} limit 1")
	UserName getNameById(@Param("id") String id);
}
