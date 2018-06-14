package com.example.recyclerview_seclected;

/**
 * Created by Administrator on 2017/8/22.
 */

public class UserBean {
    private String name;

    private boolean isCheck=false;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public UserBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
