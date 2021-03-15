package src.hash;

/**
 * @Author deng shuo
 * @Date 3/14/21 20:06
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 设计一个简单的HashMap
 */

class Pair<U,V>{

    U first;
    V second;

    public Pair(U first,V second){
        this.first = first;
        this.second = second;
    }

}

class Bucket{
    private List<Pair<Integer,Integer>> bucket;

    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer,Integer>>();
    }

    public void update(Integer key,Integer value){
        boolean flag = false;
        for(Pair<Integer,Integer> pair: bucket){
            if(pair.first.equals(key)){
                flag = true;
                pair.second = value;
            }
        }
        if(!flag){
            bucket.add(new Pair<Integer, Integer>(key,value));
        }
    }

    public Integer get(Integer key){
        for(Pair<Integer,Integer> pair: bucket){
            if(pair.first.equals(key)){

                return pair.second;
            }
        }
        return -1;
    }

    public void remove(Integer key){
        for(Pair<Integer,Integer> pair:this.bucket){
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }

}
public class DesignHashMap_706 {

    private int keySpace;

    private List<Bucket> hashTable;

    public DesignHashMap_706(){
        this.keySpace = 2069;
        this.hashTable = new ArrayList<Bucket>();
    }

    public void add(int key,int value){
        int hashKey = key % keySpace;
        this.hashTable.get(hashKey).update(key,value);
    }

    public int getKey(int key){
        return this.hashTable.get(key%keySpace).get(key);
    }

    public void remove(int key){
        int hash_key=key % keySpace;
        this.hashTable.get(hash_key).remove(key);
    }
}
