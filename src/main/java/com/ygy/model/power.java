package com.ygy.model;

public class power {
    private int pid;
    private int rid;
    private  String pname;

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getRid() {
        return rid;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }
}
