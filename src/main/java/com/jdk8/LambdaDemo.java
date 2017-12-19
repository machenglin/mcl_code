package com.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * jdk1.8特性 lambda表达式
 * (params) -> expression 或 (params) -> {expression}
 * Created by Mcl on 2017/12/19.
 */
public class LambdaDemo {

    @Test
    public void testRunnable() {
        new Thread(() -> System.out.println("hello lambda!")).start();
        Runnable runnable = () -> System.out.println("hello lambda!");
    }

    @Test
    public void testForEach() {
        String[] strings = {"a", "b", "c"};
        List<String> list = Arrays.asList(strings);
        list.forEach((data) -> System.out.println(data + ";"));
    }

    @Test
    public void testComparator() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        Comparator<String> comparator = (s1, s2) -> (s1.compareTo(s2));
        Arrays.sort(players, comparator);
        Arrays.asList(players).forEach((data) -> System.out.println(data));
    }


}

