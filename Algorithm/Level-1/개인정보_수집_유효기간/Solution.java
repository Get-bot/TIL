package 개인정보_수집_유효기간;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> termMap = Arrays.stream(terms)
                .map(term -> term.split(" "))
                .collect(Collectors.toMap(term -> term[0], term -> Integer.parseInt(term[1])));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        return IntStream.range(0, privacies.length)
                .filter( i -> {
                    String[] privacy = privacies[i].split(" ");
                    LocalDate endDate =LocalDate.parse(privacy[0], formatter)
                            .plusMonths(termMap.get(privacy[1]));
                    return endDate.isBefore(todayDate) || endDate.isEqual(todayDate);
                })
                .map(i -> i + 1)
                .toArray();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = solution.solution(today, terms, privacies);
        Arrays.stream(answer).forEach(System.out::println);

    }
}
