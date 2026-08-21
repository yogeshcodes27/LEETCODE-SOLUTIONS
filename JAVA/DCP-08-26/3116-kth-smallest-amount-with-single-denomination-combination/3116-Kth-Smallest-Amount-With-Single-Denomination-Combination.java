class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l = 1, r = (long) coins[0] * k;

        while (l < r) {
            long m = (l + r) / 2;
            if (count(m, coins) >= k) r = m;
            else l = m + 1;
        }
        return l;
    }

    long count(long x, int[] c) {
        long ans = 0;

        for (int mask = 1; mask < (1 << c.length); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < c.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    lcm = lcm(lcm, c[i]);
                    if (lcm > x) break;
                }
            }

            long v = x / lcm;
            ans += (bits % 2 == 1) ? v : -v;
        }

        return ans;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}