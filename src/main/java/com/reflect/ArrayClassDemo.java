package com.reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

/**
 * Created by Mcl on 2018/3/29.
 */
public class ArrayClassDemo {
    public static void main(String[] args) {
        User[] users = {new User(1, "a"), new User(2, "b")};
        User[] newUser= (User[])goodCopyOf(users, 4);
        System.out.println(newUser.length);
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class clazz = a.getClass();
        if (!clazz.isArray()) {
            return null;
        }
        Class compentType = clazz.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(compentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class User {
        private int id;
        private String name;
    }
}
