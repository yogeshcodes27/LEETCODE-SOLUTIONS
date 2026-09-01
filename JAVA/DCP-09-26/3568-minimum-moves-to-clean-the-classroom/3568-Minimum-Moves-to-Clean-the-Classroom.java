import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int count = 0;

        int[][] id = new int[m][n];

        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int fullMask = (1 << count) - 1;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc, energy, 0});

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << count];

        visited[sr][sc][energy][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == fullMask) {
                    return moves;
                }

                if (e == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int ne = e - 1;
                    int nm = mask;

                    char next = classroom[nr].charAt(nc);

                    if (next == 'L') {
                        nm |= (1 << id[nr][nc]);
                    }

                    if (next == 'R') {
                        ne = energy;
                    }

                    if (!visited[nr][nc][ne][nm]) {

                        visited[nr][nc][ne][nm] = true;

                        q.offer(new int[]{
                            nr, nc, ne, nm
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}