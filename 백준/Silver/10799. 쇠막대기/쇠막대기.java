import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stick = br.readLine();
        int len = stick.length();

        Stack<Character> stack = new Stack<>();

        int count = 0;
        int stickCnt = 0;

        char first = stick.charAt(0);
        stack.push(first);
        stickCnt += 1;
        boolean flag = true;
        
        for (int i=1; i<len; i++){
            char target = stick.charAt(i);
            if (target == ')'){
                if (stack.size() != 0){
                    if (flag) {
                        stack.pop();
                        if (i != 1 && stickCnt > 0){
                            stickCnt-=1;
                            count += stickCnt;
                            
                        }else if (i == 1){
                            stickCnt -= 1;
                        }
                    }
                    else if (!flag){
                        stickCnt -= 1;
                        count += 1;
                    }
                    flag = false;
                }
                
            }else {
                stack.push('(');
                stickCnt += 1;
                flag = true;            
            }
        }

        System.out.print(count);

    }
}