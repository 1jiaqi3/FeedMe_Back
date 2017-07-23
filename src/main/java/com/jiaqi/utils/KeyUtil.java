package com.jiaqi.utils;

import java.util.Random;

/**
 * Created by mac on 23/07/2017.
 */
public class KeyUtil {
    /**
     * format: time + random number
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random rand = new Random();
        Integer num = rand.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
