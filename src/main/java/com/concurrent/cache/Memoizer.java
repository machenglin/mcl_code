package com.concurrent.cache;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;

import java.util.concurrent.*;

/**
 * Created by machenglin on 2018/5/24.
 */
@AllArgsConstructor
public class Memoizer<A, V> implements Computable<A, V> {
    private Computable<A, V> c;

    private final ConcurrentHashMap<A, FutureTask<V>> cache = new ConcurrentHashMap<>();

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            FutureTask<V> f = cache.get(arg);
            if (f == null) {
                FutureTask<V> ft = new FutureTask<V>(() -> c.compute(arg));
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}


