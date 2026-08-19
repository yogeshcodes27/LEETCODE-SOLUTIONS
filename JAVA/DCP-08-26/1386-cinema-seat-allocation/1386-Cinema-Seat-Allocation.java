class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        // Rows with no reservations can fit 2 families
        int answer = (n - map.size()) * 2;

        for (int row : map.keySet()) {

            HashSet<Integer> seats = map.get(row);

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // Seats 2-5
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                }
            }

            // Seats 4-7
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                }
            }

            // Seats 6-9
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                }
            }

            if (left && right) {
                answer += 2;
            }
            else if (left || middle || right) {
                answer++;
            }
        }

        return answer;
    }
}