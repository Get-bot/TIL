package 신고_결과_받기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = solution(id_list,report,k);


    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> reportMap = new LinkedHashMap<>();

        for(String id : id_list) {
            reportMap.put(id,new HashSet<>());
        }

        for(String singleReport : report) {
            String[] ids = singleReport.split(" ");
            if(reportMap.containsKey(ids[1])) {
                reportMap.get(ids[1]).add(ids[0]);
            }
        }


        reportMap.forEach((key, value) -> {
            if(value.size() >= k) {
             for(String id: value) {
                 System.out.println("id = " + id);
                 answer[Arrays.asList(id_list).indexOf(id)]++;
             }
            }
        });

        return answer;
    }
}
