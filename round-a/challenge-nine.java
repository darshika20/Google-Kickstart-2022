/**
 * author: Darshika
 * Question Link: https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e7997
 * Time Complexity: O(n) n- no of digits in the number
 * Space Complexity: O(1)
 * */
//Challenge nine
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String num = in.next();
            int sum = 0;
            for(char ch : num.toCharArray()) {
                sum += (ch - '0');
            }
            if (sum % 9 == 0) {
                num = num.substring(0,1) + '0' + num.substring(1);
                System.out.println("Case #" + i + ": " + num);
                continue;
            }
            int to_add = (((sum/9) + 1 ) * 9) - sum;
            int ol = num.length();
            for(int i1 = 0;i1<num.length();i1++) {
                int c = num.charAt(i1) - '0';
                if ( c > to_add) {
                    num = num.substring(0,i1) + to_add + num.substring(i1);
                    break;
                }
            }
            if (num.length() == ol) {
                num = num + to_add;
            }
            System.out.println("Case #" + i + ": " + num);
        }
    }
}
