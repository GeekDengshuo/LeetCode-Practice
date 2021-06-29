package src.algorithm;

import java.util.Iterator;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 6/29/21 21:04
 * @Version 1.0
 */
public class LRUCache<K,V> implements Iterable<K> {

    private DNode head;
    private DNode tail;

    private Map<K,DNode> hashMap;


    class DNode{
        K k;
        V v;
        DNode next;
        DNode prev;

        DNode(K k,V v){
            this.k = k;
            this.v = v;
            prev = null;
            next = null;
        }
    }

    public LRUCache(int capacity){



    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
