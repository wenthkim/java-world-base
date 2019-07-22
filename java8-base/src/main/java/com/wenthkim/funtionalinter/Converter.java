package com.wenthkim.funtionalinter;

/**
 * 函数式接口
 * @param <F> 参数类型
 * @param <T> 返回值类型
 */
@FunctionalInterface
interface Converter<F,T> {

    T convert(F from);

}
