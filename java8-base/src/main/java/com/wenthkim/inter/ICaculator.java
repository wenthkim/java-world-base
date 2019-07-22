package com.wenthkim.inter;

/**
 * 接口默认函数例子
 */
public interface ICaculator {

    Integer caculate(Integer var1);

    default Double sqrt(Double var1) {
        return Math.sqrt(var1);
    }

}
