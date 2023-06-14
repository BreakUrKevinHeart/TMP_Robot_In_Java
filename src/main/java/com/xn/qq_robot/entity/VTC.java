package com.xn.qq_robot.entity;

public class VTC {

    private String id;

    private String name;

    private String tag;

    private boolean inVTC;

    private String memberId;

    public String getId() {
        return id;
    }

    public VTC setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public VTC setName(String name) {
        this.name = name;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public VTC setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public boolean isInVTC() {
        return inVTC;
    }

    public VTC setInVTC(boolean inVTC) {
        this.inVTC = inVTC;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public VTC setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }
}
