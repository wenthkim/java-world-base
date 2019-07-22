package com.wenthkim.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式
 */
public class SortComparator {

    /**
     * 普通写法
     * @param list
     * @return
     */
    public static List<String> sortNormal(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        return list;
    }

    /**
     * lambda写法
     * @param list
     * @return
     */
    public static List<String> sortLanbda(List<String> list) {
        Collections.sort(list,(o1,o2) -> o2.compareTo(o1));

        list.sort((o1,o2) -> o1.compareTo(o2));

        list.sort(String::compareTo);

        return list;
    }


}
