package ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Boj_9935 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String origin,bomb;
    public static void main(String[] args) throws IOException {

        origin = br.readLine();
        bomb = br.readLine();
        
        int bombLen = bomb.length();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            stack.add(c);
            
            if(stack.size() >= bombLen) {
                // 폭발 문자열과 서브 문자열이 같은지 검사
                boolean isSame = true;
                
                
                for(int j = 0; j < bombLen; j++) {  //폭탄문자열 길이만큼 돌면서 같은부분이 있는지 찾음
                    char c1 = stack.get(stack.size() - bombLen + j);
                    char c2 = bomb.charAt(j);
                    if(c1 != c2) {
                        isSame = false;
                        break;
                    }
                }
                
                
                if(isSame) { // 같은부분이 있으면 pop
                    for(int cnt = 0; cnt < bombLen; cnt++) {                        
                        stack.pop();
                    }
                }
            }
        } 
        
        
        if(stack.size() == 0) {
            System.out.println("FRULA");
        } else {

            for(char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
 
