package com.project.single.common.enums;

public enum  SexEnum {
    MAN   (1,"男"),
    WOMAN (2,"女");

    private Integer key;
    private String text;

    private  SexEnum(Integer key,String text){
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
