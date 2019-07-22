package com.wenthkim;

import com.wenthkim.inter.ICaculator;

public class Test {

    public static void main(String[] args) {
        testInterface();
    }

    /**
     * 接口默认函数例子
     */
    public static void testInterface() {
        ICaculator iCaculator = var1 -> var1 * 2;

        System.out.println(iCaculator.caculate(100));
        System.out.println(iCaculator.sqrt(100.0));

    }

}
