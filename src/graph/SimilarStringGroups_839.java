package src.graph;

/**
 * @Author deng shuo
 * @Date 2021/1/31 21:04
 * @Version 1.0
 */
public class SimilarStringGroups_839 {

    int[] parent;
    public int numSimilarGroups(String[] str){
        int len = str.length;
        int size = str[0].length();

        parent = new int[len];
        for(int i = 0; i < len ;i++){
            parent[i] = i;
        }

        for(int i = 0;i < len;i++){
            for(int j = i+1;j<len;j++){
                if(find(i)== find(j)){
                    continue;
                }
                if(check(str[i],str[j],size)){
                    parent[find(i)] = find(j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            if(find(i) == i){
                result++;
            }
        }
        return result;
    }

    private int find(int index){
        if(index != parent[index]){
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    private boolean check(String str1,String str2,int len){
        int num = 0;
        for (int i = 0; i < len; i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                num++;

                if(num > 2){
                    return false;
                }
            }
        }
        return true;
    }
}
