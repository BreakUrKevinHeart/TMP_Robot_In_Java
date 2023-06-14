package com.xn.qq_robot.entity;

public class MpInfo {

    private String name;

    private String numeric;

    private String stage;

    private CheckSum ets2mpChecksum;

    private CheckSum atsmpChecksum;

    /**
     * 格式化的时间- yyyy-MM-dd HH:mm:ss
     */
    private String time;

    private String supportedGameVersion;

    private String supportedAtsGameVersion;

    public String getName() {
        return name;
    }

    public MpInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getNumeric() {
        return numeric;
    }

    public MpInfo setNumeric(String numeric) {
        this.numeric = numeric;
        return this;
    }

    public String getStage() {
        return stage;
    }

    public MpInfo setStage(String stage) {
        this.stage = stage;
        return this;
    }

    public CheckSum getEts2mpChecksum() {
        return ets2mpChecksum;
    }

    public MpInfo setEts2mpChecksum(CheckSum ets2mpChecksum) {
        this.ets2mpChecksum = ets2mpChecksum;
        return this;
    }

    public CheckSum getAtsmpChecksum() {
        return atsmpChecksum;
    }

    public MpInfo setAtsmpChecksum(CheckSum atsmpChecksum) {
        this.atsmpChecksum = atsmpChecksum;
        return this;
    }

    public String getTime() {
        return time;
    }

    public MpInfo setTime(String time) {
        this.time = time;
        return this;
    }

    public String getSupportedGameVersion() {
        return supportedGameVersion;
    }

    public MpInfo setSupportedGameVersion(String supportedGameVersion) {
        this.supportedGameVersion = supportedGameVersion;
        return this;
    }

    public String getSupportedAtsGameVersion() {
        return supportedAtsGameVersion;
    }

    public MpInfo setSupportedAtsGameVersion(String supportedAtsGameVersion) {
        this.supportedAtsGameVersion = supportedAtsGameVersion;
        return this;
    }
}
