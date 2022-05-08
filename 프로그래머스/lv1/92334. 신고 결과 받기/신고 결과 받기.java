import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        /*
        * key 는 유저ID
        * value 는 신고한 유저ID의 set 을 가진 map
        * 동일한 유저ID에 대한 신고횟수는 1회로 처리하기 때문에 중복 허용을 하지 않는 set 을 value 로 사용
        * */
        
        Map<String, HashSet<String>> reportedMap = new HashMap<>(); // [신고된ID, [신고한ID]]
		Map<String, Integer> answerMap = new HashMap<>();
        
        /* 1. Map 초기화 */
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reportingId = new HashSet<>(); // 신고한ID
            reportedMap.put(id_list[i], reportingId);
            answerMap.put(id_list[i], 0);
        }
        /*
		 * 2. 신고 기록 세팅 report 는 "신고한ID 신고된ID" 로 구성됨
		 */
        for (String s : report) {
            String[] reportStr = s.split(" ");
			String reportingId = reportStr[0]; // 신고한ID
			String reportedId = reportStr[1]; // 신고된ID
            reportedMap.get(reportedId).add(reportingId);
        }
        /*
		 * 3. 유저가 받은 이용 정지 결과 메일 세팅
		 */
        for (String reportedUser : reportedMap.keySet()) { // reportedUser 는 신고된ID유저
			HashSet<String> userForSend = reportedMap.get(reportedUser); // reportedUser(신고된유저)를 신고한 유저
			if (userForSend.size() >= k) { // 신고된 횟수가 K번 이상일 경우
				for (String userId : userForSend) {
					answerMap.put(userId, answerMap.get(userId) + 1); // answerMap 에 신고된Id 별 메일 수 넣기
				}
			}
		}
        /*
		 * 4. 유저ID 별 받은 메일 수를 answer 에 세팅
		 */
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = answerMap.get(id_list[i]);
        }
        return answer;
    }
}