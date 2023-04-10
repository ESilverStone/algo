package 보드게임컵;

import java.util.*;

public class p27172_수나누기게임 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = numbers.length;

        // 1. 약수 계산 및 저장
        List<Integer>[] divisors = new List[n];
        for (int i = 0; i < n; i++) {
            divisors[i] = new ArrayList<>();
            for (int j = 1; j * j <= numbers[i]; j++) {
                if (numbers[i] % j == 0) {
                    divisors[i].add(j);
                    if (j != numbers[i] / j) {
                        divisors[i].add(numbers[i] / j);
                    }
                }
            }
        }

        // 2. 결투 및 점수 계산
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    for (int k : divisors[j]) {
                        if (k == numbers[i]) {
                            scores[i]++;
                        }
                        if (k == numbers[j]) {
                            scores[i]--;
                        }
                    }
                }
            }
        }

        // 3. 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.println("Player " + numbers[i] + " : " + scores[i] + " points");
        }
    }
}
