package com.generics;

/**
 * Created by machenglin on 2018/4/11.
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n){
        if(n<2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for(int i =0;i<10;i++){
            System.out.println(fibonacci.next());
        }
    }
}
