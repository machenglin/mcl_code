package com.concurrent.thread;

import com.clearspring.analytics.util.Lists;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.*;

/**
 * 线程返回结果
 * Created by machenglin on 2018/3/26.
 */
@AllArgsConstructor
public class TaskWithResult implements Callable<String> {
    private int id;
    @Override
    public String call() throws Exception {
        return "result: " + id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList =  Lists.newArrayList();
        for(int i =0;i<10;i++){
            Future<String> result = executorService.submit(new TaskWithResult(i));
            futureList.add(result);
        }
        futureList.forEach((data) -> {
            try {
                System.out.println(data.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        });

    }
}
