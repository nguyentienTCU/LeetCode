class Solution {
    public int longestPalindrome(String[] words) {
        int[][] cnt = new int[26][26];
        for (String w : words) {
            int a = w.charAt(0) - 'a';
            int b = w.charAt(1) - 'a';
            cnt[a][b]++;
        }

        int ans = 0;
        boolean hasCenter = false;

        // match asymmetric pairs (a,b) with (b,a), a<b to avoid double count
        for (int a = 0; a < 26; a++) {
            for (int b = a + 1; b < 26; b++) {
                int pairs = Math.min(cnt[a][b], cnt[b][a]);
                ans += pairs * 4;
            }
        }

        // handle palindromic "aa","bb",...
        for (int x = 0; x < 26; x++) {
            int c = cnt[x][x];
            ans += (c / 2) * 4;
            if (c % 2 == 1) hasCenter = true;
        }

        if (hasCenter) ans += 2;
        return ans;
    }
}
