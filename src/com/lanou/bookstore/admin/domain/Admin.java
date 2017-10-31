package com.lanou.bookstore.admin.domain;

import java.io.Serializable;

/**
 * Created by dllo on 17/9/28.
 */
public class Admin implements Serializable {
    private String aid;
    private String aname;
    private String apwd;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", apwd='" + apwd + '\'' +
                '}';
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Admin(String aid, String aname, String apwd) {

        this.aid = aid;
        this.aname = aname;
        this.apwd = apwd;
    }


}
