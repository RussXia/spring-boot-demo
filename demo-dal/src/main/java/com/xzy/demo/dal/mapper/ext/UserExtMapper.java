package com.xzy.demo.dal.mapper.ext;

import com.xzy.demo.dal.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * MyBatis Ext Mapper for User.
 */
@Mapper
@Repository
public interface UserExtMapper extends UserMapper {

}