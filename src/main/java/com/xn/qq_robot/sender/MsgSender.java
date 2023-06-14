package com.xn.qq_robot.sender;

import com.xn.qq_robot.caller.TruckApiCaller;
import com.xn.qq_robot.entity.Permissions;
import com.xn.qq_robot.entity.PlayerInfo;
import com.xn.qq_robot.entity.ServerInfo;
import com.xn.qq_robot.utils.RobotUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class MsgSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgSender.class);

    public boolean sendPlayerInfo(String msgType, String toNumber, String playerId) throws IOException {
        TruckApiCaller caller = new TruckApiCaller();
        PlayerInfo playerInfo = caller.findPlayerInfo(playerId);
        if (playerInfo == null) {
            LOGGER.error("获取playerInfo失败！");
            return false;
        }
        String msg = buildPlayerInfoMsg(playerInfo);
        RobotUtils.sendMessage(msgType, toNumber, msg);
        return true;
    }

    public boolean sendServerListInfo(String msgType, String toNumber) throws IOException {
        TruckApiCaller caller = new TruckApiCaller();
        List<ServerInfo> list = caller.findServerList();
        if (list == null || list.size() < 1) {
            LOGGER.error("获取的服务器列表为空！");
            return false;
        }
        String msg = buildServerListInfo(list);
        RobotUtils.sendMessage(msgType, toNumber, msg);
        return true;
    }

    public String buildServerListInfo(List<ServerInfo> list) {
        StringBuffer buffer = new StringBuffer();
        for (ServerInfo serverInfo : list) {
            buffer.append(serverInfo.getName() + " (" + serverInfo.getShortName() + ")\n");
            buffer.append("人数: " + serverInfo.getPlayers() + "/" + serverInfo.getMaxPlayers() + "\n");
            buffer.append("-------------------------------\n");
        }
        return buffer.toString();
    }

    public String buildPlayerInfoMsg(PlayerInfo info) {
        if (info == null) {
            LOGGER.error("玩家信息为空！");
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("TMPID: " + info.getId() + "\n");
        buffer.append("昵称: " + info.getName() + "\n");
        buffer.append("加入时间: " + info.getJoinDate() + "\n");
        buffer.append("加入天数: " + info.getJoinDays() + "\n");
        buffer.append("steamID: " + info.getSteamId() + "\n");
        buffer.append("联机用户组: " + info.getGroupName() + "\n");
        buffer.append("禁令展示: " + (info.getDisPlayBans() ? "是" : "否") + "\n");
        buffer.append("当前封禁: " + (info.getBanned() ? "是" : "否") + "\n");
        buffer.append("解禁时间: " + info.getBannedUtil() + "\n");
        buffer.append("VTC: " + info.getVtc().getName() + "\n");
        buffer.append("VTC-ID: " + info.getVtc().getId() + "\n");
        buffer.append("VTC-标签: " + info.getVtc().getTag() + "\n");
        Permissions permissions = info.getPermissions();
        buffer.append("成员: " + (permissions.isStaff() ? "是" : "否") + "\n");
        buffer.append("高级成员: " + (permissions.isUpperStaff() ? "是" : "否") + "\n");
        buffer.append("管理员: " + (permissions.isGameAdmin() ? "是" : "否"));
        return buffer.toString();
    }
}
