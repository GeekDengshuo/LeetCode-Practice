package src.graph;

import java.sql.Struct;
import java.util.*;

/**
 * @Author deng shuo
 * @Date 2021/1/18 21:22
 * @Version 1.0
 */
public class CountsMerge_721 {

    public List<List<String>>  accountsMerge(List<List<String>> accounts){
        Map<String,Integer> email2Index = new HashMap<>();
        Map<String,String> email2Name = new HashMap<>();
        int emailCounts = 0;
        for(List<String> account : accounts){
            String name = account.get(0);
            int len = account.size();
            for(int i= 1;i< len;i++){
                String email = account.get(i);
                if(!email2Index.containsKey(email)){
                    email2Index.put(email,emailCounts++);
                    email2Name.put(email,name);
                }
            }
        }
        UnionFind unionFind = new UnionFind(emailCounts);
        for(List<String> account : accounts){
            String firstEmail = account.get(1);
            int firstIndex = email2Index.get(firstEmail);
            int len = account.size();
            for(int i= 2;i<len;i++){
                String curEmail = account.get(i);
                int curIndex = email2Index.get(curEmail);
                unionFind.union(firstIndex,curIndex);
            }
        }
        Map<Integer,List<String>> index2Emails = new HashMap<>();
        for(String email : email2Index.keySet()){
            int index = unionFind.find(email2Index.get(email));
            List<String> account = index2Emails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            index2Emails.put(index,account);

        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> email : index2Emails.values()){
            Collections.sort(email);
            String name = email2Name.get(email.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(email);
            result.add(account);

        }
        return result;

    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
