package lc;

import java.util.*;

/*
https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {
    /*
        qn: "ab"

        answer = [a, A]

        answer = [ab, Ab, aB, AB]



     */
    public static List<String> letterCasePermutation(String S) {

        List<String> answer = new ArrayList<>();


        /*




         */
        if(S.length() == 0) {
            return answer;
        }
        answer.add("");

        /*
           ab
           answer [""]

           i = 0
           answerTillPosI = []
           char=a;
           answerTillPosI = [a, A]
           answer = [a, A]

           i = 1
           ch = b
           j = 0
             answerTillPosI = [ab, aB,
           j = 1
           answerTillPosI[ab, aB, Ab, AB]
           answer =            answerTillPosI

         */

        for (int i = 0; i < S.length(); i++) {
            final List<String> answerTillPosI = new ArrayList<>();
            for (int j = 0; j < answer.size(); j++) {
                if(Character.isDigit(S.charAt(i))) {

                    answerTillPosI.add(answer.get(j) + S.charAt(i));
                } else  {
                    answerTillPosI.add(answer.get(j) + Character.toUpperCase(S.charAt(i)));
                    answerTillPosI.add(answer.get(j) + Character.toLowerCase(S.charAt(i)));
                }
            }
            answer = answerTillPosI;

        }
        return answer;

    }


    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b1"));
    }


}


