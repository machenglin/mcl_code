package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * Created by Mcl on 2018/3/29.
 */
public class ClassDemo {

    public static void main(String[] args) {
        // 1.通过类获取
        Class<?> aClass = Date.class;
        // 2.通过对象获取
        Date date = new Date();
        Class<?> bClass = date.getClass();

        // 3.通过静态方法forName
        try {
            Class<?> cClass = Class.forName("java.util.Date");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // 返回这个类的一个实例
            Date date1 = (Date)aClass.newInstance();
            System.out.println(date1);
            // 获取构造器
            Date date2 = (Date) aClass.getConstructor(long.class).newInstance(1000000L);
            System.out.println(date2);

            System.out.println("public getFields----");
            Arrays.asList(aClass.getFields()).forEach(System.out::println);
            System.out.println("public getDeclaredFields----");
            Arrays.asList(aClass.getDeclaredFields()).forEach(System.out::println);
            System.out.println("public getMethods----");
            Arrays.asList(aClass.getMethods()).forEach(System.out::println);
            System.out.println("public getDeclaredMethods----");
            Arrays.asList(aClass.getDeclaredMethods()).forEach(System.out::println);

            System.out.println("public getConstructors----");
            Arrays.asList(aClass.getConstructors()).forEach(System.out::println);
            System.out.println("public getDeclaredConstructors----");
            Arrays.asList(aClass.getDeclaredConstructors()).forEach(System.out::println);
            System.out.println("public getDeclaringClass----");
            System.out.println(aClass.getDeclaringClass());

            System.out.println("public getName----");
            System.out.println(aClass.getName());

            System.out.println("public getTypeParameters----");
            Arrays.asList(aClass.getConstructor(long.class).getTypeParameters()).forEach(System.out::println);
            System.out.println("public getReturnType-----");
            System.out.println(aClass.getMethod("toLocaleString").getReturnType());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
