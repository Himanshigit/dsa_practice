class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Initialize for patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // 0 occurrence of char before '*'
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);  // current char in s
                char pc = p.charAt(j - 1);  // current char in p

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char prev = p.charAt(j - 2); // character before '*'
                    dp[i][j] = dp[i][j - 2]; // case: zero occurrence

                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // one or more occurrences
                    }
                }
            }
        }

        return dp[n][m];
    }
}
