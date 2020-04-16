package com.erasr.heap_and_priorityqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @program: DataStructure
 * @description: LeetCode第347号问题，使用自己的「优先队列」解决
 * @author: xuguangwei
 * @create: 2020-04-15 21:50
 */
public class Num347 {
    public class Freq implements Comparable<Freq> {
        int e, freq;
        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if(this.freq < another.freq) {
                return 1;
            } else if(this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: nums) {
            if(pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if(map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(pq.getFront().e);
        }
        return res;
    }
}