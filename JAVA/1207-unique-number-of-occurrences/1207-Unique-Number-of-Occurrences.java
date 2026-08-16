class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];

        for (int num : arr) {
            count[num + 1000]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;

            for (int j = i + 1; j < count.length; j++) {
                if (count[i] == count[j])
                    return false;
            }
        }

        return true;
    }
}