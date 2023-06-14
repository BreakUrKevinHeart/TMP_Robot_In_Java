package com.xn.qq_robot.listener;

import com.alibaba.fastjson.JSONObject;
import com.xn.qq_robot.sender.MsgSender;
import com.xn.qq_robot.enumtypes.MsgType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class SelectPlayerListener implements Runnable{

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectPlayerListener.class);

    private static Set<Integer> set = new HashSet<>();

    private static final String httpResponseHeader = "HTTP/1.1 200 OK\\r\\n\n" +
            "Content-Type: text/html\\r\\n\\r\\n\n";

    private String ip;

    private int port;

    public SelectPlayerListener(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            LOGGER.info("开始监听连接, 地址: " + ip + ", 端口: " + port);
            ServerSocket socket = new ServerSocket(port, 100, InetAddress.getByName(ip));
            while (true) {
                Socket accept = socket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                StringBuffer buffer = new StringBuffer();
                while ((len = inputStream.read(bytes)) != -1) {
                    buffer.append(new String(bytes, 0, len));
                }
                String[] split = buffer.toString().split("\n");
                // 获取事件信息
                String jsonString = buffer.toString().split("\n")[split.length - 1];
                JSONObject obj= JSONObject.parseObject(jsonString);
                if (obj.get("post_type").toString().equals("message") && !set.contains((Integer) obj.get("message_id"))) {
                    String msg = obj.get("raw_message").toString();
                    if (msg != null && msg.length() > 1 && msg.substring(0, 2).equals("查询")) {
                        // 查询玩家信息
                        handlePlayerInfo(obj, msg);
                    }

                    if (msg != null && msg.equals("服务器列表")) {
                        // 查询服务器列表
                        handleServerInfo(obj);
                    }

                    if (msg != null && msg.equals("mp版本")) {
                        // 查询mp信息
                        handleMpInfo(obj);
                    }
                    // 处理信息完成，将信息id加入set，防止重复处理
                    set.add((Integer) obj.get("message_id"));
                }
            }
        } catch (Exception e) {
            LOGGER.error("发生异常！" + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean handlePlayerInfo(JSONObject obj, String msg) {
        boolean success = false;
        try {
            MsgSender msgSender = new MsgSender();
            String playerId = msg.substring(2);
            if (obj.get("message_type").toString().equals("group")) {
                success = msgSender.sendPlayerInfo(MsgType.GROUP.toString(), obj.get("group_id").toString(), playerId);
            } else {
                success = msgSender.sendPlayerInfo(MsgType.PRIVATE.toString(), obj.get("user_id").toString(), playerId);
            }
            if (success) {
                LOGGER.info("发送玩家信息成功！playerID: " + playerId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    private boolean handleServerInfo(JSONObject obj) {
        boolean success = false;
        try {
            MsgSender msgSender = new MsgSender();
            if (obj.get("message_type").toString().equals("group")) {
                success = msgSender.sendServerListInfo(MsgType.GROUP.toString(), obj.get("group_id").toString());
            } else {
                success = msgSender.sendServerListInfo(MsgType.PRIVATE.toString(), obj.get("user_id").toString());
            }
            if (success) {
                LOGGER.info("发送服务器信息成功！");
            }
        } catch (Exception e) {
            LOGGER.error("发送服务器信息失败！");
            e.printStackTrace();
        }
        return success;
    }

    private boolean handleMpInfo(JSONObject obj) {
        boolean success = false;
        String msgType = obj.get("message_type").toString();
        String toNumber = obj.get(msgType.equals("group") ? "group_id" : "user_id").toString();
        try {
            MsgSender msgSender = new MsgSender();
            success = msgSender.sendMpInfo(msgType, toNumber);
            if (success) {
                LOGGER.info("发送MP信息成功! ");
            } else {
                LOGGER.error("发送MP信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}

