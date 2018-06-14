package com.example.recyclerview_check;

/**
 * Created by Administrator on 2018/6/12.
 */

public class User {

    private String content="";
    private boolean isSelect = false;
    private boolean isSelect2 = false;

    public boolean isSelect2() {
        return isSelect2;
    }

    public void setSelect2(boolean select2) {
        isSelect2 = select2;
    }

    public User(String content) {
        this.content = content;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
