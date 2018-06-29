package com.generics;

/**
 * Created by machenglin on 2018/1/21.
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    private void push(T item) {
        top = new Node<>(item, top);
    }

    private T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("林");
        stack.push("小");
        stack.push("马");
        String item;
        while ((item = stack.pop()) != null) {
            System.out.print(item);
        }
    }
}
