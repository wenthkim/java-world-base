package com.wenthkim.funtionalinter;

import java.util.function.Function;
import java.util.function.Predicate;

public class TestFuntional {

    public static void main(String[] args) {
        Converter<String,Integer> converter = from -> Integer.parseInt(from);

        Converter<String,Integer> converter1 = Integer::parseInt;

        System.out.println(converter1.convert("123"));

        /**
         * 对传入的参数应用这个函数
         */
        Predicate<String> predicate = s -> s.length() > 0;
        predicate.test("4455");

        /**
         * 第一个参数类型
         * 第二个返回类型
         */
        Function<String,Integer> function = Integer::valueOf;
        System.out.println(function.apply("333"));
        //执行下一个函数
        Function<String, String> backToString = function.andThen(String::valueOf);
    }

}
