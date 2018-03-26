package com.design.decorator;

/**
 * Created by Mcl on 2018/3/15.
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        System.out.println("---------");
        component.method();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);
        System.out.println("---------");
        concreteDecoratorA.method();
        concreteDecoratorA.methodA();

        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(component);
        System.out.println("---------");
        concreteDecoratorB.method();
        concreteDecoratorB.methodB();
        concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        System.out.println("---------");
        concreteDecoratorB.method();
        concreteDecoratorB.methodB();

    }


}
