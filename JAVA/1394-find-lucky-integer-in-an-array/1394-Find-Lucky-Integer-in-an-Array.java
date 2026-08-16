class Solution {
    public int findLucky(int[] arr) {
        int[] count=new int[501];
        int max=0;
        for(int num:arr){
            count[num]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==i){
                max=Math.max(max,i);
            }
        }
        if(max==0)
        return -1;
        return max;
    }
}