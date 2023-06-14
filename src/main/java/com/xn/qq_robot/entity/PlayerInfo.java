package com.xn.qq_robot.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerInfo {

    private String id;

    private String name;

    private String joinDate;

    private int joinDays;

    private String steamId;

    private String groupName;

    /**
     * 展示禁令
     */
    private boolean displayBans;

    /**
     * 当前封禁
     */
    private boolean banned;

    /**
     * 封禁次数
     */
    private int bansCount;

    /**
     * 解禁时间
     */
    private String bannedUtil;

    /**
     * 车队信息
     */
    private VTC vtc;

    /**
     * 权限
     */
    private Permissions permissions;

    public PlayerInfo setJoinDays() throws ParseException {
        this.joinDays = (int) ((new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(joinDate).getTime()) / (24 * 60 * 60 * 1000));
        return this;
    }

    public String getId() {
        return id;
    }

    public PlayerInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public PlayerInfo setJoinDate(String joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public int getJoinDays() {
        return joinDays;
    }

    public String getSteamId() {
        return steamId;
    }

    public PlayerInfo setSteamId(String steamId) {
        this.steamId = steamId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public PlayerInfo setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public boolean isDisplayBans() {
        return displayBans;
    }

    public PlayerInfo setDisplayBans(boolean displayBans) {
        this.displayBans = displayBans;
        return this;
    }

    public boolean getDisPlayBans() {
        return displayBans;
    }

    public boolean isBanned() {
        return banned;
    }

    public PlayerInfo setBanned(boolean banned) {
        this.banned = banned;
        return this;
    }

    public boolean getBanned() {
        return banned;
    }

    public int getBansCount() {
        return bansCount;
    }

    public PlayerInfo setBansCount(int bansCount) {
        this.bansCount = bansCount;
        return this;
    }

    public String getBannedUtil() {
        return bannedUtil;
    }

    public PlayerInfo setBannedUtil(String bannedUtil) {
        this.bannedUtil = bannedUtil;
        return this;
    }

    public VTC getVtc() {
        return vtc;
    }

    public PlayerInfo setVtc(VTC vtc) {
        this.vtc = vtc;
        return this;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public PlayerInfo setPermission(Permissions permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", joinDays=" + joinDays +
                ", steamId='" + steamId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", displayBans=" + displayBans +
                ", banned=" + banned +
                ", bansCount=" + bansCount +
                ", bannedUtil='" + bannedUtil + '\'' +
                ", vtc=" + vtc +
                ", permission=" + permissions +
                '}';
    }
}