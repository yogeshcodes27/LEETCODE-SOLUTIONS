class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<k;i++){
            leftsum+=cardPoints[i];
        }
        int max=leftsum;
        int rightlen=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftsum-=cardPoints[i];
            rightsum+=cardPoints[rightlen];
            rightlen--;
            max=Math.max(max,leftsum+rightsum);
        }
       return max;
    }
}