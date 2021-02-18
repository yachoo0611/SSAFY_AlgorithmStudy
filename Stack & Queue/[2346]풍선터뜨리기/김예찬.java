package ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_2346 {
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    static StringTokenizer st;
	    static StringBuffer sb = new StringBuffer();
	    static Deque<int[]> deque = new ArrayDeque();
	    static int N;
	 
	    public static void main(String[] args) throws Exception {
	        
	    	
	    	st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	 
	        
	        
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= N; i++) {
	            deque.addLast(new int[] { Integer.parseInt(st.nextToken()), i });
	        }
	       
	        
	        
	        
	        for (int i = 0; i < N; i++) {
	            int next = deque.peekFirst()[0];
	            sb.append(deque.peekFirst()[1] + " ");
	            deque.removeFirst();
	 
	            if (deque.isEmpty())
	                break;
	            
	            if (next > 0) {
	                next--;
	                while (next-- > 0) {
	                    deque.addLast(deque.peekFirst());
	                    deque.removeFirst();
	                }
	            } else {
	                while (next++ < 0) {
	                    deque.addFirst(deque.peekLast());
	                    deque.removeLast();
	                }
	            }
	        }
	        System.out.println(sb.toString());
	    }
	}