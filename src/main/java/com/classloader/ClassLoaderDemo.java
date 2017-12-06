package com.classloader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器：
 * JDK类加载器可以分为三类:
 *      一、启动类加载器：JAVA_HOME/lib目录下，以及被-Xbootclasspath参数指定的路径，
 * 不过启动类加载器的类是有限制的，如果JVM不认识的话，放在改目录下也没用。
 *      二、扩展类加载器：JAVA_HOME/lib/ext目录下,以及被java.ext.dirs系统变量指定的路径
 *      三、应用程序类加载：用户自己的类路径（classpath），这个类加载器就是我们经常使用的系统类加载器，
 * 并且JDK中的抽象类ClassLoader的默认父类加载器就是它。
 * Created by Mcl on 2017/11/14.
 */
public class ClassLoaderDemo {
    @Test
    public void test01() throws Exception {
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.classloader.ClassLoaderDemo");
        Object entity = clazz.newInstance();
        System.out.println(entity instanceof ClassLoaderDemo);
    }

    @Test
    public void test02() throws Exception{
        ClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = classLoader.loadClass("com.classloader.ClassLoaderDemo");
        Object entity = clazz.newInstance();
        System.out.println(entity instanceof ClassLoaderDemo);

    }
}

