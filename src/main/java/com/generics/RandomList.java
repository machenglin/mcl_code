package com.generics;

import com.clearspring.analytics.util.Lists;

import java.util.List;
import java.util.Random;

/**
 * Created by machenglin on 2018/4/11.
 */
public class RandomList<T> {
    private List<T> storage = Lists.newArrayList();
    private Random random = new Random(47);
    public void add(T item){
        storage.add(item);
    }
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for(String str:"I am a programer".split(" ")){
            randomList.add(str);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(randomList.select());
        }
    }
}
