package com.xn.qq_robot.entity;

public class Permissions {

    /**
     * 普通成员
     */
    private boolean isStaff;

    /**
     * 工作成员
     */
    private boolean isUpperStaff;

    /**
     * 管理员
     */
    private boolean isGameAdmin;

    private boolean showDetailedOnWebMaps;

    public boolean isStaff() {
        return isStaff;
    }

    public Permissions setStaff(boolean staff) {
        isStaff = staff;
        return this;
    }

    public boolean isUpperStaff() {
        return isUpperStaff;
    }

    public Permissions setUpperStaff(boolean upperStaff) {
        isUpperStaff = upperStaff;
        return this;
    }

    public boolean isGameAdmin() {
        return isGameAdmin;
    }

    public Permissions setGameAdmin(boolean gameAdmin) {
        isGameAdmin = gameAdmin;
        return this;
    }

    public boolean isShowDetailedOnWebMaps() {
        return showDetailedOnWebMaps;
    }

    public Permissions setShowDetailedOnWebMaps(boolean showDetailedOnWebMaps) {
        this.showDetailedOnWebMaps = showDetailedOnWebMaps;
        return this;
    }
}
