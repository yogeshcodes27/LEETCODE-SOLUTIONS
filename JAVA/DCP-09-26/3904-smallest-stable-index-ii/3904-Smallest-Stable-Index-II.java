class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int prefix[]=new int[nums.length];
        int suffix[]=new int[nums.length];
        prefix[0]=nums[0];
        suffix[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        suffix[i]=Math.min(nums[i],suffix[i+1]);
        for(int i=0;i<nums.length;i++){
            prefix[i]=Math.max(i==0?nums[0]:prefix[i-1],nums[i]);
            if(prefix[i]-suffix[i]<=k)
            return i;
        }
        return -1;
    }
}