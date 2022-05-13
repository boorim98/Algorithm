import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pri = new PriorityQueue<>();
        
        for (int i : scoville) {
            pri.add(i);
        }
        
        while (pri.peek() < K) {
            
            if (pri.size() == 1) {
                return -1;
            }
            
            int first = pri.poll();
            int second = pri.poll();
            int sum = first + second * 2;
            
            
            pri.offer(sum);
            answer++;
        }
        return answer;
    }
}