package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/8
 * @since 1.0
 */
public class LeetCodeNo139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s,new HashSet<>(wordDict),s.length())[s.length()];
    }

    public boolean[] dp(String s, HashSet<String> wordDictSet, int n){
        if(n == 0) {
         boolean[] booleans = new boolean[s.length() + 1];
         booleans[0] = true;
         return booleans;
        }
        boolean[] booleans = dp(s, wordDictSet, n - 1);
        for (int i = n - 1; i >= 0; i--) {
            if(booleans[i] && wordDictSet.contains(s.substring(i,n))){
                booleans[n] = true;
                break;
            }else {
                booleans[n] = false;
            }
        }
        return booleans;
    }

    public static void main(String[] args) {
        String s = "leetcodelecetcodecode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new LeetCodeNo139().wordBreak(s,wordDict));
    }
}
