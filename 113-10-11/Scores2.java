

import java.util.Arrays;

public class Scores2 {
    public static void main(String[] args) {
        var scores = new int[10];
        
        for(var score : scores) {
            System.out.printf("%2d", score);
        }
        System.out.println();
        
        Arrays.fill(scores, 60);
        for(var score : scores) {
            System.out.printf("%3d", score);
        }
        System.out.println();
        for (int i = 0; i < scores.length; i++) {
            scores[i] -= 30;
        }
        for(var score : scores) {
            System.out.printf("%3d", score);
        }

        
    }
}