package com.project.single.service.common.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.single.common.Constant;
import com.project.single.common.enums.PoExistEnum;
import com.project.single.common.util.ExecInfo;
import com.project.single.common.util.QueryPage;
import com.project.single.doentity.common.UserDo;
import com.project.single.mapper.UserDoMapper;
import com.project.single.service.common.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDoMapper userDoMapper;

    /**
     * 增
     * @param record
     * @return
     */
    public ExecInfo insert(UserDo record){
        ExecInfo check=insertCheck(record);
        if(check!=null && Constant.SUCCESS.equals(check.getCode())){
            userDoMapper.insert(record);
            return ExecInfo.successExecInfo(record);
        }else{
            return check;
        }
    }

    private ExecInfo insertCheck(UserDo record){
        return ExecInfo.successExecInfo(record);
    }

    /**
     * 删
     * @param id
     * @return
     */
    public ExecInfo delete(String id){
        UserDo record=query(id);
        ExecInfo check=deleteCheck(record);
        if(check!=null && Constant.SUCCESS.equals(check.getCode())){
            record.setExistEnum(PoExistEnum.delete);
            userDoMapper.updateByPrimaryKey(record);
            return ExecInfo.successExecInfo(record);
        }else{
            return check;
        }
    }

    private ExecInfo deleteCheck(UserDo record){
        return ExecInfo.successExecInfo(record);
    }

    /**
     * 改
     * @param record
     * @return
     */
    public ExecInfo update(UserDo record){
        ExecInfo check=updateCheck(record);
        if(check!=null && Constant.SUCCESS.equals(check.getCode())){
            userDoMapper.updateByPrimaryKey(record);
            return ExecInfo.successExecInfo(record);
        }else{
            return check;
        }
    }

    private ExecInfo updateCheck(UserDo record){
        return ExecInfo.successExecInfo(record);
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    public UserDo query(String id){
        if(!StringUtils.isEmpty(id)){
            return userDoMapper.queryByPrimaryKey(id);
        }else{
            return null;
        }
    }

    /**
     * 查询集合
     * @param record
     * @return
     */
    public List<UserDo> queryList(UserDo record){
        return userDoMapper.queryByAllKey(record);
    }

    /**
     * 查询分页
     * @param record
     * @return
     */
    public Page<UserDo> queryPage(QueryPage<UserDo> record){

        //分页并查询
        Page<UserDo> pageInfo = PageHelper.startPage(record.getPagenum(), record.getSize(), true);
        List<UserDo> users = userDoMapper.queryByAllKey(record.getObject());

        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<UserDo> result = pageInfo.getResult();//和上面的users结果相同

        return pageInfo;
    }
}
