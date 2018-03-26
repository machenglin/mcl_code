package com.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * jdk1.8特性 lambda表达式
 * (params) -> expression 或 (params) -> {expression}
 * 左侧：指定了Lambda 表达式需要的所有参数
 * 右侧：指定了Lambda 体，即Lambda 表达式要执行的功能。
 */
public class LambdaTest {

    /**
     * 无参，无返回值
     */
    @Test
    public void test01() {
        Runnable runnable = () -> System.out.println("hello lambda!");
    }

    /**
     * 一个参数，无返回值
     */
    @Test
    public void test02() {
        Consumer<String> consumer01 = (args) -> System.out.println(args);
        // 小括号可以省略
        Consumer<String> consumer02 = args -> System.out.println(args);
    }

    /**
     * 两个参数，并且有返回值
     * 当lambda只有一条语句时，return与大括号可以省略。
     * 参数数据类型可以省略，可由编译器类型推断
     */
    @Test
    public void test03() {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);
    }




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

