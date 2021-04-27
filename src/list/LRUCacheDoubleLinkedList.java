package src.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 4/24/21 10:23
 * @Version 1.0
 */


public class LRUCacheDoubleLinkedList {
    class MyLinkedNode{
        int key;
        int value;
        MyLinkedNode pre;
        MyLinkedNode next;
        public MyLinkedNode(){};
        public MyLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,MyLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;

    private MyLinkedNode head,tail;

    public LRUCacheDoubleLinkedList(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new MyLinkedNode();
        tail = new MyLinkedNode();
        // connect
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        MyLinkedNode linkedNode = cache.get(key);
        if(linkedNode == null){
            return -1;
        }
        // move to head  - access order
        moveToHead(linkedNode);
        return linkedNode.value;
    }

    public void put(int key,int value){
        MyLinkedNode linkedNode = cache.get(key);
        if(linkedNode == null){
            MyLinkedNode newNode = new MyLinkedNode(key,value);
            cache.put(key,newNode);

            addToHead(newNode);
            ++size;
            if(size > capacity){
                MyLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                --size;
            }
        }else{
            linkedNode.value = value;
            moveToHead(linkedNode);
        }
    }

    private void removeNode(MyLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(MyLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(MyLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private MyLinkedNode removeTail(){
        MyLinkedNode node = tail.pre;
        cache.remove(node.key);
        return node;
    }
}
