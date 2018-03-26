package com.generics;

/**
 * 元组类库
 * Created by machenglin on 2018/1/21.
 */
public class TwoTuple<L, R> {
    private L left;
    private R right;

    private TwoTuple(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> TwoTuple<L, R> of(L left, R right) {
        return new TwoTuple<>(left, right);
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    public static void main(String[] args) {
        TwoTuple<String, String> twoTuple = TwoTuple.of("马小林", "北京");
        System.out.println(twoTuple.getLeft());
        System.out.println(twoTuple.getRight());
    }
}
