package 성격_유형_검사기;

import java.util.*;

public class Solution {
    static final int[] SURVEY_SCORES = {3, 2, 1, 0, 1, 2, 3};
    static final String[] PERSONALITY_TYPES = {"R", "T", "C", "F", "J", "M", "A", "N"};

    public static void main(String[] args) {
        String[] surveys = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        String answer = calculatePersonalityType(surveys, choices);
        System.out.println("Answer = " + answer);
    }

    public static String calculatePersonalityType(String[] surveys, int[] choices) {
        Map<String, Integer> surveyResults = calculateSurveyResults(surveys, choices);
        StringBuilder personalityBuilder = new StringBuilder();

        for (int i = 0; i < PERSONALITY_TYPES.length; i += 2) {
            String firstType = PERSONALITY_TYPES[i];
            String secondType = PERSONALITY_TYPES[i + 1];

            int firstTypeScore = surveyResults.get(firstType);
            int secondTypeScore = surveyResults.get(secondType);

            if (firstTypeScore >= secondTypeScore) {
                personalityBuilder.append(firstType);
            } else {
                personalityBuilder.append(secondType);
            }
        }

        return personalityBuilder.toString();
    }

    private static Map<String, Integer> calculateSurveyResults(String[] surveys, int[] choices) {
        Map<String, Integer> surveyCount = new LinkedHashMap<>();
        Arrays.stream(PERSONALITY_TYPES).forEach(type -> surveyCount.put(type, 0));

        for (int i = 0; i < surveys.length; i++) {
            String survey = surveys[i];
            int choiceIndex = choices[i] - 1;

            String chosenType = choiceIndex < 4 ? survey.substring(0, 1) : survey.substring(1);
            surveyCount.put(chosenType, surveyCount.get(chosenType) + SURVEY_SCORES[choiceIndex]);
        }

        return surveyCount;
    }
}
