package src.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 6/29/21 21:09
 * @Version 1.0
 */
public class LRUCache2 {

    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    private Map<Integer,DoubleLinkedNode> hashMap;

    private int initialCapacity;

    class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        DoubleLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public LRUCache2(int capacity) {

        head = new DoubleLinkedNode(0,0);
        tail = new DoubleLinkedNode(0,0);

        initialCapacity = capacity;

        hashMap = new HashMap<>(capacity * 4/3);  //

        head.next = tail;
        tail.prev = head;


    }

    public int get(int key) {

        // -1 not contains
        if(!hashMap.containsKey(key)){
            return -1;
        }
        DoubleLinkedNode cur = hashMap.get(key);

        // update
        removeCurrentNode(cur);
        addToHead(cur);

        return cur.value;

    }

    public void put(int key, int value) {

        DoubleLinkedNode node = hashMap.get(key);

        if(node == null){
            node = new DoubleLinkedNode(key,value);
        }
        node.value = value;
        addToHead(node);
        hashMap.put(key,node);

        // overflow
        if(hashMap.size() > initialCapacity){
            DoubleLinkedNode remove = removeTailNode();
            hashMap.remove(remove.key);
        }
    }

    private void removeCurrentNode(DoubleLinkedNode cur){
        DoubleLinkedNode prev = cur.prev;
        DoubleLinkedNode next = cur.next;

        prev.next = next;
        next.prev = prev;

        cur.next = null;
        cur.prev = null;
    }

    private void addToHead(DoubleLinkedNode node){
        DoubleLinkedNode headNext = head.next;

        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }

    private DoubleLinkedNode removeTailNode(){

        DoubleLinkedNode remove = tail.prev;

        DoubleLinkedNode removePrev = remove.prev;


        removePrev.next = tail;
        tail.prev = removePrev;

        remove.next = null;
        remove.prev = null;

        return remove;
    }
}
