package com.project.single.service.common;

import com.github.pagehelper.Page;
import com.project.single.common.util.ExecInfo;
import com.project.single.common.util.QueryPage;
import com.project.single.doentity.common.UserDo;

import java.util.List;

public interface IUserService {

    /**
     * 增
     * @param record
     * @return
     */
    public ExecInfo insert(UserDo record);

    /**
     * 删
     * @param id
     * @return
     */
    public ExecInfo delete(String id);

    /**
     * 改
     * @param record
     * @return
     */
    public ExecInfo update(UserDo record);

    /**
     * 单个查询
     * @param id
     * @return
     */
    public UserDo query(String id);

    /**
     * 查询集合
     * @param record
     * @return
     */
    public List<UserDo> queryList(UserDo record);

    /**
     * 查询分页
     * @param record
     * @return
     */
    public Page<UserDo> queryPage(QueryPage<UserDo> record);

}
