import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static HashMap<String, String> friends;
    static HashMap<String, Integer> friendsCount;
    static int totalCnt = 0;
    
    static String find(String v){
        if (friends.get(v).equals(v)) return v;
        else{
            String root = find(friends.get(v));
            friends.put(v, root); 
            return root;
        }
    }
    
    static int union(String a, String b){
        String rootA = find(a);
        String rootB = find(b);
        int rootACnt = friendsCount.get(rootA);
        int rootBCnt = friendsCount.get(rootB);

        
        if (rootA.equals(rootB)){
            return friendsCount.get(rootA);
        }else if (rootA.compareTo(rootB) > 0){
            friends.put(rootA, rootB);
            friendsCount.put(rootB, rootBCnt + rootACnt);
            return friendsCount.get(rootB);
        }else {
            friends.put(rootB, rootA);
            friendsCount.put(rootA, rootACnt + rootBCnt);
            return friendsCount.get(rootA);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
    
        while (T-- > 0){
           int F = Integer.parseInt(br.readLine());
            friends = new HashMap<>();
            friendsCount = new HashMap<>();
    
            for (int i=0; i<F; i++){
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                if (!friends.containsKey(f1)){
                    friends.put(f1, f1);
                    friendsCount.put(f1, 1);
                }
                if (!friends.containsKey(f2)){
                    friends.put(f2, f2);
                    friendsCount.put(f2, 1);
                }
                int max = union(f1, f2);
                System.out.println(max);
            }
        }
    }
}