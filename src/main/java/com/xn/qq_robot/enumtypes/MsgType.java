package com.xn.qq_robot.enumtypes;

public enum MsgType {

    GROUP("group"),
    PRIVATE("private");

    private String name;

    MsgType(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
