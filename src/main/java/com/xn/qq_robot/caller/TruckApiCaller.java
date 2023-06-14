package com.xn.qq_robot.caller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xn.qq_robot.entity.PlayerInfo;
import com.xn.qq_robot.entity.ServerInfo;
import com.xn.qq_robot.utils.BuildEntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TruckApiCaller {

    private static final Logger LOGGER = LoggerFactory.getLogger(TruckApiCaller.class);

    /**
     * 获取玩家信息
     * @param playerId
     * @return
     */
    public PlayerInfo findPlayerInfo(String playerId) {
        try {
            String path = "https://api.truckersmp.com/v2/player/" + playerId;
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应体中的数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                reader.close();
                String responseText = buffer.toString();
                JSONObject object = JSONObject.parseObject(responseText);
                JSONObject obj = JSON.parseObject(object.get("response").toString());
                PlayerInfo playerInfo = BuildEntityUtils.buildPlayerInfo(obj);
                return playerInfo;
            } else {
                LOGGER.error("连接失败！错误码: " + responseCode);
            }
        } catch (Exception e) {
            LOGGER.error("出现异常!" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询服务器列表
     * @return
     */
    public List<ServerInfo> findServerList() {
        try {
            List<ServerInfo> list = new ArrayList<>();
            URL url = new URL("https://api.truckersmp.com/v2/servers");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String responseText = buffer.toString();
                JSONObject object = JSONObject.parseObject(responseText);
                list = JSONArray.parseArray(object.get("response").toString(), ServerInfo.class);
                return list;
            }
        } catch (Exception e) {
            LOGGER.error("获取服务器信息失败！" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
