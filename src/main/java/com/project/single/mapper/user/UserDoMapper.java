package com.project.single.mapper.user;


import com.project.single.doentity.common.UserDo;

import java.util.List;

public interface UserDoMapper {

    int insert(UserDo record);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(UserDo record);

    int updateByPrimaryKeySelective(UserDo record);

    UserDo queryByPrimaryKey(String id);

    List<UserDo> queryByAllKey(UserDo record);

}