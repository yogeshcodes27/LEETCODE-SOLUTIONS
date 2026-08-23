class Solution {
    public boolean sumGame(String num) {
        int mid = num.length() / 2;
        int leftsum = 0, rightsum = 0;
        int leftq = 0, rightq = 0;
        for (int i = 0; i < mid; i++) {
            if (num.charAt(i) == '?')
                leftq++;
            else
                leftsum += num.charAt(i) - '0';
        }
        for (int i = mid; i < num.length(); i++) {
            if (num.charAt(i) == '?')
                rightq++;
            else
                rightsum += num.charAt(i) - '0';
        }
        if ((leftq + rightq) % 2 == 1)
            return true;
        return (leftsum - rightsum) != 9 *(rightq - leftq)/2;
    }
}