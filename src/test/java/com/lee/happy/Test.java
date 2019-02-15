package com.lee.happy;

import com.lee.happy.util.ConcurrentDateUtils;

import java.util.Date;

/**
 * @author lee
 * @date 2019/2/15
 */

public class Test {

    public static void main(String[] args) {
        System.out.println(ConcurrentDateUtils.formatDateTime(new Date()));
    }
}
