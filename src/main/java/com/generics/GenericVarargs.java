package com.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by machenglin on 2018/1/21.
 */
public class GenericVarargs {
    public static <T> List<T> makeLikt(T... items){
        List<T> result = new ArrayList<>();
        for (T item : items){
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(GenericVarargs.makeLikt(1,2,3,4));
    }
}