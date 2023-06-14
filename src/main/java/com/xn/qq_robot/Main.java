package com.xn.qq_robot;

import com.xn.qq_robot.listener.SelectPlayerListener;

import java.io.IOException;
import java.text.ParseException;

public class Main {


    public static void main(String[] args) throws IOException, ParseException {
//        boolean b = RobotUtils.sendMessage(MsgType.PRIVATE.toString(), "2042949489", "nihao");
//        TruckApiCaller caller = new TruckApiCaller();
//        MsgSender msgSender = new MsgSender();
//        String s = msgSender.buildPlayerInfoMsg(caller.findPlayerInfo("4944919"));
//        System.out.println(s);
//        msgSender.sendPlayerInfo(MsgType.PRIVATE.toString(), "2042949489", "4944919");
        new Thread(new SelectPlayerListener("localhost", 5701)).start();
    }

}
