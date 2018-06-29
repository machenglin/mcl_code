package com.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个使用的Set工具
 * Created by machenglin on 2018/1/21.
 */
public class SetUtils {
    /**
     * 两个集合的并集
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        a.addAll(b);
        return result;
    }

    /**
     * 两个集合的交集
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 从superSet找那个subSet包含的元素
     */
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet){
        Set<T> result = new HashSet<T>(superSet);
        result.removeAll(subSet);
        return result;
    }
}
