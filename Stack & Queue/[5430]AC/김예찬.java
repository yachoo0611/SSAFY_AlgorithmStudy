package ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj_5430 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb  ;
	static int T,n;
	static Deque<Integer> deque = new LinkedList<>();
	static String arrStr;
	public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String p = br.readLine();
             n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            
            for (String s : arrStr.substring(1, arrStr.length() - 1).split(",")) {
                if (!s.equals(""))
                    deque.add(Integer.parseInt(s)); // 문자열의 "[","]" 제거 하고  ","를 기준으로  deque에 add
            }
            

            
            System.out.println(ac(deque, p));
        }
    }

    static String ac(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        //커맨드에 따른 동작
        for (char command : commands.toCharArray()) {
            if (command == 'R')
                reverse = !reverse;
            else {//D일때
                if (deque.size() == 0) 
                    return "error";
                if (reverse)
                    deque.removeLast();
                else
                    deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");
        
        while (!deque.isEmpty()) {
        	
            sb.append(reverse ? deque.removeLast() : deque.removeFirst()); // reverse가 true면 뒤에서 추출 reverse가 false면 앞에서 추출
            if (deque.size() != 0)
                sb.append(',');
        }
        sb.append(']');

        return sb.toString();
    }
}