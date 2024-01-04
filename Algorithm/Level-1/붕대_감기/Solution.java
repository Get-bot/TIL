package 붕대_감기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 공격 정보를 저장할 맵을 생성합니다.
        Map<Integer, Integer> attackMap = new HashMap<>();
        // 공격 정보 배열에서 시간과 해당 시간에 받는 피해를 맵에 저장합니다.
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
        }

        // 현재 체력을 초기 설정값으로 설정합니다.
        int currentHealth = health;
        // 연속 치유 성공 횟수를 추적하기 위한 변수입니다.
        int healContinuitySuccessCount = 0;
        // 마지막 공격이 일어나는 시간을 계산합니다.
        int lastAttackSecond = attacks.length > 0 ? attacks[attacks.length - 1][0] : 0;

        // 1초부터 마지막 공격 시간까지 반복합니다.
        for (int second = 1; second <= lastAttackSecond; second++) {
            // 현재 시간에 공격이 있으면 해당 공격만큼 체력을 감소시키고, 연속 치유 성공 횟수를 0으로 초기화합니다.
            if (attackMap.containsKey(second)) {
                currentHealth -= attackMap.get(second);
                healContinuitySuccessCount = 0;
                // 체력이 0 이하가 되면 -1을 반환하고 종료합니다.
                if (currentHealth <= 0) return -1;
            } else {
                // 공격이 없는 경우, 연속 치유 성공 횟수를 증가시킵니다.
                healContinuitySuccessCount++;
                // 연속 치유 성공 횟수에 따라 치유량을 계산합니다.
                int healAmount = bandage[1] + (healContinuitySuccessCount == bandage[0] ? bandage[2] : 0);
                // 계산된 치유량만큼 체력을 증가시키지만, 최대 체력을 초과하지 않도록 합니다.
                currentHealth = Math.min(health, currentHealth + healAmount);
                // 연속 치유 성공 횟수가 일정 횟수에 도달하면 0으로 초기화합니다.
                healContinuitySuccessCount %= bandage[0];
            }
        }
        // 최종 체력을 반환합니다.
        return currentHealth;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        Solution solution = new Solution();
        int result = solution.solution(bandage, health, attacks);
        System.out.println(result);
    }
}
