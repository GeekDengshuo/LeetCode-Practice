package src.algorithm;

import src.list.LRUCacheDoubleLinkedList;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @Author deng shuo
 * @Date 6/29/21 21:39
 * @Version 1.0
 */
public class LRUCacheLinkedHashMap {

    private LinkedHashMap<Integer,Integer> cache;

    private int capacity;


    public LRUCacheLinkedHashMap(int cap){
        this.capacity = cap;

        cache = new LinkedHashMap<>(cap);
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);

        return value;
    }

    public void put(int key,int value){
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        if(capacity == cache.size()){
            Set<Integer> keySets = cache.keySet();
            Iterator<Integer> iterator = keySets.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key,value);
    }
}
