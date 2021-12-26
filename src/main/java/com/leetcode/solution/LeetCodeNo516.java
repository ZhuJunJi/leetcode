package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/16
 * @since 1.0
 */
public class LeetCodeNo516 {

    public int longestPalindromeSubseq(String s) {
        if(s.length() <= 1) return 1;

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        dp(dp,s,0,s.length() - 1);
        return dp[0][s.length() - 1];
    }

    public void dp(int[][] dp, String s, int begin, int end){
        if(begin >= end){
            dp[begin][begin] = 1;
            return;
        }
        if(dp[begin][end] != 0)return;
        if(s.charAt(begin) == s.charAt(end)){
            dp(dp,s,begin + 1, end - 1);
            dp[begin][end] = dp[begin + 1][end - 1] + 2;
        }else {
            dp(dp,s,begin, end - 1);
            dp(dp,s,begin + 1, end);
            dp[begin][end] = Math.max(dp[begin][end - 1],dp[begin + 1][end]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeNo516().longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
    }


}
