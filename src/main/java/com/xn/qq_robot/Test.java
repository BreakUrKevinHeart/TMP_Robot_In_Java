package com.xn.qq_robot;

import com.xn.qq_robot.caller.TruckApiCaller;
import com.xn.qq_robot.entity.PlayerInfo;
import com.xn.qq_robot.entity.ServerInfo;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        TruckApiCaller caller = new TruckApiCaller();
        List<ServerInfo> list = caller.findServerList();
        for (ServerInfo serverInfo : list) {
            System.out.println(serverInfo);
        }
        System.out.println("==================");
        PlayerInfo playerInfo = caller.findPlayerInfo("45664");
        System.out.println(playerInfo);
    }
}
