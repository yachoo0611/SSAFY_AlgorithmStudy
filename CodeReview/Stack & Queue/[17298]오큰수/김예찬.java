package ssafy.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Boj_17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int N;
	static int[]arr;//입력배열
	static int[]answer;//정답배열
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
         N = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
         arr = new int[N];
        
         for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } 
        
        

        answer = new int[N];//정답배열
        
        
        
        
        for(int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        
        
        
        for(int k : answer) {
            sb.append(k+" ");
        }
        System.out.print(sb.toString());
    }
}
 