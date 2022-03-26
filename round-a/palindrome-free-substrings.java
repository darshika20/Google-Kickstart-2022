/**
 * author: Darshika
 * Question Link: https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e762e#problem
 * Time Complexity: O(n) n- length of string
 * Space Complexity: O(1) - the queue will have at max 2^6 - 64 combination strings 
 * */
//Palindrome free Strings
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int len = in.nextInt();
            String binary = in.next();//"100??"
            Queue<String> q1 = new LinkedList<>();//["1"]
            Queue<String> q2 = new LinkedList<>();
            if (binary.charAt(0) == '?') {
                q1.offer("0");
                q1.offer("1");
            } else {
                q1.offer(binary.charAt(0)+"");
            }
            boolean flag = true;
            for (int i1 = 1;i1<binary.length();i1++){
                char ch = binary.charAt(i1);//"0"
                while(!q1.isEmpty()){//["1"]
                    String temp = q1.poll();//"1"
                    if (ch == '?') {
                        if (temp.length() >= 4) {
                            performPalidromicValidation(temp+"0", q2);
                            performPalidromicValidation(temp+"1", q2);
                        } else {
                            q2.offer(temp+"0");
                            q2.offer(temp+"1");
                        }
                    } else {
                        if (temp.length() >= 4) {
                            performPalidromicValidation(temp+ch, q2);
                        } else {
                            q2.offer(temp+ch);
                        }
                    }
                }
                if (q2.isEmpty()) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    flag = false;
                    break;
                }
                while (!q2.isEmpty()){
                    q1.offer(q2.poll());
                }
            }
            if (flag) {
                System.out.println("Case #" + i + ": POSSIBLE");
            }
        }
    }

    private static void performPalidromicValidation(String s, Queue<String> q) {

        if ((s.length() == 5 && !isPalindrome(s))){
            q.offer(s);
        } else if ((s.length() == 6 && !isPalindrome(s) && !isPalindrome(s.substring(1)))) {
            q.offer(s.substring(1));
        }
    }

    private static boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length()-1;
        while (lo<hi){
            if (s.charAt(lo) != s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
