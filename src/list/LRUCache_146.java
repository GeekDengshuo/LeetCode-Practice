package src.list;

/**
 * @Author deng shuo
 * @Date 4/24/21 09:00
 * @Version 1.0
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Least Recently Used 最近最少使用
 */
public class LRUCache_146 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache_146(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return getOrDefault(key,-1);
    }
    public void put(int key,int value){
        super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size() > capacity;
    }
}
