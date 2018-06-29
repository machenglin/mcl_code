package com.algorithm;

/**
 * 求解最大公约数
 * Created by Mcl on 2018/6/20.
 */
public class GcdTest {
    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(8, 6));
        System.out.println(gcd(6, 8));
    }

}
