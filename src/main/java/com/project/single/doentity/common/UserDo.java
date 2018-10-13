package com.project.single.doentity.common;

import com.project.single.common.enums.SexEnum;

public class UserDo extends BaseDo {

    private String name;

    private String account;

    private String password;

    private SexEnum sexEnum;

    public UserDo() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SexEnum getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }
}
