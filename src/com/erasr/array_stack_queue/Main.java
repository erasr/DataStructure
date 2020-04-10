package com.erasr.array_stack_queue;

import com.erasr.array_stack_queue.ArrayQueue;
import com.erasr.array_stack_queue.LoopQueue;
import com.erasr.array_stack_queue.Queue;

import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> queue, int opcount) {
        long startTime, endTime;
        startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ; i < opcount ; i ++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0 ; i < opcount ; i ++) {
            queue.dequeue();
        }

        endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        Array arr = new Array(20);
//        for(int i = 0 ; i < 10 ; i ++) {
//            arr.addLast(i);
//        }
//
//        System.out.println(arr);
//        ArrayStack as = new ArrayStack();
        ArrayQueue queue = new ArrayQueue();
        LoopQueue lq = new LoopQueue();
//        for(int i = 0 ; i < 20 ; i ++) {
//            lq.enqueue(i);
//            System.out.println(lq);
//
//            if(i % 3 == 2) {
//                lq.dequeue();
//                System.out.println(lq);
//
//            }
//        }
        System.out.println(testQueue(queue, 10000));
        System.out.println(testQueue(lq, 10000));

    }
}
