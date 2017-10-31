package com.lanou.bookstore.collect.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/9/29.
 */
public class Collect implements Serializable{
    private String ccid;
    private Date ctime;
    private double ctotal;
    private String uid;
    private List<CollectItem> collectItemmList;

    public Collect() {
    }

    @Override
    public String toString() {
        return "Collect{" +
                "ccid='" + ccid + '\'' +
                ", ctime=" + ctime +
                ", ctotal=" + ctotal +
                ", uid='" + uid + '\'' +
                ", collectItemmList=" + collectItemmList +
                '}';
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public double getCtotal() {
        return ctotal;
    }

    public void setCtotal(double ctotal) {
        this.ctotal = ctotal;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<CollectItem> getCollectItemmList() {
        return collectItemmList;
    }

    public void setCollectItemmList(List<CollectItem> collectItemmList) {
        this.collectItemmList = collectItemmList;
    }

    public Collect(String ccid, Date ctime, double ctotal, String uid, List<CollectItem> collectItemmList) {

        this.ccid = ccid;
        this.ctime = ctime;
        this.ctotal = ctotal;
        this.uid = uid;
        this.collectItemmList = collectItemmList;
    }
}
