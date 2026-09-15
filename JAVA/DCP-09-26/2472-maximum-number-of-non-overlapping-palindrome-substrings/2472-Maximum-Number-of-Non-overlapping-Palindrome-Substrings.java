class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || pal[i + 1][j - 1]) {
                        pal[i][j] = true;
                    }
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i];

            for (int j = 0; j <= i; j++) {
                if (i - j + 1 >= k && pal[j][i]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}