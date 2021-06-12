package src.bloomFilter;

import java.util.BitSet;

/**
 * @Author deng shuo
 * @Date 6/12/21 10:07
 * @Version 1.0
 */
public class MyBloomFilter {

    private static final int DEFAULT_SIZE = 2 << 24;

    private static int[] SEEDS = new int[]{3,13,46};

    private static BitSet bits = new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter(){
        for(int i = 0;i< SEEDS.length;i++){
            func[i] = new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }

    public void add(Object value){
        for(SimpleHash f: func){
            bits.set(f.hash(value),true);
        }
    }

    public boolean contains(Object value){
        boolean res = true;
        for(SimpleHash f:func){
            res = bits.get(f.hash(value));
            if(!res){
                return false;
            }
        }
        return true;
    }

    public static class SimpleHash{
        private int cap;
        private int seed;

        public SimpleHash(int cap ,int seed){
            this.cap = cap;
            this.seed = seed;
        }
        public int hash(Object value){
            int h;
            return (value == null) ? 0:
                    Math.abs(seed*(cap -1) & (h=value.hashCode())^(h>>>16));
        }
    }

}
