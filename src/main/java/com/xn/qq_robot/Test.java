package com.xn.qq_robot;

import com.xn.qq_robot.caller.TruckApiCaller;
import com.xn.qq_robot.entity.MpInfo;


public class Test {

    public static void main(String[] args) {
        TruckApiCaller caller = new TruckApiCaller();
        MpInfo mpInfo = caller.findMpInfo();
        System.out.println(mpInfo);
    }
}
