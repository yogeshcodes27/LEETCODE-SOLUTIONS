class Solution {
    static class Interval {
        int l, r, w, id;

        Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }
    }

    static class State {
        long score;
        int[] ids;

        State(long score, int[] ids) {
            this.score = score;
            this.ids = ids;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Interval[] a = new Interval[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(a, (x, y) -> {
            if (x.l != y.l)
                return Integer.compare(x.l, y.l);
            return Integer.compare(x.r, y.r);
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n;

            while (left < right) {
                int mid = (left + right) / 2;

                if (a[mid].l > a[i].r)
                    right = mid;
                else
                    left = mid + 1;
            }

            next[i] = left;
        }

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = new State(0, new int[0]);

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];

                State suffix = dp[next[i]][k - 1];

                int[] ids = new int[suffix.ids.length + 1];

                int p = 0;
                boolean inserted = false;

                for (int x : suffix.ids) {
                    if (!inserted && a[i].id < x) {
                        ids[p++] = a[i].id;
                        inserted = true;
                    }

                    ids[p++] = x;
                }

                if (!inserted)
                    ids[p] = a[i].id;

                State take = new State(
                    a[i].w + suffix.score,
                    ids
                );

                dp[i][k] = better(take, skip) ? take : skip;
            }
        }

        return dp[0][4].ids;
    }

    private boolean better(State a, State b) {
        if (a.score != b.score)
            return a.score > b.score;

        int n = Math.min(a.ids.length, b.ids.length);

        for (int i = 0; i < n; i++) {
            if (a.ids[i] != b.ids[i])
                return a.ids[i] < b.ids[i];
        }

        return a.ids.length < b.ids.length;
    }
}