package com.xn.qq_robot.entity;

public class ServerInfo {

    private String id;

    private String game;

    private String ip;

    private String port;

    private String name;

    private String shortName;

    private String idPrefix;

    private boolean online;

    private int players;

    private int maxPlayers;

    private String mapId;

    private int displayOrder;

    private int speedLimiter;

    private boolean collisions;

    private boolean carsForPlayers;

    private boolean policeCarsForPlayers;

    private boolean afkEnabled;

    private boolean event;

    private boolean specialEvent;

    private boolean proMods;

    private int syncDelay;

    public String getId() {
        return id;
    }

    public ServerInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getGame() {
        return game;
    }

    public ServerInfo setGame(String game) {
        this.game = game;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public ServerInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getPort() {
        return port;
    }

    public ServerInfo setPort(String port) {
        this.port = port;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServerInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public ServerInfo setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getIdPrefix() {
        return idPrefix;
    }

    public ServerInfo setIdPrefix(String idPrefix) {
        this.idPrefix = idPrefix;
        return this;
    }

    public boolean isOnline() {
        return online;
    }

    public ServerInfo setOnline(boolean online) {
        this.online = online;
        return this;
    }

    public int getPlayers() {
        return players;
    }

    public ServerInfo setPlayers(int players) {
        this.players = players;
        return this;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public ServerInfo setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

    public String getMapId() {
        return mapId;
    }

    public ServerInfo setMapId(String mapId) {
        this.mapId = mapId;
        return this;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public ServerInfo setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
        return this;
    }

    public int getSpeedLimiter() {
        return speedLimiter;
    }

    public ServerInfo setSpeedLimiter(int speedLimiter) {
        this.speedLimiter = speedLimiter;
        return this;
    }

    public boolean isCollisions() {
        return collisions;
    }

    public ServerInfo setCollisions(boolean collisions) {
        this.collisions = collisions;
        return this;
    }

    public boolean isCarsForPlayers() {
        return carsForPlayers;
    }

    public ServerInfo setCarsForPlayers(boolean carsForPlayers) {
        this.carsForPlayers = carsForPlayers;
        return this;
    }

    public boolean isPoliceCarsForPlayers() {
        return policeCarsForPlayers;
    }

    public ServerInfo setPoliceCarsForPlayers(boolean policeCarsForPlayers) {
        this.policeCarsForPlayers = policeCarsForPlayers;
        return this;
    }

    public boolean isAfkEnabled() {
        return afkEnabled;
    }

    public ServerInfo setAfkEnabled(boolean afkEnabled) {
        this.afkEnabled = afkEnabled;
        return this;
    }

    public boolean isEvent() {
        return event;
    }

    public ServerInfo setEvent(boolean event) {
        this.event = event;
        return this;
    }

    public boolean isSpecialEvent() {
        return specialEvent;
    }

    public ServerInfo setSpecialEvent(boolean specialEvent) {
        this.specialEvent = specialEvent;
        return this;
    }

    public boolean isProMods() {
        return proMods;
    }

    public ServerInfo setProMods(boolean proMods) {
        this.proMods = proMods;
        return this;
    }

    public int getSyncDelay() {
        return syncDelay;
    }

    public ServerInfo setSyncDelay(int syncDelay) {
        this.syncDelay = syncDelay;
        return this;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "id='" + id + '\'' +
                ", game='" + game + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", idPrefix='" + idPrefix + '\'' +
                ", online=" + online +
                ", players=" + players +
                ", maxPlayers=" + maxPlayers +
                ", mapId='" + mapId + '\'' +
                ", displayOrder=" + displayOrder +
                ", speedLimiter=" + speedLimiter +
                ", collisions=" + collisions +
                ", carsForPlayers=" + carsForPlayers +
                ", policeCarsForPlayers=" + policeCarsForPlayers +
                ", afkEnabled=" + afkEnabled +
                ", event=" + event +
                ", specialEvent=" + specialEvent +
                ", proMods=" + proMods +
                ", syncDelay=" + syncDelay +
                '}';
    }
}
