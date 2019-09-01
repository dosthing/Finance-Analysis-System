package com.dosthing.finance.utils;

import java.util.Random;

/**
 * Created by liuchenyu on 2018/1/10.
 * Desc:产生指定长度的随机数
 */
public class RandomUtil {


    /**
     * desc: 产生指定长度的随机数
     * author: liuchenyu
     * date: 2018/1/10 16:06
     * @param num  随机数长度
     * @return
     */
    public static String random(int num) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int t = random.nextInt(10);
            buffer.append(t);
        }
        return buffer.toString();
    }
}
