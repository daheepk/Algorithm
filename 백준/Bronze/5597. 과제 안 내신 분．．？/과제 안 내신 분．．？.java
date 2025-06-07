import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<28; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i=1; i<=30; i++){
            if (!list.contains(i)) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}