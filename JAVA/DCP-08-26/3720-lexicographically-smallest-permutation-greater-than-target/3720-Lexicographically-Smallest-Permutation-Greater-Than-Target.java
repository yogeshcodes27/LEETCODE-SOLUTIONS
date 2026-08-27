class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] res = new char[n];

        for (int i = 0; i < n; i++) {

            int curr = target.charAt(i) - 'a';

            // Cannot match target[i]
            if (freq[curr] == 0) {
                return backtrack(res, target, freq, i);
            }

            res[i] = target.charAt(i);
            freq[curr]--;
        }

        // Entire target was matched.
        // Now we need something strictly greater.
        return backtrack(res, target, freq, n - 1);
    }

    private String backtrack(
            char[] res,
            String target,
            int[] freq,
            int i) {

        while (i >= 0) {

            int curr = target.charAt(i) - 'a';

            // If this position was already matched,
            // return its character to freq.
            if (res[i] == target.charAt(i)) {
                freq[curr]++;
            }

            // Find smallest character > target[i]
            for (int c = curr + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    res[i] = (char) ('a' + c);
                    freq[c]--;

                    // Put remaining characters
                    // in smallest order.
                    int pos = i + 1;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            res[pos++] = (char) ('a' + x);
                            freq[x]--;
                        }
                    }

                    return new String(res);
                }
            }

            i--;
        }

        return "";
    }
}