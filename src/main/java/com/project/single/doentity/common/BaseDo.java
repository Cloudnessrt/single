package com.project.single.doentity.common;

import com.project.single.common.enums.PoExistEnum;

import java.util.Date;
import java.util.UUID;

/**
 * 基础Po类公共字段
 */
public class BaseDo {

    private String id;
    /**
     * 创建人id
     */
    private String createPersonId;
    /**
     * 创建人名
     */
    private String createPersonName;
    /**
     * 创建人时间
     */
    private Date createTime;
    /**
     * 最后修改人id
     */
    private String lastModityPersonId;
    /**
     * 最后修改人名
     */
    private String lastModityPersonName;
    /**
     * 最后修改时间
     */
    private Date lastModityTime;
    /**
     * 实体状态
     */
    private PoExistEnum existEnum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public Date getCreateTime() {
        if (createTime == null)
        {
            return null;
        }
        return (Date)createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastModityPersonId() {
        return lastModityPersonId;
    }

    public void setLastModityPersonId(String lastModityPersonId) {
        this.lastModityPersonId = lastModityPersonId;
    }

    public String getLastModityPersonName() {
        return lastModityPersonName;
    }

    public void setLastModityPersonName(String lastModityPersonName) {
        this.lastModityPersonName = lastModityPersonName;
    }

    public Date getLastModityTime() {
        if (lastModityTime == null)
        {
            return null;
        }
        return (Date)lastModityTime.clone();
    }

    public void setLastModityTime(Date lastModityTime) {
        this.lastModityTime = lastModityTime;
    }

    public PoExistEnum getExistEnum() {
        return existEnum;
    }

    public void setExistEnum(PoExistEnum exist) {
        this.existEnum = exist;
    }

    public BaseDo(){
        createId();
    }

    /**
     * 更新实体操作时对于基本信息的维护
     * @param user 操作人
     */
    public void updateBase(UserDo user){
        dealLastModity(user);
    }

    /**
     * 新增实体操作时对于基本信息的维护
     * @param user 操作人
     */
    public void insertBase(UserDo user){
        this.existEnum=PoExistEnum.exist;//新增默认有效数据
        createBaseInfo(user);
    }

    /**
     * 新增实体操作时对于基本信息的维护
     * @param user 操作人
     */
    public void deleteBase(UserDo user){
        this.existEnum=PoExistEnum.delete;//新增默认有效数据
        dealLastModity(user);
    }

    /**
     * 生成主键
     */
    private void createId(){
        this.id= UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 维护初始化信息
     * @param user
     */
    private void createBaseInfo(UserDo user){
        dealCreate(user);
        dealLastModity(user);
    }

    /**
     * 创建类的基本字段维护
     * @param user
     */
    private void dealCreate(UserDo user){
        this.createTime=new Date();
        if(user!=null){
            this.createPersonId=user.getId();
            this.createPersonName=user.getName();
        }
    }

    /**
     * 维护最后修改信息
     * @param user
     */
    private void dealLastModity(UserDo user){
        this.lastModityTime = new Date();
        if(user!=null) {
            this.lastModityPersonName = user.getName();
            this.lastModityPersonId = user.getId();
        }
    }
}
