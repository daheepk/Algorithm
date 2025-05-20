import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int priority(char c){
        switch (c){
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default :
                return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        char[] charArr = br.readLine().toCharArray();

        for (char ch : charArr){
            if (Character.isLetter(ch)){
                sb.append(ch);
            }else if (ch == '('){
                 stack.push(ch);   
            }else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    char element = stack.pop();
                    sb.append(element);
                }
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)){
                    if (stack.peek() == '(') break;
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}