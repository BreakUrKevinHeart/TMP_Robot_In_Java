package com.xn.qq_robot.utils;

import com.alibaba.fastjson.JSONObject;
import com.xn.qq_robot.entity.Permissions;
import com.xn.qq_robot.entity.PlayerInfo;
import com.xn.qq_robot.entity.VTC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class BuildEntityUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildEntityUtils.class);

    public static PlayerInfo buildPlayerInfo(JSONObject obj) {
        if (obj == null) {
            LOGGER.error("JSONObject为空！");
            return null;
        }
        try {
            PlayerInfo playerInfo = new PlayerInfo();
            playerInfo.setId(obj.get("id").toString())
                    .setName(obj.get("name").toString())
                    .setJoinDate(obj.get("joinDate").toString())
                    .setJoinDays()
                    .setSteamId(obj.get("steamID").toString())
                    .setGroupName(obj.get("groupName").toString())
                    .setDisplayBans(obj.get("displayBans").toString().equals("true"))
                    .setBanned(obj.get("banned").toString().equals("true"))
                    .setBansCount(Integer.parseInt(obj.get("bansCount").toString()))
                    .setBannedUtil(obj.get("bannedUntil") == null ? "未封禁" : obj.get("bannedUntil").toString());

            VTC vtc = null;
            if (obj.get("vtc") != null) {
                JSONObject vtcObj = JSONObject.parseObject(obj.get("vtc").toString());
                vtc = new VTC()
                        .setId(vtcObj.get("id").toString())
                        .setName(vtcObj.get("name").toString())
                        .setTag(vtcObj.get("tag").toString())
                        .setMemberId(vtcObj.get("memberID").toString())
                        .setInVTC(vtcObj.get("inVTC").equals("true"));
            }
            playerInfo.setVtc(vtc);

            Permissions permissions = null;
            if (obj.get("permissions") != null) {
                JSONObject permissionObj = JSONObject.parseObject(obj.get("permissions").toString());
                permissions = new Permissions()
                        .setStaff(permissionObj.get("isStaff").equals(true))
                        .setGameAdmin(permissionObj.get("isGameAdmin").equals(true))
                        .setUpperStaff(permissionObj.get("isUpperStaff").equals(true))
                        .setShowDetailedOnWebMaps(permissionObj.get("showDetailedOnWebMaps").equals(true));
            }
            playerInfo.setPermission(permissions);
            return playerInfo;
        } catch (ParseException e) {
            LOGGER.error("构建playerInfo失败！" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
