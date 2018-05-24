package com.generics;

import com.clearspring.analytics.util.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 擦除的神秘之处
 * Created by machenglin on 2018/4/11.
 */
public class ErasedTyeEquivalencce {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
        System.out.println(c1);
        System.out.println(c2);

        // getTypeParameters:表示有泛型声明的类型参数
        List<Frob> frobList = Lists.newArrayList();
        System.out.println(Arrays.toString(frobList.getClass().getTypeParameters()));
        Map<Frob, Fnorkle> frobFnorkleMap = Maps.newHashMap();
        System.out.println(Arrays.toString(frobFnorkleMap.getClass().getTypeParameters()));
        Quark<Fnorkle> quark = new Quark<>();
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        Particle<Long, Double> particle = new Particle<>();
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));

    }

}

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM>{

}

