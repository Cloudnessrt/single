package com.project.single.common.enums;

/**
 * 实体状态枚举
 */
public enum PoExistEnum {
    exist(0,"未删除"),
    delete(1,"已删除");

    private Integer key;
    private String text;

    private PoExistEnum(Integer key, String text){
        this.key=key;
        this.text=text;
    }

    public Integer getKey() {
        return key;
    }


    public String getText() {
        return text;
    }
}
