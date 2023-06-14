package com.xn.qq_robot.utils;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RobotUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotUtils.class);

    public static boolean sendMessage(String msgType, String toNumber, String msg) throws IOException {
        URL url;
        if (msgType.equals("private")) {
            url = new URL("http://localhost:5700/send_private_msg?");
        } else if (msgType.equals("group")) {
            url = new URL("http://localhost:5700/send_group_msg?");
        } else {
            LOGGER.error("msgType填写错误！");
            return false;
        }
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        // 设置 Content-Type 标头，用于指定请求体格式
        connection.setRequestProperty("Content-Type", "application/json");
        JSONObject obj = new JSONObject();
        obj.put(msgType.equals("private") ? "user_id" : "group_id", toNumber);
        obj.put("message", msg);
        String requestBody = JSONObject.toJSONString(obj);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(requestBody.getBytes());
        outputStream.flush();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == 200) {
            // 请求成功
            return true;
        }
        return false;
    }

}
